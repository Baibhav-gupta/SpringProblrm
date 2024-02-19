package com.acciojobSpringMock2.APIproblem.Controller;

import com.acciojobSpringMock2.APIproblem.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
