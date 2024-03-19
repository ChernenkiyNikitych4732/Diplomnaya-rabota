package ru.skypro.diplomawork.service;

import org.springframework.security.core.Authentication;
import ru.skypro.diplomawork.dto.CommentDto;
import ru.skypro.diplomawork.dto.ResponseWrapperComment;
import ru.skypro.diplomawork.entity.Comments;

public interface CommentService {

    ResponseWrapperComment getAllCommentsForAdsWithId(Long adsId);

    CommentDto createNewComment(Long adsId, CommentDto commentDto, Authentication authentication);

    CommentDto getComments(long adPk, long id);

    void deleteComments(long adPk, long id,  Authentication authentication);

    CommentDto updateComments(long adPk, long id, CommentDto commentDto, Authentication authentication);

    Comments getCommentById(long id);
}

