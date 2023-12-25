package com.example.humanmanagement.domain;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private String statusText;
    private Integer statusCode;
    private T data;

    public static ApiResponse success() {
        return new ApiResponse(ApiResponseStatus.SUCCESS.getMessage(),ApiResponseStatus.SUCCESS.getCode(), null);
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(ApiResponseStatus.SUCCESS.getMessage(),ApiResponseStatus.SUCCESS.getCode(), data);
    }

    public static ApiResponse notFound() {
        return new ApiResponse(ApiResponseStatus.NOT_FOUND.getMessage(),ApiResponseStatus.NOT_FOUND.getCode(), null);
    }

    public static ApiResponse notFound(Object data) {
        return new ApiResponse(ApiResponseStatus.NOT_FOUND.getMessage(),ApiResponseStatus.NOT_FOUND.getCode(), data);
    }


    // 构造函数和getter、setter方法省略

    public ApiResponse() {
    }

    public ApiResponse(String statusText, Integer statusCode, T data) {
        this.statusText = statusText;
        this.statusCode = statusCode;
        this.data = data;
    }
}