package dev.deathstarreactorcore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.Login;

@Repository
public interface LogingRepository extends CrudRepository<Login, Integer>{

	// For login
	public Login getLoginByLid(int lid);
}
