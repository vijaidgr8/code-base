package com.cappack13.service;

import java.util.List;

import com.cappack13.exception.BarberCreationException;
import com.cappack13.exception.BarberIdNotFoundException;
import com.cappack13.exception.ServiceCreationException;
import com.cappack13.exception.TimeSlotCreationException;
import com.cappack13.model.Barber;
import com.cappack13.model.Feedback;
import com.cappack13.model.Services;
import com.cappack13.model.TimeSlots;



public interface IBarberServicesForAdmin {
	public Double getavgfeedbackbybid(int id);
	public Barber addBarber(Barber barber) throws BarberCreationException;
	public Services addService(Services service) throws ServiceCreationException;
	//public Services updatingService(int serviceId, double cost);
	public int updatingCostOfBarber(int barberid, double cost) throws BarberIdNotFoundException;
	public List<Barber> viewBarbersBySortedRating();
	public List<Barber> viewAllBarbers();
	//public List<Customer> viewCustomersInSortedRating();
	public List<Services> viewServicesofBarber(int barberId) throws BarberIdNotFoundException;
	public List<TimeSlots> viewTimeSlotsofBarber(int barberId) throws BarberIdNotFoundException;
	public Barber addService(Services service, int barberid);
	public List<Feedback> viewFeedbacksgivenByCustomers();
    public int updateratingsofbarber(int id);
    
}

