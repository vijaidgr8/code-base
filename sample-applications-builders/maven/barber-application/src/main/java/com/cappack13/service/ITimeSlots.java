package com.cappack13.service;

import java.util.List;

import com.cappack13.model.Availability;
import com.cappack13.model.TimeSlots;

public interface ITimeSlots {
	
	public TimeSlots addTimeSlots(TimeSlots slot);
	public List<TimeSlots> viewAllSlots();
	public int updateStatusofTimeSlots(int timeId, String avail) ;

}
