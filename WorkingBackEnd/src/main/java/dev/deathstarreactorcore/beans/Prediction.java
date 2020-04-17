package dev.deathstarreactorcore.beans;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prediction implements Persistant{

	public Prediction(){super();}
	
	// Field Variables
	@Id
	@GeneratedValue
	private int predictionId;
	@ManyToOne
	private Event predictedEvent;
	@ManyToOne
	private UserMasterTable predictingUser;
	private Date dateOfPrediction;
	
	private boolean predicted;

	/**
	 * @return the dateOfPrediction
	 */
	public Date getDateOfPrediction() {
		return dateOfPrediction;
	}
	
	/**
	 * @return the predictedEvent
	 */
	public Event getPredictedEvent() {
		return predictedEvent;
	}

	/**
	 * @return the predictingUser
	 */
	public UserMasterTable getPredictingUser() {
		return predictingUser;
	}

	/**
	 * @return the predictionId
	 */
	public int getPredictionId() {
		return predictionId;
	}
	
	
public Prediction(UserMasterTable umt, Event event, Date date, Boolean predicted) {
		
	this.predictingUser = umt;
	this.predictedEvent = event;
	this.dateOfPrediction = date;
	this.setPredicted(predicted);
	
	
	}

public boolean getPredicted() {
	return predicted;
}

public void setPredicted(boolean predicted) {
	this.predicted = predicted;
}
	
	
	
	
	
	
}
