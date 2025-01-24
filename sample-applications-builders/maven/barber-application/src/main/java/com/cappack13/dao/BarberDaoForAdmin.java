package com.cappack13.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cappack13.exception.BarberCreationException;
import com.cappack13.exception.BarberIdNotFoundException;
import com.cappack13.exception.ServiceCreationException;
import com.cappack13.model.Barber;
import com.cappack13.model.Feedback;
import com.cappack13.model.Services;
import com.cappack13.model.TimeSlots;
import com.cappack13.model.Users;
import com.cappack13.repository.BarberRepository;
import com.cappack13.repository.FeedbackRepository;
import com.cappack13.repository.ServiceRepository;
import com.cappack13.repository.UsersRepository;
import com.cappack13.service.IBarberServicesForAdmin;

@Service
public class BarberDaoForAdmin implements IBarberServicesForAdmin{
	
	@Autowired
	FeedbackRepository feedRepos;
	
	@Autowired
	BarberRepository barRepos;
	
	@Autowired
	ServiceRepository serRepos;

	@Autowired
	UsersRepository userRepos;
	
	public List<Users> viewAllCustomers(){
		return userRepos.findAll();
	}
	
	@Override
	public Barber addBarber(Barber barber) throws BarberCreationException {
		
		if(barRepos.existsById(barber.getBarberId())) {
			throw new BarberCreationException("Barber with the same Id already Exists");
		}
		
		return barRepos.save(barber);
		
	}
	
    
	
	   


	

	@Override
	public Services addService(Services service) throws ServiceCreationException{
		
		if(serRepos.existsById(service.getServiceId())) {
			throw new ServiceCreationException("Service with the same Id is available");
		}
		return serRepos.save(service);
	}

	@Override
	public int updatingCostOfBarber(int barberid, double cost) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberid) != true) {
			throw new BarberIdNotFoundException("Barber with this Id is not found, cannot update the cost");
			
		}
		return barRepos.updatingcostOfBarber(barberid, cost);
	}

	@Override
	public List<Barber> viewBarbersBySortedRating() {
		Sort sort = Sort.by("ratings").descending();
		return (List<Barber>) barRepos.findAll(sort);
	}

	@Override
	public List<Barber> viewAllBarbers() {
		return barRepos.findAll();
	}

	@Override
	public List<Services> viewServicesofBarber(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true) {
			throw new BarberIdNotFoundException("Barber with this Id is not found, cannot view services");
			
		}
		return barRepos.viewServicesOfBarber(barberId);
	}

	@Override
	public List<TimeSlots> viewTimeSlotsofBarber(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true) {
			throw new BarberIdNotFoundException("Barber with this Id is not found, cannot view the slots");
			
		}
		return barRepos.viewTimeSlotsOfBarber(barberId);
	}
	
	@Override
	public Barber addService(Services service,int barberid){
		
		
		Barber b=barRepos.getById(barberid);
		List<Services> l=b.getServices();
		l.add(service);
		b.setServices(l);
		return barRepos.save(b);
		
	
	}

	@Override
	public List<Feedback> viewFeedbacksgivenByCustomers() {
		// TODO Auto-generated method stub
		return feedRepos.findAll();
	}

	@Override
	public int updateratingsofbarber(int id) {
		// TODO Auto-generated method stub
		Double rate = getavgfeedbackbybid(id);
        int ratings = rate.intValue();
        int status = barRepos.updatingratingOfBarber(id, ratings);
        return status;
	}
	
	@Override
    public Double getavgfeedbackbybid(int id) {
        return feedRepos.getavgoffeedbackonbarber(id);
    }

}
