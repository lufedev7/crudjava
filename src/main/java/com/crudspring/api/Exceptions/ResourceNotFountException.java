package com.crudspring.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFountException extends RuntimeException {
    private static final long serialVersionUID =1L;
    private String nameresource;
    private String nameField;
    private long valueField;
    public ResourceNotFountException(String NameResource, String NameField, long ValueField){
        super(String.format("%s Not fount with : %s : '%s'",NameResource,NameField, ValueField));
        nameField = NameField;
        nameresource = NameResource;
        valueField = ValueField;

    }
    public String getNameresource() {
        return nameresource;
    }
    public void setNameresource(String nameresource) {
        this.nameresource = nameresource;
    }
    public String getNameField() {
        return nameField;
    }
    public void setNameField(String nameField) {
        this.nameField = nameField;
    }
    public long getValueField() {
        return valueField;
    }
    public void setValueField(long valueField) {
        this.valueField = valueField;
    }
    
    
}
