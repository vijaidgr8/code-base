package com.cappack13;

import java.time.LocalDateTime;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cappack13.exception.AdminInvalidException;
import com.cappack13.exception.BarberCreationException;
import com.cappack13.exception.BarberIdNotFoundException;
import com.cappack13.exception.BookingCreationException;
import com.cappack13.exception.BookingIdNotFoundException;
import com.cappack13.exception.CustomerNotFoundException;
import com.cappack13.exception.ErrorMessage;
import com.cappack13.exception.ServiceCreationException;
import com.cappack13.exception.ServiceNotFoundException;
import com.cappack13.exception.TimeSlotCreationException;
import com.cappack13.exception.UserException;


@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserException.class)
	public @ResponseBody ErrorMessage checkUserException(UserException e) {
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(AdminInvalidException.class)
	public @ResponseBody ErrorMessage checkInvalidAdminException(AdminInvalidException e) {
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ErrorMessage checkBookValidation(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	@ExceptionHandler(BarberIdNotFoundException.class)
	public @ResponseBody ErrorMessage checkBarberIdNotFoundException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody ErrorMessage checkCustomerNotFoundException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
	@ExceptionHandler(ServiceNotFoundException.class)
	public @ResponseBody ErrorMessage checkServiceNotFoundException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
	@ExceptionHandler(BarberCreationException.class)
	public @ResponseBody ErrorMessage checkBarberCreationException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
	@ExceptionHandler(ServiceCreationException.class)
	public @ResponseBody ErrorMessage checkServiceCreationException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
	@ExceptionHandler(BookingCreationException.class)
	public @ResponseBody ErrorMessage checkBookingCreationException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
	@ExceptionHandler(BookingIdNotFoundException.class)
	public @ResponseBody ErrorMessage checkBookingIdNotFoundException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
	@ExceptionHandler(TimeSlotCreationException.class)
	public @ResponseBody ErrorMessage checkTimeSlotCreationException(MethodArgumentNotValidException e)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	

}