package dev.deathstarreactorcore.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.BasicUserInfo;
import dev.deathstarreactorcore.beans.UserMasterTable;
import dev.deathstarreactorcore.beans.auth;
import dev.deathstarreactorcore.repositories.UserRepository;

@Service
public class UserService implements WebService{
    
    @Autowired
    UserRepository ur;

    public BasicUserInfo save(UserMasterTable user) {
        return ur.save(user).getUserInfo();
    }

    public UserMasterTable getUser(String username){
		return ur.findById(username).get();
    }

    public BasicUserInfo login(String username, String password) {
        try {
            UserMasterTable user = ur.findById(username).get();
            if(user.getPassword().getCurrent().equals(password)) return user.getUserInfo();
        } catch (NoSuchElementException e) {
        	System.out.println("No such user found");
            return null;
        }
        return null;
    }

}