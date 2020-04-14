package dev.deathstarreactorcore.beans;

public enum Question {
    Maiden("What is your mother's maiden name?"),
    Street("On what street did you grow up?"),
    Where("What is the name of your first pet?");

    private String phrase;
    Question(String phrase) {
        this.phrase = phrase;
    }
    /**
     * @return the phrase
     */
    public String getPhrase() {
        return phrase;
    }
	public static Question setByInt(int num) {
		switch(num) {
            case 0:
                return Question.Maiden;
            case 1:
                return Question.Street;
            case 2:
                return Question.Where;
            default:
                return null;
        }
	}
}
