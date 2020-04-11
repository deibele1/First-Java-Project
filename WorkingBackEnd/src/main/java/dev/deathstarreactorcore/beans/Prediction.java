package dev.deathstarreactorcore.beans;

import java.time.LocalDate;

public class Prediction {

	// Field Variables
	private int p_id;
	private int p_e_id;
	private String p_u_username;
	private int p_n_number;
	private LocalDate date;
	
	// No argument constructor
	public Prediction() {
		super();
	}

	// Full argument constructor
	public Prediction(int p_id, int p_e_id, String p_u_username, int p_n_number, LocalDate date) {
		super();
		this.p_id = p_id;
		this.p_e_id = p_e_id;
		this.p_u_username = p_u_username;
		this.p_n_number = p_n_number;
		this.date = date;
	}

	// Getters and setters
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getP_e_id() {
		return p_e_id;
	}

	public void setP_e_id(int p_e_id) {
		this.p_e_id = p_e_id;
	}

	public String getP_u_username() {
		return p_u_username;
	}

	public void setP_u_username(String p_u_username) {
		this.p_u_username = p_u_username;
	}

	public int getP_n_number() {
		return p_n_number;
	}

	public void setP_n_number(int p_n_number) {
		this.p_n_number = p_n_number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	// To string
	@Override
	public String toString() {
		return "Prediction [p_id=" + p_id + ", p_e_id=" + p_e_id + ", p_u_username=" + p_u_username + ", p_n_number="
				+ p_n_number + ", date=" + date + "]";
	}
	
	
}
