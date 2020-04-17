package dev.deathstarreactorcore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.deathstarreactorcore.beans.Prediction;
import dev.deathstarreactorcore.rawTypes.RawPrediction;
import dev.deathstarreactorcore.services.PredictionService;

@RestController
public class PredictionController {
	
	@Autowired
	PredictionService ps;
	
    @RequestMapping(value="pred/byId/{ID}", method=RequestMethod.GET)
	public RawPrediction getById (@PathVariable ("ID") int id ) {
    	
    	return new RawPrediction(ps.getPrediction(id));
    	
    	
    }
	
	
    @RequestMapping(value="pred/byUser/{userName}", method=RequestMethod.GET)
	public List<RawPrediction> getByUser (@PathVariable("userName") String userName) {
    	
    	
    	return RawPrediction.processList(ps.getUserPredictions(userName));
    	
    }
    
    

}
