package dev.deathstarreactorcore.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.BasicUserInfo;
import dev.deathstarreactorcore.beans.UserMasterTable;
import dev.deathstarreactorcore.rawTypes.RawUser;
import dev.deathstarreactorcore.repositories.UserRepository;

@Service
public class UserService implements WebService{
    
    @Autowired
    UserRepository ur;

    public BasicUserInfo save(RawUser user) {
        return ur.save(user.process()).getUserInfo();
    }

    public UserMasterTable get(String username){
		return ur.findById(username).get();
    }

    public Boolean authenticate(String username, String password) {
        try {
            System.out.println(ur.findById(username).get().getPassword().getCurrent());
            if(ur.findById(username).get().getPassword().getCurrent().equals(password)) return true;
        } catch (NoSuchElementException | IllegalArgumentException e) {
        	System.out.println("No such user found");
            return false;
        }
        return false;
    }

    public BasicUserInfo login(String username, String password) {
        UserMasterTable user = ur.findById(username).get();
        System.out.println(username);
        System.out.println(password);
        if(user.getPassword().getCurrent().equals(password)) return user.getUserInfo();
        return null;
    }

}
