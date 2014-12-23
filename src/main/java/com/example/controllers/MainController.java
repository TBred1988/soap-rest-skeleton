package com.example.controllers;

import com.example.controllers.business.UserService;
import com.example.controllers.business.http.LoginResponse;
import com.example.orm.entities.User;
import com.example.orm.repositories.UserRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tibor on 2014.08.31..
 */

@Controller
public class MainController {

    private static final String LOGIN_PAGE="homepage.main";

    private static final String LIST_PAGE="homepage.list";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login(HttpServletRequest request, @RequestParam(required = false) String name){
        ModelAndView modelAndView = new ModelAndView(LOGIN_PAGE);
        modelAndView.getModel().put("name",name);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public ModelAndView login(HttpServletRequest request, @RequestParam String firstname,
                              @RequestParam String lastname, @RequestParam String password,
                              @RequestParam String email){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.saveAndFlush(user);
        List<User> users = userRepository.findAll();
        modelAndView.getModel().put("users",users);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list-users")
    public ModelAndView list(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        List<User> users = userRepository.findAll();
        modelAndView.getModel().put("users",users);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ajax/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String login(HttpServletRequest request, @RequestParam String password,
                              @RequestParam String email){
        String response = userService.getUserJson(password, email);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ModelAndView user(HttpServletRequest request, @RequestParam String password,
                              @RequestParam String email){
        return userService.selectUser(password, email);
    }




}
