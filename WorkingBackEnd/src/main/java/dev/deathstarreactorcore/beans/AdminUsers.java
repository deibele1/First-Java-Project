package dev.deathstarreactorcore.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdminUsers implements Persistant{
    public AdminUsers(){super();}
    @Id
    @GeneratedValue
    private Integer adminId;
    @OneToOne
    private UserMasterTable basicAccount;
    private Date adminDate;
    @Enumerated
    public Mode currentMode;

    /**
     * @return the adminDate
     */
    public Date getAdminDate() {
        return adminDate;
    }

    /**
     * @return the adminId
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * @return the basicAccount
     */
    public UserMasterTable getBasicAccount() {
        return basicAccount;
    }
}