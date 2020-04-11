package dev.deathstarreactorcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.UserM;
import dev.deathstarreactorcore.repositories.UserRepository;

@Service
public class UserService implements WebService{
    
    @Autowired
    UserRepository ur;

    public UserM save(UserM user) {
        return ur.save(user);
    }

    public boolean login(String username, String password) {
       return ur.findByUsernameAndPassword(username,password) != null;
    }

}