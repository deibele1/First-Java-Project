package dev.deathstarreactorcore.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.Category;
import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.rawTypes.RawEvent;
import dev.deathstarreactorcore.repositories.EventRepository;


@Service
public class EventService implements WebService{
    @Autowired
    EventRepository er;

    public Event addEvent(RawEvent event) {
        return er.save(event.process());
    }
    public Event getEvent(Integer id) {
        return er.findById(id).get();
    }
    public LinkedList<Event> getAllEvents() {
        return er.findAll();
    }
    public LinkedList<Event> getAllbyCatagor(int cat) {
        return er.findByEventCategory(Category.getById(cat));
    }

}