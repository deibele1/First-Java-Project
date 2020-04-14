package dev.deathstarreactorcore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.QAs;
import dev.deathstarreactorcore.beans.UserMasterTable;

@Repository
public interface UserRepository extends CrudRepository<UserMasterTable, String>{

	// For login
	public UserMasterTable getUserMasterTableByEmail(String email);
	
	// For login
	public UserMasterTable getUserMasterTableByUsername(String username);
	
	// Account Recovery
	public UserMasterTable getUserMasterTableBySecurity(QAs security);
}