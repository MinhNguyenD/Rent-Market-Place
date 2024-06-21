package com.mlproject.quickLease.dto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    private int id;

    @NotNull
    private int roomId;

    @NotNull
    private int userId;

    @NotNull(message = "Comment date cannot be null")
    private Date commentDate;

    @Lob
    @NotBlank(message = "Comment content cannot be null or empty")
    private String content;
}
