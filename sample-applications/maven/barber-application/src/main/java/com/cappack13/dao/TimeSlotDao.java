package com.cappack13.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cappack13.model.Availability;
import com.cappack13.model.TimeSlots;
import com.cappack13.repository.TimeSlotRepository;
import com.cappack13.service.ITimeSlots;

@Service
public class TimeSlotDao implements ITimeSlots{
	
	@Autowired
	TimeSlotRepository tRepo;
	
	@Override
	public TimeSlots addTimeSlots(TimeSlots slot) {
		return tRepo.save(slot);
		
	}
	
	@Override
	public List<TimeSlots> viewAllSlots(){
		return tRepo.findAll();
	}
	
	@Override
	public int updateStatusofTimeSlots(int timeId, String avail) {
		return tRepo.updatingStatusOfBarber(timeId, avail);
	}

}
