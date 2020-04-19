package dev.deathstarreactorcore.rawTypes;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.beans.Prediction;
import dev.deathstarreactorcore.beans.UserMasterTable;
import dev.deathstarreactorcore.repositories.EventRepository;
import dev.deathstarreactorcore.repositories.UserRepository;

public class RawPrediction {

	@Autowired
	UserRepository ur;
	
	@Autowired
	EventRepository er;
	
	
	public int predictionId;
	public String eventName;
	public String predictingUser;
	public Date dateOfPrediction;
	public boolean predicted ;
    public int eventId;
    public Boolean isCorrect;
	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	public Boolean getIsCorrect() {
		return isCorrect;
	}


	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	@Override
	public String toString() {
		return "RawPrediction [predictionId=" + predictionId + ", eventName=" + eventName + ", predictingUser="
				+ predictingUser + ", dateOfPrediction=" + dateOfPrediction + ", predicted=" + predicted + ", eventId="
				+ eventId + "]";
	}


	public RawPrediction(int predictionId, String eventName, String predictingUser, Date dateOfPrediction,
			boolean predicted, int eventId) {
		super();
		this.predictionId = predictionId;
		this.eventName = eventName;
		this.predictingUser = predictingUser;
		this.dateOfPrediction = dateOfPrediction;
		this.predicted = predicted;
		this.eventId = eventId;
	}


	public RawPrediction(Prediction p) {
		
		this.predictionId = p.getPredictionId();
		//this.eventName = p.getPredictedEvent().getEventName();
		this.predictingUser = p.getPredictingUser().getUsername();
		this.dateOfPrediction = p.getDateOfPrediction();
		this.predicted = p.getPredicted();
		this.isCorrect = p.getIsCorrect();
		
		}
	
	
	public Prediction process (String userName) {
		 UserMasterTable umt = ur.findById(userName).get();
	     Event event = er.findById(this.eventId).get();
	     Date date = Date.valueOf(LocalDate.now());
	 
	
	     Prediction pred = new Prediction (umt , event , date , this.predicted);
	     
	     
		return pred;
	}
	
	
	public Prediction process () {
		System.out.println("This is field about to be checked : " + this.predictingUser);
		System.out.println("And the eventID : " + this.eventId);
		// UserMasterTable umt = ur.findById(this.predictingUser).get();
		// System.out.println(umt);
	    // Event event = er.findById(this.eventId).get();
		UserMasterTable umt = new UserMasterTable(this.predictingUser);
	     Date date = Date.valueOf(LocalDate.now());
	     
	     
	     
	     
	     Event event = er.findByeid(this.eventId);
	
	
	     Prediction pred = new Prediction (umt,  event , date , this.predicted);
	     
	     System.out.println("This is final pred being returned : " +pred.toString());
		return pred;
	}
	
	
	
	
	public Prediction process (Event event , UserMasterTable umt)
	{
		System.out.println("This is field about to be checked : " + this.predictingUser);
		System.out.println("And the eventID : " + this.eventId);
		// UserMasterTable umt = ur.findById(this.predictingUser).get();
		// System.out.println(umt);
	    // Event event = er.findById(this.eventId).get();
	
	     Date date = Date.valueOf(LocalDate.now());
	     
	     
	     
	    
	
	     Prediction pred = new Prediction (umt,  event , date , this.predicted);
	     
	     System.out.println("This is final pred being returned : " +pred.toString());
		return pred;
	}
	
	
	
	
	
	
	
	
	
	
	
	// this exists to exchange into a list we can send to front end
	public static List<RawPrediction> processList (List<Prediction> fullPreds) {
		
		List<RawPrediction> preds = new LinkedList<RawPrediction>();
		
		for (Prediction p : fullPreds) {
			
			preds.add(new RawPrediction(p));
			}
		
		return preds;
		
		
		
	}
	
	
	
	
	
	
}
