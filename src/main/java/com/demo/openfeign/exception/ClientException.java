package com.demo.openfeign.exception;

public class ClientException extends Exception {

    private int status;
    private String reason;

    public ClientException(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public ClientException(String message) {
        super(message);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }

    public int getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "BadRequestException: "+getMessage();
    }

}
