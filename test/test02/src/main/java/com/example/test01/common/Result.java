package com.example.test01.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
    private Integer code = 200;
    private String msg;
    private Long total = 0L;
    private Object data;
    public static final Result OPERATE_SUCCESS = new Result();
    public static final Result OPERATE_FAILURE = new Result(-1, "操作失败");
    public static final Result DATA_FORMAT_ERROR = new Result(-1, "数据格式错误");

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 给查询用
     *
     * @param total 总记录数
     * @param data  分页之后的数据
     */
    public Result(Long total, Object data) {
        this.total = total;
        this.data = data;
    }
}
