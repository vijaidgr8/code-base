package com.cappack13.service;

import java.util.List;

import com.cappack13.model.Barber;
import com.cappack13.model.Booking;
import com.cappack13.model.Services;

public interface IBookingervice {
	
	public List<Barber> viewAllBarbers();
	public List<Barber> viewBarbersBySortedRating();
	public List<Services> viewAllServiceOfBarber(int barberId);
	public Booking bookAService(Booking booking);
	public int changeTheService(String newServiceName, int bookingId);
	public int cancelOrder(int bookingId);
	public int giveFeedback(int barberId, int par1, int par2, int par3);
	public List<Booking> viewBookedOrders(int customerId);
	public List<Booking> viewPreviousOrders(int customerId);

}
