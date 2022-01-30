package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingRepository;
import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;

@RestController
@ComponentScan("com.paypal.bfs.test.bookingserv.api.model")
public class BookingResourceImpl implements BookingResource {
    
	BookingRepository bookingRepository;
	
	@Override
    @PostMapping("/v1/bfs/booking")
    public ResponseEntity<Booking> create(@Valid @RequestBody Booking booking)
    {   	
    		ResponseEntity<Booking> response = new ResponseEntity<Booking>(HttpStatus.OK);
    		return response;
    }
    
	@GetMapping("/v1/bfs/booking/{id}")
	public ResponseEntity<Booking> getBooking(@RequestParam(required = true) int id)
	{
		Optional<Booking> bookingData = bookingRepository.findById(Integer.valueOf(id));

		if (bookingData.isPresent()) {
			return new ResponseEntity<>(bookingData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) 
    {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
