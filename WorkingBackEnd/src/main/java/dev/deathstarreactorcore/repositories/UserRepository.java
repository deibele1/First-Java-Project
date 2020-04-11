package dev.deathstarreactorcore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.UserM;

@Repository
public interface UserRepository extends CrudRepository<UserM, Integer>{

    UserM findByUsernameAndPassword(String username, String password);

}