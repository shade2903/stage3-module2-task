package com.mjc.school.service.validator;

import com.mjc.school.service.constants.Constants;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.InvalidDataException;
import com.mjc.school.service.exception.NotFoundException;

public class Validator {

    private void validateNumber(Long id, String parameter) {
        if (id == null || id < 1) {
            throw new InvalidDataException(
                    String.format(ErrorCode.VALIDATE_NEGATIVE_OR_NULL_NUMBER.getMessage(), parameter, parameter, id));
        }
    }


    public void validateNewsId(Long newsId, Long maxNewsId) {
        validateNumber(newsId, Constants.NEWS_ID);
        if (newsId > maxNewsId) {
            throw new InvalidDataException(
                    String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.NEWS_ID, newsId));
        }
    }

    public void validateAuthorId(Long authorId, Long max_author_id) {
        validateNumber(authorId, Constants.AUTHOR_ID);
        if (authorId > max_author_id) {
            throw new InvalidDataException(
                    String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.AUTHOR, authorId));
        }
    }

    public void validateNewsDto(NewsDtoRequest dtoRequest) {
        validateString(dtoRequest.getTitle(), Constants.NEWS_TITLE, Constants.MIN_TITLE_LENGTH, Constants.MAX_TITLE_LENGTH);
        validateString(dtoRequest.getContent(), Constants.NEWS_CONTENT, Constants.MIN_CONTENT_LENGTH, Constants.MAX_CONTENT_LENGTH);
    }

    public void validateAuthorDto(AuthorDtoRequest dtoRequest) {
        validateString(dtoRequest.getName(), Constants.AUTHOR_NAME, Constants.MIN_AUTHOR_NAME, Constants.MAX_AUTHOR_NAME);
    }

    private void validateString(String value, String parameter, int minLength, int maxLength) {
        if (value == null) {
            throw new NotFoundException(
                    String.format(ErrorCode.VALIDATE_STRING_NULL.getMessage(), parameter, parameter));
        }
        if (value.trim().length() < minLength || value.trim().length() > maxLength) {
            throw new InvalidDataException(String.format(
                    ErrorCode.VALIDATE_STRING_LENGTH.getMessage(),
                    parameter,
                    minLength,
                    maxLength,
                    value));
        }
    }

}
