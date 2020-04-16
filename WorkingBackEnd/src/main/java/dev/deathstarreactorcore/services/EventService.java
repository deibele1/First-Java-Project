package dev.deathstarreactorcore.services;

import java.sql.Date;
import java.util.LinkedList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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


    public Event save(RawEvent event,String username) {
        return er.save(event.process(ur.findById(username).get()));
    }

    public Event get(Integer id) {
        return er.findById(id).get();
    }
    public LinkedList<Event> getAll() {
        return er.findAll();
    }
    public LinkedList<Event> getAllbyCatagory(int cat) {
        return er.findByEventCategory(Category.getById(cat));
    }
    public LinkedList<Event> findByAdventGreaterThan(Date date) {
    	
    	return er.findByAdventGreaterThan(date);
    }
    public LinkedList<Event> findAll() {
    	
    	return er.findAll();
    }
    public LinkedList<Event> findByAdventLessThan(Date date) {
    	
    	return er.findByAdventLessThan(date);
    }
    public LinkedList<Event> findByAdventBetween(Date today, Date future) {
    	
    	return er.findByAdventBetween(today, future, Sort.by(Sort.Direction.ASC, "advent"));
    }
}
