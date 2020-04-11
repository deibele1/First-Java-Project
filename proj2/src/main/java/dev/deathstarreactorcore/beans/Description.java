package dev.deathstarreactorcore.beans;

public class Description {

	// Field Variables
	private int d_e_id;
	private String d_text;
	
	// No argument constructor
	public Description() {
		super();
	}

	// Full argument constructor
	public Description(int d_e_id, String d_text) {
		super();
		this.d_e_id = d_e_id;
		this.d_text = d_text;
	}

	// Getters and setters
	public int getD_e_id() {
		return d_e_id;
	}

	public void setD_e_id(int d_e_id) {
		this.d_e_id = d_e_id;
	}

	public String getD_text() {
		return d_text;
	}

	public void setD_text(String d_text) {
		this.d_text = d_text;
	}

	// To string
	@Override
	public String toString() {
		return "Description [d_e_id=" + d_e_id + ", d_text=" + d_text + "]";
	}
}
