package com.crudspring.api.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity // anotacion que indica que es una clase entidad
@Table(name ="publications",uniqueConstraints = {@UniqueConstraint(columnNames = "tittle")} )
//anotacion que indica el nombre de la tabla 
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="tittle",nullable = false)
    private String tittle;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "content",nullable = false)
    private String content;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Publication() {
        super();
        
    }
    public Publication(Long id, String tittle, String description, String content) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.content = content;
    }
    
}
