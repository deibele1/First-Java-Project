package dev.deathstarreactorcore.services;

import java.util.LinkedList;


import org.springframework.beans.factory.annotation.Autowired;
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

}
