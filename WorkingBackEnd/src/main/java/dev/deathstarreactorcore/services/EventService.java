package dev.deathstarreactorcore.services;

import java.sql.Date;
import java.util.LinkedList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.BasicEventInfo;
import dev.deathstarreactorcore.beans.Category;
import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.beans.UserMasterTable;
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
        
        return new BasicEventInfo(saved.getAdvent(), saved.getEventName(), saved.getDescription(), saved.getEventCategory(), saved.getCreator().getUsername(), saved.getEid() ,saved.isOutcome());
    }

    public Event get(Integer id) {
//        Event event = er.findById(id).get();
//        return new BasicEventInfo(event.getEventName(), event.getDescription(), event.getAdvent(), event.getEventCategory(), event.getCreator().getUsername());
    	return er.findById(id).get();
    }
    
    public LinkedList<BasicEventInfo> getAll() {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findAll(Sort.by(Sort.Direction.ASC, "advent"));
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getAdvent(), e.getEventName(), e.getDescription(), e.getEventCategory(), e.getCreator().getUsername(), e.getEid() ,e.isOutcome()  ));
    	}
    	
    	
    	
        return eventInfo;
    }
    
    public LinkedList<BasicEventInfo> getAllbyCatagory(int cat) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByEventCategory(Category.getById(cat), Sort.by(Sort.Direction.ASC, "advent"));
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getAdvent(), e.getEventName(), e.getDescription(), e.getEventCategory(), e.getCreator().getUsername() , e.getEid() ,e.isOutcome()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findByAdventGreaterThan(Date date) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByAdventGreaterThan(date);
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getAdvent(), e.getEventName(), e.getDescription(), e.getEventCategory(), e.getCreator().getUsername() , e.getEid(),e.isOutcome()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findAll() {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findAll(Sort.by(Sort.Direction.ASC, "advent"));
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getAdvent(), e.getEventName(), e.getDescription(), e.getEventCategory(), e.getCreator().getUsername() , e.getEid(),e.isOutcome()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findByAdventLessThan(Date date) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByAdventLessThan(date);
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getAdvent(), e.getEventName(), e.getDescription(), e.getEventCategory(), e.getCreator().getUsername() , e.getEid(),e.isOutcome()));
    	}
    	
        return eventInfo;
    }
    public LinkedList<BasicEventInfo> findByAdventBetween(Date today, Date future) {
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByAdventBetween(today, future, Sort.by(Sort.Direction.ASC, "advent"));
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getAdvent(), e.getEventName(), e.getDescription(), e.getEventCategory(), e.getCreator().getUsername() , e.getEid(),e.isOutcome()));
    	}
    	
        return eventInfo;
    }
    
    public LinkedList <BasicEventInfo> findByTitle(String eventTitle){
    	
    	LinkedList<BasicEventInfo> eventInfo = new LinkedList<BasicEventInfo>();
    	LinkedList<Event> events = er.findByEventName(eventTitle);
    	System.out.println("This is list of events by name : " + events.toString());
    	
    	for(Event e : events) {
    		
    		eventInfo.add(new BasicEventInfo(e.getAdvent(), e.getEventName(), e.getDescription(), e.getEventCategory(), e.getCreator().getUsername() , e.getEid(),e.isOutcome()));
    	}
    	
    System.out.println("This is final list being output : " + eventInfo.toString());
    	return eventInfo;
    }
    
    
    public void setEventOutcome ( int eventId , Boolean outcome)
    {
    	Event event =  er.findById(eventId).get();
    	
    	if (event!=null)
    	{
    		System.out.println(event.toString());
    		event.setOutcome(outcome);
    		er.save(event);
    		System.out.println(er.findById(eventId).get().toString());
    		
    		
    		
    		
    	}
    	

    	
    	
    }
    
    
    
}
