package com.crudspring.api.Services;

import com.crudspring.api.Repository.CommentRepository;
import com.crudspring.api.Repository.PublicationRepository;
import com.crudspring.api.Models.Publication;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.crudspring.api.DTOs.CommentsDTO;
import com.crudspring.api.Models.Comments;
import com.crudspring.api.Exceptions.BlogAppExceptions;
import com.crudspring.api.Exceptions.ResourceNotFountException;

@// A service class that implements the interface CommentsServices.
Service
public class CommentsServicesimpl implements CommentsServices {
    @Autowired
    private ModelMapper modelmapper;
    @Autowired
    private CommentRepository commentrepository;
    @Autowired
    private PublicationRepository publicationrepository;

    // Creating a comment.
    @Override
    public CommentsDTO createComment(long id, CommentsDTO commentsdto) {
        Comments comments = mapEntity(commentsdto);
        Publication publication = publicationrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("publication", "id", id));
        comments.setPublication(publication);
        Comments newComments = commentrepository.save(comments);
        return mapDTO(newComments);
    }

    @Override
    public List<CommentsDTO> setCommentsforId(long id) {
        List<Comments> comments = commentrepository.findByPublicationId(id);
        return comments.stream().map(comment -> mapDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentsDTO setCommentsForIdComment(long idcomment, long idpublication) {
        Publication publication = publicationrepository.findById(idpublication)
                .orElseThrow(() -> new ResourceNotFountException("publication", "id", idpublication));

        Comments comments = commentrepository.findById(idcomment)
                .orElseThrow(() -> new ResourceNotFountException("comment", "id", idcomment));

        if (!comments.getPublication().getId().equals(publication.getId())) {
            throw new BlogAppExceptions(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicación");
        }
        return mapDTO(comments);
    }

    public CommentsDTO updateComments(long idcomment, long publicationid, CommentsDTO commentsdto) {
        Publication publication = publicationrepository.findById(publicationid)
                .orElseThrow(() -> new ResourceNotFountException("publication", "id", publicationid));

        Comments comments = commentrepository.findById(idcomment)
                .orElseThrow(() -> new ResourceNotFountException("comment", "id", idcomment));

        if (!comments.getPublication().getId().equals(publication.getId())) {
            throw new BlogAppExceptions(HttpStatus.BAD_REQUEST,
                    "El comentario no pertenece a la publicación para actualizar");
        }
        comments.setName(commentsdto.getName());
        comments.setEmail(commentsdto.getEmail());
        comments.setBody(commentsdto.getBody());
        Comments commentsUpdate = commentrepository.save(comments);
        return mapDTO(commentsUpdate);
    }

    public void deleteComment(long idPublication, long idComment) {
        Publication publication = publicationrepository.findById(idPublication)
                .orElseThrow(() -> new ResourceNotFountException("publication", "id", idPublication));

        Comments comments = commentrepository.findById(idComment)
                .orElseThrow(() -> new ResourceNotFountException("comment", "id", idComment));

        if (!comments.getPublication().getId().equals(publication.getId())) {
            throw new BlogAppExceptions(HttpStatus.BAD_REQUEST,
                    "El comentario no pertenece a la publicación para Eliminar");
        }
        commentrepository.delete(comments);
    }

    private CommentsDTO mapDTO(Comments comments) {
        CommentsDTO commentsdto = modelmapper.map(comments, CommentsDTO.class);

        return commentsdto;

    }

    private Comments mapEntity(CommentsDTO commentsdto) {
        Comments comments = modelmapper.map(commentsdto, Comments.class);

        return comments;

    }
}
