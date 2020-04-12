package dev.deathstarreactorcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.BasicUserInfo;
import dev.deathstarreactorcore.beans.UserMasterTable;
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
        UserMasterTable user = ur.findById(username).get();
        if(user.getPassword().getCurrent() == password) return user.getUserInfo();
        return null;
    }

}