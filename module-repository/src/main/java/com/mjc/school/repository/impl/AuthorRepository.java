package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {
    private final DataSource dataSource;

    @Autowired
    public AuthorRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<AuthorModel> readAll() {
        return dataSource.getAllAuthors();
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return dataSource.getAllAuthors().stream().filter(e -> Objects.equals(e.getId(), id))
                .findFirst();
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        Long id = readAll().get(readAll().size() - 1).getId() + 1L;
        entity.setId(id);
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllAuthors().add(entity);
        return entity;
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        List<AuthorModel> removeList = new ArrayList<>();
        AuthorModel author = readById(id).get();
        if (author != null) {
            removeList.add(author);
            return dataSource.getAllNews().removeAll(removeList);
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
