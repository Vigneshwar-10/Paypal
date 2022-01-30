package com.paypal.bfs.test.bookingserv.api;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.bfs.test.bookingserv.api.model.Booking;



@EntityScan("com.paypal.bfs.test.bookingserv.api.model")
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
	@RequestMapping("/v1/bfs/booking/{@id}")
	ResponseEntity<Booking> getBooking(int id);

}
