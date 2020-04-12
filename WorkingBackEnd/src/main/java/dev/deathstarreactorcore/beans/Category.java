package dev.deathstarreactorcore.beans;


public enum Category {
	Politics,
	Economics,
	Sports,
	Environment,
	Technology;
	public static Category getById(int cat) {
		switch(cat) {
			case 1:
				return Category.Politics;
			case 2:
				return Category.Economics;
			case 3:
				return Category.Sports;
			case 4:
				return Category.Environment;
			case 5:
				return Category.Technology;
			default:
				return null;
		}
	}
}
