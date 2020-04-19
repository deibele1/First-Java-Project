package dev.deathstarreactorcore.repositories;

import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.beans.Prediction;
import dev.deathstarreactorcore.beans.UserMasterTable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PredictionRepository extends CrudRepository<Prediction, Integer>{

	// Get individual Prediction
	public Prediction getPredictionByPredictionId(int PredictionId);
	
	// Get the predictions for an event
	public LinkedList<Prediction> getPredictionByPredictedEvent(Event PredictedEvent);
	
	// Gets all predictions for a specific user
	public List<Prediction> getPredictionsByPredictingUser(UserMasterTable predictingUser);
	
	// Gets all predictions
	public List<Prediction> findAll();

	// Get a count of the yays or nays
	public Long countByPredictedAndPredictedEvent_Eid(boolean predicted, int eid);
	
	public Long countByPredictedAndPredictedEvent_OutcomeAndPredictingUser_Username(Boolean a,Boolean b, String username);
	
	
	public void deleteByPredictionId (int PredictionId);
	
	
	
	
	
	
	
	
}