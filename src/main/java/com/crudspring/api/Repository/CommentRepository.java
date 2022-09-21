package com.crudspring.api.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspring.api.Models.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    public List<Comments> findByPublicationId(long publicationId);
}
