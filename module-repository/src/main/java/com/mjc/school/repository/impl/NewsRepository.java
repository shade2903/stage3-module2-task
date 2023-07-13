package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        return dataSource.getAllNews().stream()
                .filter(e-> Objects.equals(e.getId(),id)).findFirst();
    }

    @Override
    public NewsModel create(NewsModel entity) {
        Long id = readAll().get(readAll().size() - 1).getId() + 1L;
        entity.setId(id);
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().add(entity);
        return entity;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        NewsModel updatedNews = readById(entity.getId()).get();
        if(updatedNews != null) {
            updatedNews.setTitle(entity.getTitle());
            updatedNews.setContent(entity.getContent());
            updatedNews.setLastUpdateDate(entity.getLastUpdateDate());
            updatedNews.setAuthorId(entity.getAuthorId());
            return updatedNews;
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        List<NewsModel> removeList = new ArrayList<>();
        NewsModel news = readById(id).get();
        if (news  != null) {
            removeList.add(news);
            return dataSource.getAllNews().removeAll(removeList);
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return dataSource.getAllNews()
                .stream().allMatch(e-> Objects.equals(e.getId(),id));
    }
}
