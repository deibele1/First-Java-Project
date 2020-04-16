package dev.deathstarreactorcore.rawTypes;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;

import dev.deathstarreactorcore.beans.Category;
import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.beans.UserMasterTable;
import dev.deathstarreactorcore.repositories.UserRepository;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RawEvent extends Raw{
    //rawData
    public Date advent;
    public String eventName;
    public int categoryNumber;
    public String description;


	public Event process(UserMasterTable creator) {
		return new Event(creator,categoryNumber,advent,description,eventName);
    }
}