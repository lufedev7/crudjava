package com.crudspring.api.Exceptions;

import org.springframework.http.HttpStatus;

public class BlogAppExceptions extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private HttpStatus status;
    private String message;

    public BlogAppExceptions(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogAppExceptions(HttpStatus status, String message, String message1) {
        this.status = status;
        this.message = message;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
