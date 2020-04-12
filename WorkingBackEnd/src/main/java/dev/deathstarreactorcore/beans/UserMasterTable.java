package dev.deathstarreactorcore.beans;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserMasterTable implements Persistant{
    public UserMasterTable(){super();}
    @Id
    @GeneratedValue
    private int userNumber;
    @Embedded
    private BasicUserInfo userInfo;
    private String firstN;
	private String middleN;
	private String lastN;
	private String email;
	private Date dob;
	private Date doac; //date of account creation
    @Embedded
    private Password password;
    @Embedded
    private QAs security;
    @Enumerated
    private UserType userType;

    //multistage constructor
    public UserMasterTable(String first, String last,String email, Date dob, String password, String ans1, String ans2, String ans3, int questionNum1, int questionNum2, int questionNum3) {
        this.firstN=first;
        this.lastN=last;
        this.email=email;
        this.dob = dob;
        this.doac = Date.valueOf(LocalDate.now());
        this.password = new Password(password);
        this.security = new QAs(ans1, ans2, ans3, questionNum1, questionNum2, questionNum3);
        this.userType = UserType.User;
    }

    /**
     * @return the doac
     */
    public Date getDoac() {
        return doac;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the firstN
     */
    public String getFirstN() {
        return firstN;
    }

    /**
     * @return the lastN
     */
    public String getLastN() {
        return lastN;
    }

    /**
     * @return the middleN
     */
    public String getMiddleN() {
        return middleN;
    }

    /**
     * @return the password
     */
    public Password getPassword() {
        return password;
    }

    /**
     * @return the security
     */
    public QAs getSecurity() {
        return security;
    }

    /**
     * @return the userInfo
     */
    public BasicUserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * @return the userNumber
     */
    public int getUserNumber() {
        return userNumber;
    }

    /**
     * @return the userType
     */
    public UserType getUserType() {
        return userType;
    }
    
}