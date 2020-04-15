package dev.deathstarreactorcore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import dev.deathstarreactorcore.annotations.AuthenticatedUser;
import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.rawTypes.RawEvent;
import dev.deathstarreactorcore.services.EventService;

@RestController
public class EventController {
    @Autowired
    EventService es;

    @AuthenticatedUser
    @RequestMapping(value = "/event/add", method = RequestMethod.POST, consumes = "application/json")
    public Event add(@RequestBody RawEvent evt, @RequestHeader(value = "username") String username) {
        return es.save(evt,username);
    }
}