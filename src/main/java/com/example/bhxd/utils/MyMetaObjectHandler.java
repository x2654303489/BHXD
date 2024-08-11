package com.example.bhxd.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        Timestamp currentTime = Timestamp.from(now.toInstant());
        System.out.println("currentTime: " + currentTime);
        this.setFieldValByName("create_time", currentTime, metaObject);
        this.setFieldValByName("update_time", currentTime, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        Timestamp currentTime = Timestamp.from(now.toInstant());
        System.out.println("currentTime: " + currentTime);
        this.setFieldValByName("update_time", currentTime, metaObject);
    }
}
