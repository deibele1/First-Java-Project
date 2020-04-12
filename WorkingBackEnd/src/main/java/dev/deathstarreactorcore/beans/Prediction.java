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
	private int PredictionId;
	@ManyToOne
	private Event PredictedEvent;
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
		return PredictedEvent;
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
		return PredictionId;
	}
	
}
