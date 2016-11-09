package com.netcracker.crm.commands;

import org.springframework.web.servlet.ModelAndView;

public interface ICommand {
    ModelAndView execute();

    ModelAndView execute(int id);
}
