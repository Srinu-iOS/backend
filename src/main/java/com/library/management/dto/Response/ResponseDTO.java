package com.library.management.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO {
    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseDTO success() {
        ResponseDTO result = new ResponseDTO();
        result.setCode(HttpResponseCode.SUCCESS);
        return result;
    }

    public static ResponseDTO success(Object data) {
        ResponseDTO result = new ResponseDTO();
        result.setCode(HttpResponseCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
