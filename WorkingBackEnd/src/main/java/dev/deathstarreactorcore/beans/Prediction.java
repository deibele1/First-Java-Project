package dev.deathstarreactorcore.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prediction implements Persistant{

	public Prediction(){super();}
	// Field Variables
	@Id
	private int predictionId;
	@ManyToOne
	private Event predictedEvent;
	@ManyToOne
	private UserMasterTable predictingUser;
	private Date dateOfPrediction;

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
	
}
