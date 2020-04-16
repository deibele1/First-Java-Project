package dev.deathstarreactorcore.beans;


import java.sql.Date;

import javax.persistence.Embedded;
import javax.persistence.Enumerated;

public class BasicEventInfo implements Persistant{

	private Date advent;
	private String eventName;
	private String description;
	@Embedded
	@Enumerated
	private Category eventCategory;
	private String username;
	
	public BasicEventInfo(Date advent, String eventName, String description, Category eventCategory, String username) {
		
		this.eventName = eventName;
		this.description = description;
		this.advent = advent;
		this.eventCategory = eventCategory;
		this.username = username;
	}

	public BasicEventInfo() {
		
		super();
	}

	/**
	 * @return eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAdvent() {
		return advent;
	}

	public void setAdvent(Date advent) {
		this.advent = advent;
	}

	public Category getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(Category eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
