package com.crudspring.api.DTOs;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CommentsDTO {
    private long id;
    @NotEmpty
    @Size(min = 2, message = "El nombre del comentario deberia tener al menos 2 caracteres")
    private String name;
    @Email
    @NotEmpty(message = "El email no debe de estar vacio")
    @Size(min = 2, message = "El email de la publicacion deberia tener al menos 2 caracteres")
    private String email;
    @NotEmpty
    @Size(min = 10, message = "El titulo de la publicacion deberia tener al menos 10 caracteres")
    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public CommentsDTO() {
        super();
    }

}
