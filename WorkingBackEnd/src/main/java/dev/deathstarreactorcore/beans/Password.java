package dev.deathstarreactorcore.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Password {
    public Password(){super();}
    private String currentP;
    private String onePastP;
    private String twoPastP;
    public Password(String password) {
        this.currentP = password;
    }
    
    //Also validly sets the password
	public boolean changePassword(String newPass) {
        if(newPass != currentP || newPass != onePastP || newPass != twoPastP) {
            twoPastP = onePastP;
            onePastP = currentP;
            currentP = newPass;
            return true;
        }
        return false;
    }
    public String getCurrent() {
        return this.currentP;
    }
}
