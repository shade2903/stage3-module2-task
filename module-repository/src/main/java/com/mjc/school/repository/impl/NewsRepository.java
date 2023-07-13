package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel,Long> {
    private final DataSource dataSource;

    @Autowired
    public NewsRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public List<NewsModel> readAll() {
        return dataSource.getAllNews();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public NewsModel create(NewsModel entity) {
        return null;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
