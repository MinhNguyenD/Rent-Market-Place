package com.mlproject.quickLease.mapper;

import com.mlproject.quickLease.dto.CommentDto;
import com.mlproject.quickLease.entity.Comment;
import com.mlproject.quickLease.entity.Room;
import com.mlproject.quickLease.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source ="user")
    @Mapping(target = "room", source = "room")
    Comment mapToEntity(CommentDto commentDto, UserEntity user, Room room);

    @Mapping(target = "userId", expression = "java(comment.getUser().getUserId())")
    @Mapping(target = "roomId", expression = "java(comment.getRoom().getId())")
    CommentDto mapToDto(Comment comment);
}
