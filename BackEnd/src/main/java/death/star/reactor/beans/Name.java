package death.star.reactor.beans;

public class Name {

	// Field Variables
	private boolean n_number;
	private String n_description;
	
	// No argument constructor
	public Name() {
		super();
	}

	// Full argument constructor
	public Name(boolean n_number, String n_description) {
		super();
		this.n_number = n_number;
		this.n_description = n_description;
	}

	// Getters and setters
	public boolean isN_number() {
		return n_number;
	}

	public void setN_number(boolean n_number) {
		this.n_number = n_number;
	}

	public String getN_description() {
		return n_description;
	}

	public void setN_description(String n_description) {
		this.n_description = n_description;
	}

	// To String
	@Override
	public String toString() {
		return "Name [n_number=" + n_number + ", n_description=" + n_description + "]";
	}
	
	
}
