package com.cappack13.dao;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
import com.cappack13.repository.BarberRepository;
import com.cappack13.repository.BookingRepository;
import com.cappack13.repository.FeedbackRepository;
import com.cappack13.repository.ServiceRepository;
import com.cappack13.repository.UsersRepository;
import com.cappack13.service.ICustomerService;

@Service
@Transactional
public class BarberDaoForCustomer implements ICustomerService
{
	@Autowired
	FeedbackRepository feedRepos;
	
	@Autowired
	UsersRepository userRepos;
	
	@Autowired
	BarberRepository barRepos;
	
	@Autowired
	ServiceRepository serRepos;
	
	@Autowired 
	BookingRepository bookRepos;
	
	public Users addCustomer(Users user) {
		return userRepos.save(user);
	}
	
	@Override
	public List<Barber> viewAllBarbers() {
		return (List<Barber>)barRepos.findAll();
	}

	@Override
	public List<Barber> viewBarbersBySortedRating() {
		Sort sort = Sort.by("ratings");
		return (List<Barber>) barRepos.findAll(sort);
	}

	@Override
	public List<Services> viewAllServiceOfBarber(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true) {
			throw new BarberIdNotFoundException("There are no provied services with that particular Id");
		}
		return barRepos.viewServicesOfBarber(barberId);
	}

	@Override
	public Booking bookAService(Booking booking, int barbId, int custId, int serid, String stTime, String endTime, String dos,  Availability availa) throws BookingCreationException, BarberIdNotFoundException, ServiceNotFoundException{
		if(barRepos.existsById(barbId) != true ) {
			throw new BookingCreationException("Barber with that Id is not found, cannot Book an Order");
		}
		else if(serRepos.existsById(serid) != true) {
			throw new BookingCreationException("Service with that Id is not found, cannot provide the service");
		}
		else {
			
			booking.setBarberId(barbId);
			booking.setCid(custId);
			booking.setServiceid(serid);
			booking.setStartTime(stTime);
			booking.setEndTime(endTime);
			booking.setDateofService(dos);
			booking.setAvailable(availa);
			LocalDate date = LocalDate.now();
			booking.setDateofBooking(date);
			List<String> bName = getNameOfBarber(barbId);
			String Bname = String.join(" ", bName);
			booking.setBarberName(Bname);
			booking.setServiceName(serRepos.getNameofServiceByid(serid));
			booking.setCostatLast(getCostofTheServiceatLast(barbId,serid));
			Users u = userRepos.getById(custId);
			u.getBookings().add(booking);
			
		}
		
		return bookRepos.save(booking);
	}

	@Override
	public int changeTheService(String newServiceName, int bookingId, int serviceId) throws BarberIdNotFoundException{
		int status = 0;
		if(bookRepos.existsById(bookingId)) {
			status = bookRepos.changeTheServicebyName(newServiceName, bookingId, serviceId );
		}
		else {
			throw new BarberIdNotFoundException("Booking with that Id not found, cannot Update the service");
		}
		return status;
	}

	@Override
	public int cancelOrder(int bookingId) throws BookingIdNotFoundException{
		int status = 0;
		if(bookRepos.existsById(bookingId)) {
			bookRepos.deletethecascade(bookingId);
			 bookRepos.deleteById(bookingId);
			 return 1;
		}
		else {
			throw new BookingIdNotFoundException("Cannot cancel the Order, there is order with that Booking Id");
		}
		
	}

	/*@Override
	public int giveFeedback(int barberId, int par1, int par2, int par3) throws BarberIdNotFoundException{
		int ratingBarber = 0;
		if(barRepos.existsById(barberId)) {
			
			ratingBarber = (int)(par1+par2+par3)/3;
			
		}
		else {
			throw new BarberIdNotFoundException("Cannot take the feedback, there is No Barber with that Id");
		}
		
		return ratingBarber;
		
	}
*/
	@Override
	public List<Booking> viewBookedOrders(int customerId) throws CustomerNotFoundException{
		List<Booking> result = new ArrayList<Booking>();
		if(userRepos.existsById(customerId) != true ) {
			throw new CustomerNotFoundException("Customer with that Id is not found, cannot view Booked Orders");
		}
		else {
			Users user = userRepos.getById(customerId);
			List<Booking> bookings = user.getBookings();
			
			for(Booking b: bookings) {
				result.add(b);
			}	
			
		}
			return result;
		
		
		
	}

	@Override
	public List<Booking> viewPreviousOrders(int customerId) throws CustomerNotFoundException{
		
		if(userRepos.existsById(customerId) != true ) {
			throw new CustomerNotFoundException("Customer with that Id is not found, cannot view Previous Booked Orders");
		}
		else {
			Users user = userRepos.getById(customerId);
			LocalDate currentDate = LocalDate.now();
			LocalTime currentTime = LocalTime.now();
			List<Booking> bookings = user.getBookings();
			List<Booking> result = new ArrayList<Booking>();
			for(Booking b: bookings) {
				if(LocalDate.parse(b.getDateofService()).isBefore(currentDate)) {
					result.add(b);
				}
				else if(LocalTime.parse(b.getEndTime()).isBefore(currentTime)&& LocalDate.parse(b.getDateofService()).isEqual(currentDate)) {
					result.add(b);
				}
				
			}
			return result;
		}
		
	}

	@Override
	public List<String> getNameOfBarber(int barberId) throws BarberIdNotFoundException{
		if(barRepos.existsById(barberId) != true ) {
			throw new BarberIdNotFoundException("Cannot get name of the Barber");
		}
		return barRepos.getNameofBarberbyId(barberId);
	}

	@Override
	public double getCostPerSessionbyid(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true ) {
			throw new BarberIdNotFoundException("Cannot get cost of the Barber");
		}
		return barRepos.getCostPerSessionbyId(barberId);
	}

	@Override
	public double getCostofTheServiceatLast(int barberId, int serviceId) throws BarberIdNotFoundException,ServiceNotFoundException{
		if(barRepos.existsById(barberId) != true ) {
			throw new BarberIdNotFoundException("Barber with that Id does not exist");
		}
		else if(serRepos.existsById(serviceId) != true) {
			throw new BarberIdNotFoundException("Service with that Id does not exist");
		}
		double costatlast = serRepos.getCostOfService(serviceId)+ getCostPerSessionbyid(barberId);
		return costatlast;
	}

	 @Override
	    public Feedback giveFeedback(Feedback f1, int bid, int cid, int p1, int p2, int p3) throws BarberIdNotFoundException,CustomerNotFoundException{
	        int ratingBarber = 0;
	        if(barRepos.existsById(bid)) {
	            //Barber b = barRepos.getById(bid);
	            ratingBarber = (int)(p1+p2+p3)/3;
	            f1.setBId(bid);
	            f1.setCid(cid);
	            f1.setQualityOfService(p1);
	            f1.setPoliteness(p2);
	            f1.setProtocolsfollowed(p3);
	            f1.setFeedBack(ratingBarber);
	           
	        }
	        else {
	            throw new BarberIdNotFoundException("Cannot take the feedback, there is No Barber with that Id");
	        }
	       
	        return feedRepos.save(f1);
	    }

	        
 

	
	
	
}


