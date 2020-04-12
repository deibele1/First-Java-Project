package dev.deathstarreactorcore.repositories;

import org.springframework.stereotype.Repository;

import dev.deathstarreactorcore.beans.Event;
import dev.deathstarreactorcore.beans.Prediction;
import dev.deathstarreactorcore.beans.UserMasterTable;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PredictionRepository extends CrudRepository<Prediction, Integer>{

	// Get individual Prediction
	public Prediction getPredictionByPredictionId(int PredictionId);
	
	// Get the predictions for an event
	public Prediction getPredictionByPredictedEvent(Event PredictedEvent);
	
	// Gets all predictions for a specific user
	public List<Prediction> getPredictionsByPredictingUser(UserMasterTable predictingUser);
	
	// Gets all predictions
	public List<Prediction> findAll();
}
