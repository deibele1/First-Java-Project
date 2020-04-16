package dev.deathstarreactorcore.repositories;

import java.sql.Date;
import java.util.LinkedList;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.Category;
import dev.deathstarreactorcore.beans.Event;

//not all of these are implemented in the service and controller class. We're going to need to map them

@Repository
public interface EventRepository extends CrudRepository<Event,Integer>{

	LinkedList<Event> findAll();

    LinkedList<Event> findByEventCategory(Category category);
    
    LinkedList<Event> findByAdventLessThan(Date date);

    LinkedList<Event> findByAdventGreaterThan(Date date);
    
    LinkedList<Event> findByAdventBetween(Date today, Date future, Sort sort);

}