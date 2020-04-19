package dev.deathstarreactorcore.beans;

public class PredictionStatistics {

	private long yays;
	private long nays;
	private double ratio;
	
	public PredictionStatistics(long yays, long nays) {
		
		this.yays = yays;
		this.nays = nays;
		
		if(this.yays == 0 || this.nays == 0) {
			
			this.ratio = 0;
		} else {

			this.ratio = Long.valueOf(yays).doubleValue() / Long.valueOf(nays).doubleValue();
		}
	}
	
	public long getYays() {
		
		return yays;
	}
	
	public long getNays() {
		
		return nays;
	}
	
	public double getRatio() {
		
		return ratio;
	}
}
