package gardenforprincess;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

public class Duration implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date beginDay;
	private Date endDay;
	
	public Duration(int startMonth, int startDate, int endMonth, int endDate){
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.YEAR, startMonth-1, startDate);
		this.initDurationDate(calendar);		
		this.beginDay = calendar.getTime();
		
		calendar.set(Calendar.YEAR, endMonth-1, endDate);
		this.initDurationDate(calendar);
		this.endDay = calendar.getTime();		
	}
	
	private void initDurationDate(Calendar calendar){
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	
	public Date getBeginDay(){
		return this.beginDay;
	}
	
	public Date getEndDay(){
		return this.endDay;
	}
	
	public long getDurationTime(){
		return this.endDay.getTime() - this.beginDay.getTime();
	}

}
