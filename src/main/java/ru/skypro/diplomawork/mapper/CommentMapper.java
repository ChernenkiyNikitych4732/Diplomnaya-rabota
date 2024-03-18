package ru.skypro.diplomawork.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.skypro.diplomawork.dto.CommentDto;
import ru.skypro.diplomawork.dto.ResponseWrapperComment;
import ru.skypro.diplomawork.entity.Comment;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommentMapper {

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "author.id", target = "author")
    CommentDto commentToCommentDto(Comment comment);

    @Mapping(source = "pk", target = "id")
    @Mapping(source = "author", target = "author.id")
    Comment commentDtoToComment(CommentDto commentDto);

    List<Comment> commentToCommentDto(List<Comment> commentList);

    @Mapping(source = "size", target = "count")
    @Mapping(source = "commentList", target = "results")
    ResponseWrapperComment commentsListToResponseWrapperComment(Integer size, List<Comment> commentList);
}
