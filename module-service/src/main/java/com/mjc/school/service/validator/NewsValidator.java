package com.mjc.school.service.validator;

import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.InvalidDataException;
import com.mjc.school.service.exception.NotFoundException;

import java.util.zip.DataFormatException;

public class NewsValidator {

    private static final Integer MIN_AUTHOR_NAME = 5;

    private static final Integer MAX_AUTHOR_NAME = 5;
    private static final Integer MIN_TITLE_LENGTH = 5;
    private static final Integer MAX_TITLE_LENGTH = 30;
    private static final Integer MIN_CONTENT_LENGTH = 5;
    private static final Integer MAX_CONTENT_LENGTH = 255;
    private static final Long MAX_AUTHOR_ID = 20L;

    private static final String NEWS_ID = "News id";

    private static final String AUTHOR_ID = "Author id";
    private static final String AUTHOR = "Author";
    private static final String AUTHOR_NAME = "Author name";
    private static final String NEWS_TITLE = "News title";
    private static final String NEWS_CONTENT = "News content";


    private void validateNumber(Long id, String parameter) {
        if (id == null || id < 1) {
            throw new InvalidDataException(
                    String.format(ErrorCode.VALIDATE_NEGATIVE_OR_NULL_NUMBER.getMessage(), parameter, parameter, id));
        }
    }


    public void validateNewsId(Long newsId, Long maxNewsId){
        validateNumber(newsId,NEWS_ID);
        if (newsId > maxNewsId) {
            throw new InvalidDataException(
                    String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), NEWS_ID, newsId));
        }
    }
    public void validateAuthorId(Long authorId, Long max_author_id) {
        validateNumber(authorId, AUTHOR_ID);
        if (authorId > max_author_id) {
            throw new InvalidDataException(
                    String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), AUTHOR, authorId));
        }
    }

    public void validateNewsDto(NewsDtoRequest dtoRequest){
        validateString(dtoRequest.getTitle(),NEWS_TITLE, MIN_TITLE_LENGTH, MAX_TITLE_LENGTH);
        validateString(dtoRequest.getContent(),NEWS_CONTENT, MIN_CONTENT_LENGTH, MAX_CONTENT_LENGTH);
    }

    public void validateAuthorDto(AuthorDtoRequest dtoRequest){
        validateString(dtoRequest.getName(),AUTHOR_NAME,MIN_AUTHOR_NAME, MAX_AUTHOR_NAME);
    }

    private void validateString(String value, String parameter, int minLength, int maxLength) {
        if (value == null) {
            throw new NotFoundException(
                    String.format(ErrorCode.VALIDATE_STRING_NULL.getMessage(), parameter, parameter));
        }
        if(value.trim().length() < minLength || value.trim().length() > maxLength){
            throw new InvalidDataException(String.format(
                    ErrorCode.VALIDATE_STRING_LENGTH.getMessage(),
                    parameter,
                    minLength,
                    maxLength,
                    value));
        }
    }

}
