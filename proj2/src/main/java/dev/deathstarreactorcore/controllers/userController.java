package dev.deathstarreactorcore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.deathstarreactorcore.beans.UserM;
import dev.deathstarreactorcore.services.UserService;

@RestController
public class userController {

    @Autowired
    UserService us;

    @RequestMapping(value="user/login", method=RequestMethod.POST, consumes="application/json")
    public boolean login(@RequestBody dev.deathstarreactorcore.beans.UserM user) {
        return us.login(user.getUsername(), user.getPassword());
    }

    @RequestMapping(value="user/newUser", method=RequestMethod.POST, consumes="application/json")
    public UserM requestMethodName(@RequestBody UserM user) {
        return us.save(user);
    }
    
}