package dev.deathstarreactorcore.beans;

public enum UserType {
    User,
    Expert,
    Moderator,
    Admin;
	
	public static UserType iToUT(int i) {
		switch(i)
		{
		case 0: return UserType.User;
		case 1: return UserType.Expert;
		case 2: return UserType.Moderator;
		case 3: return UserType.Admin;
		default: return null;
		}
	}
	public int UTToI() {
		return this.ordinal();
	}
}
