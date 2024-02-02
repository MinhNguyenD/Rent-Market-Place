package com.mlproject.quickLease.repository;

import com.mlproject.quickLease.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
