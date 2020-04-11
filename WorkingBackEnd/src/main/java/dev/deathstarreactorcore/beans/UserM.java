package dev.deathstarreactorcore.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserM {

	// Field Variables
	@Id
	public String username;
	public String password;
	public short type;
	public String first;
	public String middle;
	public String last;
	public String email;
	public LocalDate dob;
	public LocalDate doac;
	public int cs;
	
	public UserM() {
		super();
	}

	public UserM(String username, String password, short type, String first, String middle, String last,
			String email, LocalDate dob, LocalDate doac, int cs) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.first = first;
		this.middle = middle;
		this.last = last;
		this.email = email;
		this.dob = dob;
		this.doac = doac;
		this.cs = cs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoac() {
		return doac;
	}

	public void setDoac(LocalDate doac) {
		this.doac = doac;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", type=" + type + ", first="
				+ first + ", middle=" + middle + ", last=" + last + ", email=" + email + ", dob="
				+ dob + ", doac=" + doac + ", cs=" + cs + "]";
	}
	
	
}
