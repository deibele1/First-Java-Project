package death.star.reactor.beans;

import java.time.LocalDate;

public class User {

	// Field Variables
	private String u_username;
	private long u_password;
	private short u_type;
	private String u_first;
	private String u_middle;
	private String u_last;
	private String u_email;
	private LocalDate u_dob;
	private LocalDate u_doac;
	private int u_cs;
	
	public User() {
		super();
	}

	public User(String u_username, long u_password, short u_type, String u_first, String u_middle, String u_last,
			String u_email, LocalDate u_dob, LocalDate u_doac, int u_cs) {
		super();
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_type = u_type;
		this.u_first = u_first;
		this.u_middle = u_middle;
		this.u_last = u_last;
		this.u_email = u_email;
		this.u_dob = u_dob;
		this.u_doac = u_doac;
		this.u_cs = u_cs;
	}

	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

	public long getU_password() {
		return u_password;
	}

	public void setU_password(long u_password) {
		this.u_password = u_password;
	}

	public short getU_type() {
		return u_type;
	}

	public void setU_type(short u_type) {
		this.u_type = u_type;
	}

	public String getU_first() {
		return u_first;
	}

	public void setU_first(String u_first) {
		this.u_first = u_first;
	}

	public String getU_middle() {
		return u_middle;
	}

	public void setU_middle(String u_middle) {
		this.u_middle = u_middle;
	}

	public String getU_last() {
		return u_last;
	}

	public void setU_last(String u_last) {
		this.u_last = u_last;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public LocalDate getU_dob() {
		return u_dob;
	}

	public void setU_dob(LocalDate u_dob) {
		this.u_dob = u_dob;
	}

	public LocalDate getU_doac() {
		return u_doac;
	}

	public void setU_doac(LocalDate u_doac) {
		this.u_doac = u_doac;
	}

	public int getU_cs() {
		return u_cs;
	}

	public void setU_cs(int u_cs) {
		this.u_cs = u_cs;
	}

	@Override
	public String toString() {
		return "User [u_username=" + u_username + ", u_password=" + u_password + ", u_type=" + u_type + ", u_first="
				+ u_first + ", u_middle=" + u_middle + ", u_last=" + u_last + ", u_email=" + u_email + ", u_dob="
				+ u_dob + ", u_doac=" + u_doac + ", u_cs=" + u_cs + "]";
	}
	
	
}
