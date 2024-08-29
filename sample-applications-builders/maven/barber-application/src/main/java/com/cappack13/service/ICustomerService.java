package com.cappack13.service;

import java.util.List;

import com.cappack13.exception.BarberIdNotFoundException;
import com.cappack13.exception.BookingCreationException;
import com.cappack13.exception.BookingIdNotFoundException;
import com.cappack13.exception.CustomerNotFoundException;
import com.cappack13.exception.ServiceNotFoundException;
import com.cappack13.model.Availability;
import com.cappack13.model.Barber;
import com.cappack13.model.Booking;
import com.cappack13.model.Feedback;
import com.cappack13.model.Gender;
import com.cappack13.model.Services;
import com.cappack13.model.Users;

public interface ICustomerService {
	
	public List<Barber> viewAllBarbers();
	public List<Barber> viewBarbersBySortedRating();
	public List<Services> viewAllServiceOfBarber(int barberId) throws BarberIdNotFoundException;
	//public Booking bookAService(Booking booking);
	public Booking bookAService(Booking booking, int barbId, int custId, int serid, String stTime, String endTime, String dos,  Availability availa) throws BookingCreationException, BarberIdNotFoundException, ServiceNotFoundException;
	public int changeTheService(String newServiceName, int barberId, int serviceId) throws BarberIdNotFoundException;
	public int cancelOrder(int bookingId) throws BookingIdNotFoundException;
	//public int giveFeedback(int barberId, int par1, int par2, int par3) throws BarberIdNotFoundException;
	public List<Booking> viewBookedOrders(int customerId) throws CustomerNotFoundException;
	public List<Booking> viewPreviousOrders(int customerId) throws CustomerNotFoundException;
	public List<String> getNameOfBarber(int barberId) throws BarberIdNotFoundException;
	public double getCostPerSessionbyid(int barberId) throws BarberIdNotFoundException;
	public double getCostofTheServiceatLast(int barberId, int serviceId) throws BarberIdNotFoundException, ServiceNotFoundException;
	public Feedback giveFeedback(Feedback f1, int bid, int cid, int p1, int p2, int p3) throws BarberIdNotFoundException, CustomerNotFoundException;

}
