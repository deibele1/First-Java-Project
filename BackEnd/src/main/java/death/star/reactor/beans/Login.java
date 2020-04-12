package death.star.reactor.beans;

public class Login {

	// Field Variables
	private int l_id;
	private String l_u_username;
	
	// No argument constructor
	public Login() {
		super();
	}

	// Full argument constructor
	public Login(int l_id, String l_u_username) {
		super();
		this.l_id = l_id;
		this.l_u_username = l_u_username;
	}

	// Getters and Setters
	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getL_u_username() {
		return l_u_username;
	}

	public void setL_u_username(String l_u_username) {
		this.l_u_username = l_u_username;
	}

	// To string
	@Override
	public String toString() {
		return "Login [l_id=" + l_id + ", l_u_username=" + l_u_username + "]";
	}
	
	
}
