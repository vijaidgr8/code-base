package com.cappack13.controller;

import java.util.List;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappack13.dao.BarberDaoForAdmin;
import com.cappack13.dao.BarberDaoForCustomer;
import com.cappack13.dao.TimeSlotDao;
import com.cappack13.exception.BarberCreationException;
import com.cappack13.exception.BarberIdNotFoundException;
import com.cappack13.exception.ServiceCreationException;
import com.cappack13.model.Barber;
import com.cappack13.model.Feedback;
import com.cappack13.model.Services;
import com.cappack13.model.TimeSlots;
import com.cappack13.model.Users;

@RestController
public class BarberControllerByAdmin {
	
	@Autowired
	BarberDaoForAdmin barDao;
	
	@Autowired
	BarberDaoForCustomer barDaoCus;
	
	
	
	@Autowired
	TimeSlotDao tDao;
	
	
	Logger log=org.slf4j.LoggerFactory.getLogger(BarberControllerByAdmin.class);
	
	@PostMapping(path="/createBarber")
	public Barber addBarberdetails(@RequestBody Barber barber) throws BarberCreationException {
		Barber b = barDao.addBarber(barber);
		if(b!=null)
		{
			log.info("Barber object created");
		}
		else
		{
			log.error("sorry not able to create barber object");
		}
		return b;
	}
	
	@PostMapping(path="/createService")
	public Services addServices(@RequestBody Services service) throws ServiceCreationException {
		Services s = barDao.addService(service);
		if(s!=null)
		{
			log.info("Service object created");
		}
		else
		{
			log.error("sorry not able to create service object");
		}
		return s;
	}
	
	@GetMapping(path="/viewfeedbacks")
    public List<Feedback> viewfeedbacks(){
        log.info("Viewed feedbacks on barbers by customers");
        return barDao.viewFeedbacksgivenByCustomers();
       
    }
	
	@PutMapping(path="/updateCostPerSessionofBarber/{bId}/{cost}")
	public int updateCost(@PathVariable int bId, @PathVariable double cost) throws BarberIdNotFoundException {
		int u = barDao.updatingCostOfBarber(bId, cost);
		if(u!=0)
		{
			log.info("Update the cost per session of the barber successfully");
		}
		else
		{
			log.error("Updating the cost per session of the barber failed");
		}
		return u;
		
	}
	
	@GetMapping(path="/viewBarbersBasedOnRatings")
	public List<Barber> viewBarbersOnRatings(){
		log.info("Viewed barbers based on Ratings");
		return barDao.viewBarbersBySortedRating();
		
	}
	
	
	
	@GetMapping(path="/viewAllAvailableBarbers")
	public List<Barber> viewAllBarbers(){
		log.info("Viewed All Available Barbers");
		return barDao.viewAllBarbers();
		
	}
	@GetMapping(path="/viewAllCustomers")
	public List<Users> viewAllCustomer(){
		log.info("Viewed All Available Barbers");
		return barDao.viewAllCustomers();
		
	}
	
	@GetMapping(path="/viewAllServicesOfBarber/{bId}")
	public List<Services> viewAllServiceDoneByBarber(@PathVariable int bId) throws BarberIdNotFoundException{
		List<Services> ser =  barDao.viewServicesofBarber(bId);
		if(ser!=null) {
			log.info("Viewed All the services of Barber");
		}
		else {
			log.error("Cannot view the services of barber");
		}
		return ser;
		
		
	}
	
	@GetMapping(path="/viewAllTimeSlotsAvailableByBarber/{bId}")
	public List<TimeSlots> viewAllTimeSlotsAvailable(@PathVariable int bId) throws BarberIdNotFoundException{
		List<TimeSlots> ts = barDao.viewTimeSlotsofBarber(bId);
		if(ts!=null) {
			log.info("Viewed All the Timeslots of Barber");
		}
		else {
			log.error("Cannot view the timeslots of barber");
		}
		return ts;
		
	}
	
	@PostMapping(path="/createTimeslots")
	public TimeSlots addSlots(@RequestBody TimeSlots slot) {
		return tDao.addTimeSlots(slot);
	}
	
	@GetMapping(path="/viewAllSlots")
	public List<TimeSlots> viewTimeSlots(){
		return tDao.viewAllSlots();
	}
	
	@PutMapping(path="/updatestatusoftheslot/{tid}/{availa}")
	public int updatestatusofslot(@PathVariable int tid, @PathVariable String availa) {
		return tDao.updateStatusofTimeSlots(tid, availa);
	}
	
	@PutMapping(path="/updatefeedbackofbarberbyadmin/{bid}")
    public int updateratingsofbarber(@PathVariable int bid) {
        return barDao.updateratingsofbarber(bid);
    }
	
	@GetMapping(path="/viewfeedbacksByAdmin")
    public List<Feedback> viewfeedbacksbyAdmin(){
        log.info("Viewed feedbacks on barbers by customers");
        return barDao.viewFeedbacksgivenByCustomers();
	}
	

}