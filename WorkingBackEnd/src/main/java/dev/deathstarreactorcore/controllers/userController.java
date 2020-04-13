package dev.deathstarreactorcore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.deathstarreactorcore.beans.BasicUserInfo;
import dev.deathstarreactorcore.beans.auth;
import dev.deathstarreactorcore.services.UserService;

@RestController
public class userController {

    @Autowired
    UserService us;

    @RequestMapping(value="user/login", method=RequestMethod.POST, consumes="application/json")
    public BasicUserInfo login(@RequestBody auth auth) {
        return us.login(auth.username, auth.password);
    }

    @RequestMapping(value="user/newUser", method=RequestMethod.POST, consumes="application/json")
    public BasicUserInfo requestMethodName(@RequestBody dev.deathstarreactorcore.rawTypes.RawUser user) {
        return us.save(user.process());
    }
    
}