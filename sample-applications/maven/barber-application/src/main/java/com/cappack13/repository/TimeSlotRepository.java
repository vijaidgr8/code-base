package com.cappack13.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cappack13.model.Availability;
import com.cappack13.model.Barber;
import com.cappack13.model.Services;
import com.cappack13.model.TimeSlots;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlots, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="update TimeSlots t set t.status = :sta1 where t.timeId=:id")
	public int updatingStatusOfBarber(int id, String sta1);
	
	

}
