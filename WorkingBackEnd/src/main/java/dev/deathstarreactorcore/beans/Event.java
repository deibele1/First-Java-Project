package dev.deathstarreactorcore.beans;

import java.time.LocalDate;

public class Event {

	// Field variables
	private int e_id;
	private int e_name;
	private LocalDate e_adVent;
	private LocalDate e_adDate;
	private int e_c_id;
	
	// No argument constructor
	public Event() {
		super();
	}
	
	// Full argument constructor
	public Event(int e_id, int e_name, LocalDate e_adVent, LocalDate e_adDate, int e_c_id) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_adVent = e_adVent;
		this.e_adDate = e_adDate;
		this.e_c_id = e_c_id;
	}

	// Getters and Setters
	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public int getE_name() {
		return e_name;
	}

	public void setE_name(int e_name) {
		this.e_name = e_name;
	}

	public LocalDate getE_adVent() {
		return e_adVent;
	}

	public void setE_adVent(LocalDate e_adVent) {
		this.e_adVent = e_adVent;
	}

	public LocalDate getE_adDate() {
		return e_adDate;
	}

	public void setE_adDate(LocalDate e_adDate) {
		this.e_adDate = e_adDate;
	}

	public int getE_c_id() {
		return e_c_id;
	}

	public void setE_c_id(int e_c_id) {
		this.e_c_id = e_c_id;
	}

	// To string
	@Override
	public String toString() {
		return "Event [e_id=" + e_id + ", e_name=" + e_name + ", e_adVent=" + e_adVent + ", e_adDate=" + e_adDate
				+ ", e_c_id=" + e_c_id + "]";
	}
	
}
