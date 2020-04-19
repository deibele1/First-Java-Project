  
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
        Category cat = Category.getById(categoryNumber);
		return new Event(creator,cat,advent,description,eventName);
    }
}