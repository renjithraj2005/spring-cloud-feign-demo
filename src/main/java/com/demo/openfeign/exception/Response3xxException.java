package com.demo.openfeign.exception;

public class Response3xxException extends Exception {

    private int status;
    private String reason;

    public Response3xxException(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public Response3xxException(String message) {
        super(message);
    }

    public Response3xxException(Throwable cause) {
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
        return "ClientException: "+getMessage();
    }

}
