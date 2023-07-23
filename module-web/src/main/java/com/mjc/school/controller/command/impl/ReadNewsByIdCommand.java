package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.command.utils.Utils;
import com.mjc.school.controller.constants.MenuConstants;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

public class ReadNewsByIdCommand implements Command {
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller;
    private final Scanner input;

    public ReadNewsByIdCommand(BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller, Scanner input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void execute() {
        System.out.println(MenuConstants.ENTER_ID);
        System.out.println(controller.readById(Utils.inputLongNumber(input)));

    }
}
