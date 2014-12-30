package com.example.controllers.business;

import com.example.controllers.business.http.LoginResponse;
import com.example.orm.entities.User;
import com.example.orm.entities.UserPoint;
import com.example.orm.repositories.UserPointRepository;
import com.example.orm.repositories.UserRepository;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by user on 2014.09.18..
 */

@Component
public class UserService {

    private static final String USER_PAGE = "homepage.showone";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPointRepository userPointRepository;

    public User getUser(String password, String email) {
        List<User> users = userRepository.findAll();
        if (users != null) {
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    public ModelAndView selectUser(String password, String email) {
        User user = getUser(password, email);
        ModelAndView modelAndView = new ModelAndView(USER_PAGE);
        modelAndView.getModel().put("user", user);
        return modelAndView;
    }

    public String getUserJson(String password, String email) {
        String response = null;
        try {
            LoginResponse loginResponse = new LoginResponse();
            User user = getUser(password, email);
            if (user != null) {
                loginResponse.setStatusCode(HttpStatus.OK.toString());
                loginResponse.setMessage("User found");
            } else {
                loginResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
                loginResponse.setMessage("User not found");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.writeValueAsString(loginResponse);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return response;
    }

    public UserPoint getUserPoints(String password, String email) {
        UserPoint response = null;
        User user = getUser(password, email);
        if (user != null) {
            List<UserPoint> userPoints = userPointRepository.findByUserId(user.getId());
            if (userPoints != null && !userPoints.isEmpty()) {
                response = userPoints.get(0);
            }
        }

        return response;
    }

}
