package com.srmasset.manager.controller;

import com.srmasset.manager.model.User;
import com.srmasset.manager.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping(path = "/manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

}
