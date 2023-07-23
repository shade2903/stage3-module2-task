package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.utils.Utils;
import com.mjc.school.controller.constants.MenuConstants;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import java.util.Scanner;

public class UpdateAuthorCommand implements Command {
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;
    private final Scanner input;

    public UpdateAuthorCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller, Scanner input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void execute() {
        AuthorDtoRequest authorRequest = new AuthorDtoRequest();
        System.out.println(MenuConstants.ENTER_AUTHOR_ID);
        Long id = Utils.inputLongNumber(input);
        System.out.println(MenuConstants.ENTER_AUTHOR_NAME);
        String name = input.nextLine();
        authorRequest.setId(id);
        authorRequest.setName(name);
        System.out.println(controller.update(authorRequest));

    }
}
