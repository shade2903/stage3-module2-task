package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.constants.Constants;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> {
    private final BaseRepository<AuthorModel, Long> authorRepository;
    private final AuthorMapper authorMapper;


    @Autowired
    public AuthorService(BaseRepository<AuthorModel, Long> authorRepository) {
        this.authorRepository = authorRepository;
        this.authorMapper = AuthorMapper.INSTANCE;
    }

    @Override
    public List<AuthorDtoResponse> readAll() {
        return authorRepository.readAll().stream().map(authorMapper::AuthorToDtoResponse).toList();

    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        Optional<AuthorModel> authorModel = authorRepository.readById(id);
        if (authorModel.isPresent()) {
            return authorMapper.AuthorToDtoResponse(authorModel.get());
        }
        throw new NotFoundException(
                String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.AUTHOR, id));
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {

        return authorMapper.AuthorToDtoResponse(
                authorRepository.create(authorMapper.AuthorFromDtoRequest(createRequest)));
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        AuthorModel updateAuthor = authorMapper.AuthorFromDtoRequest(updateRequest);
        return authorMapper.AuthorToDtoResponse(authorRepository.update(updateAuthor));
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
