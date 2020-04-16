package dev.deathstarreactorcore.services;

import java.sql.Date;
import java.util.LinkedList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.BasicEventInfo;
import dev.deathstarreactorcore.beans.Category;
import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.rawTypes.RawEvent;
import dev.deathstarreactorcore.repositories.EventRepository;
import dev.deathstarreactorcore.repositories.UserRepository;


@Service
public class EventService implements WebService{
    @Autowired
    EventRepository er;

    @Autowired
    UserRepository ur;


    public BasicEventInfo save(RawEvent event,String username) {
        Event saved = er.save(event.process(ur.findById(username).get()));
        
        return new BasicEventInfo(saved.getEventName(), saved.getDescription(), saved.getAdvent(), saved.getEventCategory(), saved.getCreator().getUsername());
    }

    public BasicEventInfo get(Integer id) {
        Event event = er.findById(id).get();
        return new BasicEventInfo(event.getEventName(), event.getDescription(), event.getAdvent(), event.getEventCategory(), event.getCreator().getUsername());
    }
    public LinkedList<BasicEventInfo> getAll() {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findAll(Sort.by(Sort.Direction.ASC, "advent"));
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getEventName(), e.getDescription(), e.getAdvent(), e.getEventCategory(), e.getCreator().getUsername()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> getAllbyCatagory(int cat) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByEventCategory(Category.getById(cat));
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getEventName(), e.getDescription(), e.getAdvent(), e.getEventCategory(), e.getCreator().getUsername()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findByAdventGreaterThan(Date date) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByAdventGreaterThan(date);
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getEventName(), e.getDescription(), e.getAdvent(), e.getEventCategory(), e.getCreator().getUsername()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findAll() {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findAll(Sort.by(Sort.Direction.ASC, "advent"));
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getEventName(), e.getDescription(), e.getAdvent(), e.getEventCategory(), e.getCreator().getUsername()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findByAdventLessThan(Date date) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByAdventLessThan(date);
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getEventName(), e.getDescription(), e.getAdvent(), e.getEventCategory(), e.getCreator().getUsername()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findByAdventBetween(Date today, Date future) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByAdventBetween(today, future, Sort.by(Sort.Direction.ASC, "advent"));
    	
    	for(Event e : events) {
    		
    		System.out.println(e.getEventCategory().ordinal());
    		
    		eventInfo.add(new BasicEventInfo(e.getEventName(), e.getDescription(), e.getAdvent(), e.getEventCategory(), e.getCreator().getUsername()));
    	}
    	
        return eventInfo;
    }
}
