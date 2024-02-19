package com.acciojobSpringMock2.APIproblem.Service;

import com.acciojobSpringMock2.APIproblem.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(User user)
    {
        userRepository.save(user);
        return "user saved to db";
    }
}
