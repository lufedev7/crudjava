package com.crudspring.api.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comments> comments = new HashSet<>();

    // Esta anotacion se utiliza para la relacion uno a muchos, y el removal, para
    // cuando
    // se elimine un elemento de publication este eliminte los registros
    // relacionados a este
    // y el set es una clase de java, esta la utilizamos aqui porque
    // vamos a retornar muchos comentarios de una sola publicacion, es por esto que
    // creamos este tipo de arreglo.
    /////////////////////////////////////////////////////////////////
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
