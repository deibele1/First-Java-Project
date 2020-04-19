package dev.deathstarreactorcore.beans;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
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
	
	
	//@ManyToOne
	@Column (name="PREDICTED_EVENT")
	private int predictedEvent;
	
	@ManyToOne   
	private UserMasterTable predictingUser;
	private Date dateOfPrediction;
	
	//private String predictingUserName;

	private boolean predicted;
	
	// this is final value value to see if prediction is correct or not
	private Boolean isCorrect;

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	/**
	 * @return the dateOfPrediction
	 */
	public Date getDateOfPrediction() {
		return dateOfPrediction;
	}
	
	/**
	 * @return the predictedEvent
	 */
	
	
	public int getPredictedEvent() {
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
	
	
public Prediction(UserMasterTable umt, int event, Date date, Boolean predicted) {
		
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

//public String getPredictingUserName() {
//	return predictingUserName;
//}
//
//public void setPredictingUserName(String predictingUserName) {
//	this.predictingUserName = predictingUserName;
//}
	



//
//public Prediction(UserMasterTable ut, String umt,  int event, Date date, Boolean predicted) {
//this.predictingUser = ut;
//this.predictingUserName = umt;
//this.predictedEvent = event;
//this.dateOfPrediction = date;
//this.setPredicted(predicted);
//
//
//}

@Override
public String toString() {
	return "Prediction [predictionId=" + predictionId + ", predictedEvent=" + predictedEvent + ", predictingUser="
			+ predictingUser + ", dateOfPrediction=" + dateOfPrediction + ", predictingUserName=" + 
		 ", predicted=" + predicted + "]";
}


	
	
	
	
	
}
