package dev.deathstarreactorcore.rawTypes;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import dev.deathstarreactorcore.beans.Prediction;

public class RawPrediction {

	public int predictionId;
	public String eventName;
	public String predictingUser;
	public Date dateOfPrediction;
	public boolean predicted ;
	
	
	
	
	public RawPrediction(Prediction p) {
		
		this.predictionId = p.getPredictionId();
		this.eventName = p.getPredictedEvent().getEventName();
		this.predictingUser = p.getPredictingUser().getUsername();
		this.dateOfPrediction = p.getDateOfPrediction();
		this.predicted = p.getPredicted();
		
		
		
		
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
