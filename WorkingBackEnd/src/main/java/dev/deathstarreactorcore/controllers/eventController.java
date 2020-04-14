package dev.deathstarreactorcore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.services.EventService;

@RestController
public class eventController {

//	@Autowired
//	EventService es;
//	
//    @RequestMapping(value="event/add", method=RequestMethod.POST, consumes="application/json")
//    public Event addEvent(@RequestBody dev.deathstarreactorcore.rawTypes.RawEvent event) {
//    	
//    	return es.addEvent(event.process());
//    }
	
}
