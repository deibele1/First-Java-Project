package dev.deathstarreactorcore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.deathstarreactorcore.beans.Prediction;
import dev.deathstarreactorcore.beans.PredictionStatistics;
import dev.deathstarreactorcore.beans.UserMasterTable;
import dev.deathstarreactorcore.rawTypes.RawPrediction;
import dev.deathstarreactorcore.repositories.UserRepository;
import dev.deathstarreactorcore.services.PredictionService;
import dev.deathstarreactorcore.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class PredictionController {
	
	@Autowired
	PredictionService ps;
	
	@Autowired
	UserRepository ur;
	
    @RequestMapping(value="pred/byId/{ID}", method=RequestMethod.GET)
	public RawPrediction getById (@PathVariable ("ID") int id ) {
    	
    	return new RawPrediction(ps.getPrediction(id));
    	
    	
    }
	
	
    @RequestMapping(value="pred/byUser/{userName}", method=RequestMethod.GET)
	public List<RawPrediction> getByUser (@PathVariable("userName") String userName) {
    	
    	
    	return RawPrediction.processList(ps.getUserPredictions(userName));
    	
    }
    
    
    @PostMapping (value="pred/add" , consumes="application/json") 
    public Prediction addPrediction ( @RequestBody dev.deathstarreactorcore.rawTypes.RawPrediction pred ) {
    	
    	System.out.println("Prediction controller Adder triggered");
    	System.out.println("This is input :" + pred.toString() );
    	
    //	UserMasterTable umt = ur.findById(;
    	
    return ps.save(pred);	
    }
    
    
    @RequestMapping(value="/event/{eventID}", method = RequestMethod.GET, produces = "application/json")
    public PredictionStatistics getStats(@PathVariable(value="eventID") int eid) {
    	
    	return new PredictionStatistics(ps.getCountByPredictedAndPredictedEvent(true, eid), ps.getCountByPredictedAndPredictedEvent(false, eid));
    }
    
    @PostMapping (value = "pred/del/{predId}")
    public void deletePrediction (@PathVariable(value="predId") int predId , @RequestBody dev.deathstarreactorcore.beans.UserMasterTable user)
    {
    	
    	ps.deletePrediction(predId, user);
    	
    	
    	
    	
    }
    
    

}
