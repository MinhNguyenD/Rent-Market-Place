package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.CommentDto;
import com.mlproject.quickLease.entity.Comment;
import com.mlproject.quickLease.entity.Room;
import com.mlproject.quickLease.entity.UserEntity;
import com.mlproject.quickLease.exception.CommentNotFoundException;
import com.mlproject.quickLease.exception.RoomNotFoundException;
import com.mlproject.quickLease.exception.UserNotFoundException;
import com.mlproject.quickLease.mapper.CommentMapper;
import com.mlproject.quickLease.repository.CommentRepository;
import com.mlproject.quickLease.repository.RoomRepository;
import com.mlproject.quickLease.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<CommentDto> getAllComments() {
        return commentRepository.findAll().stream().map(commentMapper::mapToDto).toList();
    }

    @Override
    public CommentDto getComment(int id) {
        return commentMapper.mapToDto(commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment not found")));
    }

    @Override
    @Transactional
    public CommentDto createComment(CommentDto commentDto) {
        UserEntity user = userRepository.findById(commentDto.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Room room = roomRepository.findById(commentDto.getRoomId()).orElseThrow(() -> new RoomNotFoundException("Room not found"));
        Comment comment = commentMapper.mapToEntity(commentDto, user, room);
        commentRepository.save(comment);
        return commentDto;
    }

    @Override
    @Transactional
    public CommentDto updateComment(CommentDto commentDto) {
        commentRepository.findById(commentDto.getId()).orElseThrow(() -> new CommentNotFoundException("Comment not found"));
        UserEntity user = userRepository.findById(commentDto.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Room room = roomRepository.findById(commentDto.getRoomId()).orElseThrow(() -> new RoomNotFoundException("Room not found"));
        Comment comment = commentMapper.mapToEntity(commentDto, user, room);
        comment.setId(commentDto.getId());
        commentRepository.save(comment);
        return commentDto;
    }


    @Override
    @Transactional
    public void deleteComment(int id) {
        Comment comment = commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException("Comment not found"));
        commentRepository.delete(comment);
    }
}
