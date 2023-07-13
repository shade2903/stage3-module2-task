package com.mjc.school.repository;

import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.repository.impl.NewsRepository;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.repository.utils.Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mjc.school.repository"})
public class Main {
    private static final String PATH_AUTHOR = "authors";
    private static final String PATH_CONTENT = "content";
    private static final String PATH_NEWS = "news";
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        AuthorRepository authorRepository = context.getBean("authorRepository", AuthorRepository.class);
        authorRepository.readAll().stream().forEach(System.out::println);
        System.out.println(Utils.readResourceFile(PATH_AUTHOR));
//        NewsRepository newsRepository = context.getBean("newsRepository", NewsRepository.class);
//        newsRepository.


    }
}
