package com.demo.openfeign.exception;

public class ServerException extends Exception {

    private int status;
    private String reason;

    public ServerException(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(Throwable cause) {
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
