package dev.deathstarreactorcore.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.AdminUsers;
import dev.deathstarreactorcore.beans.UserMasterTable;

@Repository
public interface AdminUsersRepository extends CrudRepository<AdminUsers, Integer>{

	// Get individual Admin
	public AdminUsers getAdminUsersByAdminId(int adminId);
	
	// Gets Admin account associated with user account
	public AdminUsers getAdminUsersByBasicAccount(UserMasterTable BasicAccount);
	
	// Get all Admins
	public List<AdminUsers> findAll();
}
