package dev.deathstarreactorcore.rawTypes;

import java.sql.Date;

import dev.deathstarreactorcore.beans.UserMasterTable;

public class RawUser implements Raw{
	public String username;
    public String first;
    public String last;
    public String email;
    public Date dob;
    public String password;
    public String ans1;
    public String ans2;
    public String ans3;
    public int questionNum1;
    public int questionNum2;
    public int questionNum3;
    @Override
    public UserMasterTable process() {
        return new UserMasterTable(this.username, this.first,this.last,this.email,this.dob,this.password,this.ans1,this.ans2,this.ans3,this.questionNum1,this.questionNum2,this.questionNum3);
    }
}