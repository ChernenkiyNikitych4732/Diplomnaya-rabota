package ru.skypro.diplomawork.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapperComment {
    private int count;
    private List<CommentDto> results;
}
