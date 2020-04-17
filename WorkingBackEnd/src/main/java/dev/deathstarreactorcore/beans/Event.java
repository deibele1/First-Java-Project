package dev.deathstarreactorcore.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Event implements Persistant{
	public Event(UserMasterTable creator, Category cat, Date advent, String description, String eventName) {
		this.creator = creator;
		this.eventCategory = cat;
		this.advent = advent;
		this.description = description;
		this.eventName = eventName;
	}

	public Event(){super();}

	// Field variables
	@Id
	@GeneratedValue
	private int eid;
	private String eventName;
	@ManyToOne
	private UserMasterTable creator;
	@ManyToOne
	private UserMasterTable approver;
	private Date advent;
	private Date addDate;
	@Enumerated
	private Category eventCategory;
	private String description;

	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @return the creator
	 */
	public UserMasterTable getCreator() {
		return creator;
	}
	/**
	 * @return the approver
	 */
	public UserMasterTable getApprover() {
		return approver;
	}
	/**
	 * @return the addDate
	 */
	public Date getAddDate() {
		return addDate;
	}
	/**
	 * @return the advent
	 */
	public Date getAdvent() {
		return advent;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the eventCategory
	 */
	public Category getEventCategory() {
		return eventCategory;
	}
	
}
