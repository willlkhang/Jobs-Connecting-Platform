package com.project.base.dto;

public class Result<T> {
    public int statusCode;
    public T data;

    public Object getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}