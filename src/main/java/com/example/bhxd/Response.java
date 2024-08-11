package com.example.bhxd;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Response<T> {
    private T data;
    private int code;
    private String msg;

    public Response(T date, String msgs) {
        data = date;
        code = 200;
        msg = msgs;
    }

    public Response(int codes, String msgs) {
        code = codes;
        msg = msgs;
    }

    public static Response OK() {
        return new Response("OK", "操作成功");
    }

    public static Response OK(String msgs) {
        return new Response("OK", msgs);
    }

    public static <K> Response OK(K date, String msgs) {
        return new Response(date, msgs);
    }

    public static Response NO() {
        return new Response("NO", "操作失败");
    }

    public static Response NO(String msgs) {
        return new Response("NO", msgs);
    }

    public static Response NO(int codes, String msgs) {
        return new Response(codes, msgs);
    }
}
