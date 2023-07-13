package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.impl.AuthorModel;

import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorModel AuthorFromDtoRequest(AuthorDtoRequest request);
   AuthorDtoResponse NewsToDtoResponse(AuthorModel model);

}
