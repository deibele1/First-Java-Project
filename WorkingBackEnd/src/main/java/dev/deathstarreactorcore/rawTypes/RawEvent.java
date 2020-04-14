package dev.deathstarreactorcore.rawTypes;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import dev.deathstarreactorcore.beans.Category;
import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.beans.UserMasterTable;
import dev.deathstarreactorcore.services.UserService;

public class RawEvent implements Raw{

    @Autowired
    UserService us;

    //rawData
    public String creatorUsername;
    public Date advent;
    public String eventName;
    public int categoryNumber;
    public String description;

	public Event process() {
		
		UserMasterTable creator = us.getUser(creatorUsername);
		Category cat = Category.getById(categoryNumber);
		Event event = new Event(creator, cat, advent, description, eventName);
		return event;
    }

}