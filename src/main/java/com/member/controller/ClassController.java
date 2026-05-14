package com.member.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.entity.Booking;
import com.member.entity.ClassName;
import com.member.repository.BookingRepository;
import com.member.repository.GymClassRepository;


@RestController
@RequestMapping("/classes")
public class ClassController {
	
	@Autowired
	private  GymClassRepository classRepo;
	@Autowired
	private  BookingRepository bookingRepo;
	
	// ADMIN: create class
	  @PostMapping
	  public ResponseEntity<ClassName> create(@RequestBody ClassName c) {
		  ClassName gc= classRepo.save(c);
		  return ResponseEntity.ok(gc);
	  }
	// USER: view all classes
	  
	  @GetMapping
	  public ResponseEntity<List<ClassName>> getAll(){
		  List<ClassName> list=classRepo.findAll();
		  return  ResponseEntity.ok(list);
	  }
	  
	  //// USER (PAID): book class
	  @PostMapping("/{classId}/book")
	public ResponseEntity<String> book(@PathVariable Long classId,@RequestHeader("userId") Long userId) {
		if(bookingRepo.existsByClassIdAndUserId(classId, userId)) {
			return ResponseEntity.ok("Already Book");
		}
		
		Booking b = new Booking();
	    b.setClassId(classId);
	    b.setUserId(userId);
	    b.setBookedAt(LocalDateTime.now());

	    bookingRepo.save(b);
	    return ResponseEntity.ok("Booking successful");
	}
	  @GetMapping("/bookingList")
	  public ResponseEntity<List<Booking>> getAllBooking(){
		  List<Booking> list=bookingRepo.findAll();
		  return  ResponseEntity.ok(list);
	  }
	  
	  
	  
	
	
}
