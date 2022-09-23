package com.crudspring.api.DTOs;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.crudspring.api.Models.Comments;
public class PublicationDTO {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "El titulo de la publicacion deberia tener al menos 2 caracteres")
    private String tittle;
    @NotEmpty
    @Size(min = 10, message = "El contenido de la publicacion deberia tener al menos 10 caracteres")
    private String content;
    @NotEmpty
    @Size(min = 10, message = "la descripcion de la publicacion deberia tener al menos 10 caracteres")
    private String description;

    private Set<Comments> comments;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTittle() {
        return tittle;
    }
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public PublicationDTO() {
        super();
    }
    

}
