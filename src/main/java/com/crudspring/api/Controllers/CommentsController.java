package com.crudspring.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.crudspring.api.DTOs.CommentsDTO;
import com.crudspring.api.Services.CommentsServices;

@RestController
@RequestMapping("/api/")
public class CommentsController {
    @Autowired
    private CommentsServices commentservices;

    @GetMapping("/publication/{publicationid}/comments")
    public List<CommentsDTO> getCommentforPublication(@PathVariable(value = "publicationid") long publicationid) {
        return commentservices.setCommentsforId(publicationid);
    }

    @GetMapping("/publication/{idpublication}/comments/{commentid}")
    public ResponseEntity<CommentsDTO> getCommentforId(@PathVariable(value = "commentid") long commentid,
            @PathVariable(value = "idpublication") long idpublication) {
        CommentsDTO commentsdto = commentservices.setCommentsForIdComment(commentid, idpublication);
        return new ResponseEntity<>(commentsdto, HttpStatus.OK);
    }

    @PutMapping("/publication/{idpublication}/comments/{commentid}")
    public ResponseEntity<CommentsDTO> updateComment(@PathVariable(value = "commentid") long commentid,
            @PathVariable(value = "idpublication") long idpublication,
            @RequestBody CommentsDTO commentsdtoupdate) {
        CommentsDTO commentsupdate = commentservices.updateComments(commentid, idpublication, commentsdtoupdate);
        return new ResponseEntity<>(commentsupdate, HttpStatus.OK);
    }

    @PostMapping("/publication/{id}/comments")
    public ResponseEntity<CommentsDTO> saveComments(@PathVariable(value = "id") long id,
            @RequestBody CommentsDTO commentsdto) {
        return new ResponseEntity<>(commentservices.createComment(id, commentsdto), HttpStatus.CREATED);
    }

    @DeleteMapping("/publication/{idpublication}/comments/{commentid}")
    public ResponseEntity<String> deleteComments(@PathVariable(value = "commentid") long commentid,
            @PathVariable(value = "idpublication") long idpublication) {
        commentservices.deleteComment(idpublication, commentid);
        return new ResponseEntity<>("Comment delete forever", HttpStatus.OK);
    }

}
