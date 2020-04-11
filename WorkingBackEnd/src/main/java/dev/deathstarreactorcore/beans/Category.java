package dev.deathstarreactorcore.beans;

public class Category {
	
	// Field variables
	private int c_id;
	private String c_name;
	
	// No argument constructor
	public Category() {
		super();
	}

	// Full argument constructor
	public Category(int c_id, String c_name) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
	}
	
	// Getters and setters
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	
	// To string
	@Override
	public String toString() {
		return "Category [c_id=" + c_id + ", c_name=" + c_name + "]";
	}

}
