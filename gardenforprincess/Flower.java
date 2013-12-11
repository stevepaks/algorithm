package gardenforprincess;

import java.io.Serializable;
import java.util.Date;

public class Flower implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Duration bloomingPeriod;
	private int flowerId;
	private boolean isFirst;
	
	public Flower(int flowerId, int bloomingMonth, int bloomingDate, int fallingMonth, int fallingDate){
		this.flowerId = flowerId;
		this.bloomingPeriod = new Duration(bloomingMonth, bloomingDate, fallingMonth, fallingDate);
		this.isFirst = false;
	}
	
	public Date getBloomingDay(){
		return this.bloomingPeriod.getBeginDay();
	}
	
	public Date getFallingDay(){
		return this.bloomingPeriod.getEndDay();
	}
	
	public Duration getBloomingPeriod(){
		return this.bloomingPeriod;
	}
	
	public int getFlowerId(){
		return this.flowerId;
	}
	
	public boolean isFirst(){
		return isFirst;
	}
	
	public void setToFirst(){
		this.isFirst = true;
	}
	
	public boolean contains(Flower flower){
		if(this.getFallingDay().getTime() >= flower.getBloomingDay().getTime() &&
				this.getFallingDay().getTime() <= flower.getFallingDay().getTime()){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.flowerId + " " + this.bloomingPeriod.getBeginDay() + " " + this.bloomingPeriod.getEndDay() + " " + this.isFirst;
	}

}
