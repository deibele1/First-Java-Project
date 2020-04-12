package dev.deathstarreactorcore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.UserMasterTable;

@Repository
public interface UserRepository extends CrudRepository<UserMasterTable, String>{

}