package com.paulo.alecio.javagpt.dto;

public class ResponseBody<T>
{

    private T data;


    private String message;

    public T getData () {
        return this.data;
    }

    public void setData (
        T data
    ) {
        this.data = data;
    }

    public String getMessage () {
        return this.message;
    }

    public void setMessage (
        String message
    ) {
        this.message = message;
    }
}
