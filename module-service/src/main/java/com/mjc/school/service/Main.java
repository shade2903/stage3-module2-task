package com.mjc.school.service;

import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.impl.AuthorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        AuthorService authorService = applicationContext.getBean(AuthorService.class);

        authorService.readAll().stream().forEach(System.out::println);
        System.out.println(authorService.readById(12L));
        AuthorDtoRequest authorDtoRequest = new AuthorDtoRequest();
        authorDtoRequest.setName("Вася");
        System.out.println(authorService.create(authorDtoRequest));
        AuthorDtoRequest authorDtoRequest2 = new AuthorDtoRequest();
        authorDtoRequest2.setName("Иван");
        authorDtoRequest2.setId(2l);

        System.out.println(authorService.update(authorDtoRequest2));
    }
}
