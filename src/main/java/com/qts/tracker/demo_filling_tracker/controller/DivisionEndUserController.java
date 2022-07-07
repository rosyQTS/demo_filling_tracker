package com.qts.tracker.demo_filling_tracker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qts.tracker.demo_filling_tracker.message.ResponceMessage;
import com.qts.tracker.demo_filling_tracker.model.DivisionEndUser;
import com.qts.tracker.demo_filling_tracker.repository.DivisionEndUserRepository;
import com.qts.tracker.demo_filling_tracker.request.DivisionEndUserRequest;
import com.qts.tracker.demo_filling_tracker.service.DivisionEndUserService;

@RestController
public class DivisionEndUserController {
	@Autowired
	DivisionEndUserService divisionEndUserService;
	@Autowired
	DivisionEndUserRepository divisionEndUserRepository;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/createOrUpdateDivisionEndUser")
	public DivisionEndUser createOrUpdateDivisionEndUser(@RequestBody DivisionEndUserRequest divisionEndUserRequest) {
		return divisionEndUserService.createOrUpdateDivisionEndUser(divisionEndUserRequest);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getAllDivisionEndUser")
	public List<DivisionEndUser> getAllDivisionEndUser() {
		List<DivisionEndUser> obj = new ArrayList<DivisionEndUser>();
		obj = divisionEndUserService.getAllDivisionEndUser();
		return obj;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getDivisionEndUserByEndUserId/{divEndUserId}")
	public DivisionEndUser getDivisionEndUserByEndUserId(@PathVariable ("divEndUserId") int divEndUserId) {
		return divisionEndUserService.getDivisionEndUserByEndUserId(divEndUserId);
	}
	@CrossOrigin(origins = "*")
    @GetMapping(value="/enableDivisionEndUser/{divEndUserId}")
   	public ResponseEntity<ResponceMessage> enableDivisionEndUser(@PathVariable("divEndUserId") int divEndUserId){
    	String message = "";
    	Optional<DivisionEndUser> divEndUser = divisionEndUserRepository.findById(divEndUserId);
    	DivisionEndUser newData = divEndUser.get();
   		newData.setEnabled(true);
   		try {
      		 message = "Division EndUser Enable Successfully";
   		newData = divisionEndUserRepository.save(newData);
   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		}catch (Exception e) {
		 message = "Division EndUser Is Not Enabled Right Now";
		 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		} 
   	}
	 @CrossOrigin(origins = "*")
	    @GetMapping(value="/disableDivisionEndUser/{divEndUserId}")
	   	public ResponseEntity<ResponceMessage> disableDivisionEndUser(@PathVariable("divEndUserId") int divEndUserId){
	    	String message = "";
	    	Optional<DivisionEndUser> divEndUser = divisionEndUserRepository.findById(divEndUserId);
	    	DivisionEndUser newData = divEndUser.get();
	   		newData.setEnabled(false);
	   		try {
	   		 message = "Division EndUser Disabled Successfully";
	   		newData = divisionEndUserRepository.save(newData);
	   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
	   		}catch (Exception e) {
				 message = "Division EndUser Is Not Disabled Right Now";
				 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
			 } 
	   	}

}
