package edu.ali.product_api.controllers;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorHolder {
    private String error;
    private int status;
    private LocalDateTime timestamp;
    private String path;
    private String exception;
    private List<String> errors;

    public ErrorHolder() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorHolder(String error, int status, String path, String exception) {
        this.error = error;
        this.status = status;
        this.path = path;
        this.exception = exception;
        this.timestamp = LocalDateTime.now();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
