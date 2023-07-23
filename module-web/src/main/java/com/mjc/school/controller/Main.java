package com.mjc.school.controller;


import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.impl.AuthorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        AuthorController authorController = applicationContext.getBean(AuthorController.class);
        NewsController newsController = applicationContext.getBean(NewsController.class);


        authorController.readAll().stream().forEach(System.out::println);

        System.out.println(authorController.readById(10L));
        AuthorDtoRequest authorDtoRequest = new AuthorDtoRequest();
        authorDtoRequest.setName("Maink");
        System.out.println(authorController.create(authorDtoRequest));
        AuthorDtoRequest authorDtoRequest2 = new AuthorDtoRequest();
        authorDtoRequest2.setName("IVANk");
        authorDtoRequest2.setId(2l);

        System.out.println(authorController.update(authorDtoRequest2));
        System.out.println(authorController.deleteById(2l));
        authorController.readAll().stream().forEach(System.out::println);
        authorController.readById(31l);

        System.out.println("_____________________________________________________");

        newsController.readAll().stream().forEach(System.out::println);

        System.out.println(newsController.readById(3l));
        System.out.println("__________");
        System.out.println(newsController.deleteById(19l));
        System.out.println("__________");
        newsController.readAll().stream().forEach(System.out::println);


    }
}
