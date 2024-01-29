package com.mlproject.quickLease.Repositories;

import com.mlproject.quickLease.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
