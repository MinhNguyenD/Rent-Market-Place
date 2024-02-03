package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> getAllComments();
    public CommentDto getComment(int id);
    public CommentDto createComment(CommentDto commentDto);
    public CommentDto updateComment(CommentDto commentDto);

    public void deleteComment(int id);
}
