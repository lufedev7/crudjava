package com.crudspring.api.Services;

import java.util.List;
import com.crudspring.api.DTOs.CommentsDTO;

public interface CommentsServices {

    public CommentsDTO createComment(long id, CommentsDTO commentsdto);

    public List<CommentsDTO> setCommentsforId(long id);

    public CommentsDTO setCommentsForIdComment(long idcomment, long idpublication);

    public CommentsDTO updateComments(long commentsid, long publicationid, CommentsDTO commentsdto);

    public void deleteComment(long idPublication, long idComment);
}
