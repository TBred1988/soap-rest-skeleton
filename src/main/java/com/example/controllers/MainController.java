package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Márta on 2014.08.31..
 */

@Controller
public class MainController {

    private static final String LOGIN_PAGE="homepage.main";

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login(HttpServletRequest request, @RequestParam String name){
        ModelAndView modelAndView = new ModelAndView(LOGIN_PAGE);
        modelAndView.getModel().put("name",name);
        return modelAndView;
    }

}
