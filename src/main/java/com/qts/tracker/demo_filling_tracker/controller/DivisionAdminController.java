package com.qts.tracker.demo_filling_tracker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qts.tracker.demo_filling_tracker.message.ResponceMessage;
import com.qts.tracker.demo_filling_tracker.model.DivisionAdmin;
import com.qts.tracker.demo_filling_tracker.model.DivisionEndUser;
import com.qts.tracker.demo_filling_tracker.repository.DivisionAdminRepository;
import com.qts.tracker.demo_filling_tracker.request.DivisionAdminRequest;
import com.qts.tracker.demo_filling_tracker.service.DivisionAdminService;

@RestController
public class DivisionAdminController {
	@Autowired
	DivisionAdminRepository divisionAdminRepository;
	@Autowired
	DivisionAdminService divisionAdminService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/createOrUpdateDivisionAdmin")
	public DivisionAdmin createOrUpdateDivisionAdmin(@RequestBody DivisionAdminRequest divisionAdminRequest) {
		return divisionAdminService.createOrUpdateDivisionAdmin(divisionAdminRequest);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getAllDivisionAdminDetails")
	public List<DivisionAdmin> getAllDivisionAdminDetails() {
		List<DivisionAdmin> obj = new ArrayList<DivisionAdmin>();
		obj = divisionAdminService.getAllDivisionAdminDetails();
		return obj;
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteDivisionAdminByDivisionAdminId/{divisionAdminId}")
	public String deleteDivisionAdminByDivisionAdminId(@PathVariable("divisionAdminId") int divisionAdminId) {
		return divisionAdminService.deleteDivisionById(divisionAdminId);
		
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getDivisionAdminById/{divisionAdminId}")
	public DivisionAdmin getDivisionAdminById(@PathVariable("divisionAdminId") int divisionAdminId) {
		return divisionAdminService.getDivisionAdminById(divisionAdminId);
	}
	@CrossOrigin(origins = "*")
	@GetMapping(value="/enableDivisionAdmin/{divisionAdminId}")
   	public ResponseEntity<ResponceMessage> enableDivisionEndUser(@PathVariable("divisionAdminId") int divisionAdminId){
    	String message = "";
    	Optional<DivisionAdmin> divAdmin = divisionAdminRepository.findById(divisionAdminId);
    	DivisionAdmin newData = divAdmin.get();
   		newData.setEnabled(true);
   		try {
      		 message = "Division Admin Enable Successfully";
   		newData = divisionAdminRepository.save(newData);
   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		}catch (Exception e) {
		 message = "Division Admin Is Not Enabled Right Now";
		 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		} 
   	}
	 @CrossOrigin(origins = "*")
	    @GetMapping(value="/disableDivisionAdmin/{divisionAdminId}")
	   	public ResponseEntity<ResponceMessage> disableDivisionEndUser(@PathVariable("divisionAdminId") int divisionAdminId){
	    	String message = "";
	    	Optional<DivisionAdmin> divAdmin = divisionAdminRepository.findById(divisionAdminId);
	    	DivisionAdmin newData = divAdmin.get();
	   		newData.setEnabled(false);
	   		try {
	   		 message = "Division Admin Disabled Successfully";
	   		newData = divisionAdminRepository.save(newData);
	   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
	   		}catch (Exception e) {
				 message = "Division Admin Is Not Disabled Right Now";
				 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
			 } 
	   	}
	

}
