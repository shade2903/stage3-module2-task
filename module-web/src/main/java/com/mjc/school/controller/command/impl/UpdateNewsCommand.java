package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.utils.Utils;
import com.mjc.school.controller.constants.MenuConstants;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

public class UpdateNewsCommand implements Command {

    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller;
    private final Scanner input;

    public UpdateNewsCommand(BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller, Scanner input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void execute() {
        NewsDtoRequest newsDtoRequest = new NewsDtoRequest();
        System.out.println(MenuConstants.ENTER_ID);
        Long id = Utils.inputLongNumber(input);
        System.out.println(MenuConstants.ENTER_TITLE);
        String title = input.nextLine();
        System.out.println(MenuConstants.ENTER_CONTENT);
        String content = input.nextLine();
        System.out.println(MenuConstants.ENTER_AUTHOR_ID);
        Long authorId = Utils.inputLongNumber(input);
        newsDtoRequest.setAuthorId(id);
        newsDtoRequest.setTitle(title);
        newsDtoRequest.setContent(content);
        newsDtoRequest.setAuthorId(authorId);
        System.out.println(controller.create(newsDtoRequest));

    }
}
