package com.example.bhxd.utils;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Slf4j
@Component
public class CacheClientUtills {
    private static final AbstractExecutorService CACHE_REBUILD_EXECUTOR = null;
    private final StringRedisTemplate stringRedisTemplate;


    public CacheClientUtills(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void set(String key, Object value, Long time, TimeUnit unit) {
        String jsonString = JSON.toJSONString(value); // 使用 Fastjson 序列化
        stringRedisTemplate.opsForValue().set(key, jsonString, time, unit);
    }

    public void setWithTime(String key, Object value, Long time) {
        RedisData redisData = new RedisData();
        redisData.setData(value);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(time));
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(redisData));
    }
    public <T> T get(String key, Class<T> type) {
        String json = stringRedisTemplate.opsForValue().get(key);
        if (StrUtil.isBlank(json)) {
            return null;
        }
        return JSON.parseObject(json, type);
    }

    /**
     * 通过传递参数查询数据，如果数据不存在则通过提供的函数生成数据并缓存。
     *
     * @param keyPrefix 缓存键的前缀。
     * @param id        查询参数，其键值对将被用于构建缓存键。
     * @param type      查询结果的类型。
     * @param function  用于根据参数生成查询结果的函数。
     * @param time      缓存的时间。
     * @param unit      缓存时间的单位。
     * @param <T>       查询结果的类型参数。
     * @param <K>       参数映射的类型参数，必须继承自Map。
     * @return 缓存或新生成的查询结果。
     */
    public <T, K> T queryWithPassThrough(String keyPrefix, K id, Class<T> type, Function<K, T> function, Long time, TimeUnit unit) {
        // 根据keyPrefix和params构建唯一的缓存键


        String key = keyPrefix + id;

        // 尝试从缓存中获取已有的数据
        String json = stringRedisTemplate.opsForValue().get(key);

        // 如果缓存中存在数据，则解析并返回
        if (StringUtils.hasText(json)) {
            System.out.println(JSON.parseObject(json, type));
            return JSON.parseObject(json, type);

        } else {
            // 如果缓存中不存在数据，则通过提供的函数生成数据
            T t = function.apply(id);
            // 如果生成的数据为null，则缓存一个空值表示，并返回null
            if (t == null) {
                stringRedisTemplate.opsForValue().set(key, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
                return null;
            } else {
                // 如果生成的数据不为null，则缓存数据并返回
                set(key, t, time, unit);
                return t;
            }
        }

    }

    public <T, K extends Map<String, Object>> List<T> queryWithPassThroughlist(String keyPrefix, K params, Class<T> type, Function<K, T> function, Long time, TimeUnit unit) {
        // 根据keyPrefix和params构建唯一的缓存键
        StringBuilder keyBuilder = new StringBuilder(keyPrefix);
        params.forEach((k, v) -> keyBuilder.append(v).append(":"));
        String key = keyBuilder.toString();

        // 尝试从缓存中获取已有的数据
        String json = stringRedisTemplate.opsForValue().get(key);

        // 如果缓存中存在数据，则解析并返回
        if (StringUtils.hasText(json)) {
            return (List<T>) JSON.parseObject(json, type);
        } else {
            // 如果缓存中不存在数据，则通过提供的函数生成数据
            T t = function.apply(params);
            // 如果生成的数据为null，则缓存一个空值表示，并返回null
            if (t == null) {
                stringRedisTemplate.opsForValue().set(key, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
                return null;
            } else {
                // 如果生成的数据不为null，则缓存数据并返回
                set(key, t, time, unit);
                return (List<T>) t;
            }
        }

    }

    public <T, K> T queryWithLogicalExpire(String keyPrefix, K id, Class<T> type, Function<K, T> function, Long time, TimeUnit unit) {
        String key = keyPrefix + id;
        String json = stringRedisTemplate.opsForValue().get(key);
        if (StrUtil.isBlank(json)) {
            return null;
        }

        // 解析RedisData对象
        RedisData redisData = JSON.parseObject(json, RedisData.class);
        T t = JSON.parseObject((String) redisData.getData(), (Type) type);
        LocalDateTime expireTime = (LocalDateTime) redisData.getExpireTime();
        if (expireTime.isAfter(LocalDateTime.now())) {
            // 如果未过期，直接返回缓存数据
            return t;
        }
        // 如果已过期，需要重构缓存
        String lockKey = RedisConstants.LOCK_SHOP_KEY + key;
        boolean isLock = tryLock(lockKey);
        if (isLock) {
            //开启独立线程刷新缓存
            CACHE_REBUILD_EXECUTOR.submit(() -> {
                try {
                    T newT = function.apply(id);
                    set(key, newT, time, unit);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    unlock(lockKey);
                }
            });
        }
        return t;


    }

    private boolean tryLock(String key) {
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 10, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(flag);
    }

    private void unlock(String key) {
        stringRedisTemplate.delete(key);
        log.info("释放锁成功");
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class RedisData {
    private Object data;
    private LocalDateTime expireTime;
}