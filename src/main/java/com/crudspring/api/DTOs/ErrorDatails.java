package com.crudspring.api.DTOs;

import java.util.Date;

public class ErrorDatails {
    private Date brandDate;
    private String message;
    private String details;

    public Date getBrandDate() {
        return brandDate;
    }

    public void setBrandDate(Date brandDate) {
        this.brandDate = brandDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ErrorDatails(Date brandDate, String message, String details) {
        this.brandDate = brandDate;
        this.message = message;
        this.details = details;
    }

}
