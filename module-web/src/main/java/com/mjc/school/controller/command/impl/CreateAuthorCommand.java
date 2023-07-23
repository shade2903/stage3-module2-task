package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.constants.MenuConstants;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import java.util.Scanner;

public class CreateAuthorCommand implements Command {
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;
    private final Scanner input;

    public CreateAuthorCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller, Scanner input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void execute() {
        System.out.println(MenuConstants.ENTER_AUTHOR_NAME);
        String name = input.nextLine();
        AuthorDtoRequest authorDtoRequest = new AuthorDtoRequest();
        authorDtoRequest.setName(name);
        System.out.println(controller.create(authorDtoRequest));
    }
}
