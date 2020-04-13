package dev.deathstarreactorcore.beans;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public class BasicUserInfo implements Persistant{

	// Field Variables
	private String username;
	@Enumerated
	private UserType type;
	private int cs; //credibility score

	/**
	 * @return the cs
	 */
	public int getCs() {
		return cs;
	}
	/**
	 * @param cs the cs to set
	 */
	public void setCs(int cs) {
		this.cs = cs;
	}
	/**
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
}
