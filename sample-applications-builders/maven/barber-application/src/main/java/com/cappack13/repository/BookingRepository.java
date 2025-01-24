package com.cappack13.repository;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cappack13.model.Booking;
import com.cappack13.model.Services;
import com.cappack13.model.TimeSlots;


@Repository
public interface BookingRepository extends PagingAndSortingRepository<Booking, Integer>, JpaRepository<Booking, Integer>{

	@Transactional
	@Modifying
	@Query("update Booking b set b.serviceName = :name, b.serviceid =:sid where b.bookingId = :id")
	public int changeTheServicebyName(String name, int id, int sid);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM users_bookings WHERE bookings_booking_id= :id" ,nativeQuery=true)
	public int deletethecascade(int id);
	
	


	
	

}

