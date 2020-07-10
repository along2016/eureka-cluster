package com.example.result;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

public class ResultMessage<T> {
    private static String SUCCESS = "操作成功";
    private static String ERROR = "操作失败";
    public static int OK = 0;
    public static int FAIL = 1;

    @ApiModelProperty(value = "提示信息", name = "message", example = "操作成功")
    protected String message;

    @ApiModelProperty(value = "数据", name = "data")
    protected T data;

    @ApiModelProperty(value = "状态码", name = "status")
    protected int status;

    @ApiModelProperty(value = "时间戳", name = "timestamp")
    private Timestamp timestamp;

    public static <T> ResultMessage<T> success() {
        return success(OK, SUCCESS, null);
    }

    public static <T> ResultMessage<T> success(T data) {
        return success(OK, SUCCESS, data);
    }

    public static <T> ResultMessage<T> success(String message, T data) {
        return success(OK, message, data);
    }

    public static <T> ResultMessage<T> success(int status, String message) {
        return success(status, message, null);
    }

    public static <T> ResultMessage<T> success(int status, String message, T data) {
        return (new ResultMessage()).data(data).message(message).putTimeStamp().status(status);
    }

    public ResultMessage<T> message(String message) {
        this.message = message;
        return this;
    }

    public static <T> ResultMessage<T> error() {
        return error(FAIL, ERROR, null);
    }

    public static <T> ResultMessage<T> error(String message) {
        return error(FAIL, message, null);
    }

    public static <T> ResultMessage<T> error(int status, String message) {
        return error(status, message, null);
    }

    public static <T> ResultMessage<T> error(int status, String message, T data) {
        ResultMessage<T> responseMessage = new ResultMessage();
        responseMessage.message = message;
        responseMessage.status(status);
        responseMessage.data(data);
        return responseMessage.putTimeStamp();
    }

    public static <T> ResultMessage<T> create(int status, String message, T data) {
        return (new ResultMessage()).data(data).message(message).status(status).putTimeStamp();
    }

    public ResultMessage<T> data(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return this.data;
    }

    private ResultMessage<T> putTimeStamp() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        return this;
    }

    public ResultMessage<T> status(int status) {
        this.status = status;
        return this;
    }

    public ResultMessage() {
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
