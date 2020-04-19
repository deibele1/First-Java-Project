package dev.deathstarreactorcore.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.beans.Prediction;
import dev.deathstarreactorcore.beans.UserMasterTable;
import dev.deathstarreactorcore.rawTypes.RawPrediction;
import dev.deathstarreactorcore.repositories.EventRepository;
import dev.deathstarreactorcore.repositories.PredictionRepository;
import dev.deathstarreactorcore.repositories.UserRepository;

@Service
public class PredictionService implements WebService {
	
	
	
	@Autowired
	PredictionRepository pr;
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	EventRepository er;
	
	/*
	private class RawPrediction {
	
		Integer eventId;
		
		Boolean predicted;
		
		public Prediction process (String userName) {
			 UserMasterTable umt = ur.findById(userName).get();
		     Event event = er.findById(this.eventId).get();
		     Date date = Date.valueOf(LocalDate.now());
		 
		
		     Prediction pred = new Prediction (umt , event , date , this.predicted);
		     
		     
			return pred;
		}
		
	}
	*/
	
	// this gets by prediction id
	public Prediction getPrediction (int pId) {
		
		return pr.findById(pId).get();
	}
	
	// this gets by user id
	public List<Prediction> getUserPredictions (String userName){
		
		
		UserMasterTable user = ur.findById(userName).get();
		
		
		List<Prediction> fullPreds=  pr.getPredictionsByPredictingUser(user);
		 return fullPreds;
	}
	
	// this creates new prediction
	public void addPrediction (RawPrediction rp , String userName ) {
		
		
		
		
		pr.save(rp.process(userName));
		
	}
	
	public Prediction save (RawPrediction rp , String user ) {
		
		 
		 
	     Event event = er.findByeid(rp.eventId);
	
	     System.out.println("This is event I'm trying to predict for : " + event.toString());
	     
	     UserMasterTable umt = ur.findByUsername(user);
	     
	     Prediction pred = rp.process(event , umt);
		System.out.println("This is prediction to be saved : " + pred.toString());
	    pr.save(pred); 
		
		return null;
		
		
		
	}

	public long getCountByPredictedAndPredictedEvent(boolean predicted, int eid) {
		
		Long num = pr.countByPredictedAndPredictedEvent_Eid(predicted, eid);

		if(num == null) {
			
			num = (long) 0;
		}
		
		return num.longValue();
	}
	
	
	public int getRatio(String username)
	{
		long correct;
		long incorrect;
		
		correct+= pr.countByPredictedAndPredictedEvent_OutcomeAndPredictingUser_Username(true ,true,  username);
		
		
		
		
		
		return 1;
	}
	
	@Transactional
	public void deletePrediction (int predId , UserMasterTable user)
	{
		
	String userName = user.getUsername();
	System.out.println(userName);
	
	Prediction pred =  pr.findById(predId).get();
	System.out.println("Username of prediction : " + pred.getPredictingUser().getUsername());
	if (pred.getPredictingUser().getUsername().equals(userName))
	{
		System.out.println("Authentication match!");
		pr.deleteByPredictionId(predId);	
	} else
	{
		System.out.println("Authentication failed. You cant just delete other peoples predictions.");
		
	}
		// end of method
	}
	
	
}
