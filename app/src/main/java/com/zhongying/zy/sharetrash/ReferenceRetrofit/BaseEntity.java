package com.zhongying.zy.sharetrash.ReferenceRetrofit;

import java.io.Serializable;

public class BaseEntity<E> implements Serializable {
    private int code;
    private String desc;
    private E data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return desc;
    }

    public void setMessage(String message) {
        this.desc = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
