package com.vaccnow.sample.error;

public class BadRequestException extends RuntimeException{

    private String code;

    public BadRequestException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
