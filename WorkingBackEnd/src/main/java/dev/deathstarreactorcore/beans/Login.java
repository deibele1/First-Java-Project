package dev.deathstarreactorcore.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Login implements Persistant{
	public Login(){super();}
	// Field Variables
	@Id
	private int lid;
	@ManyToOne
	private UserMasterTable user;
}
