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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qts.tracker.demo_filling_tracker.message.ResponceMessage;
import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.DivisionEndUser;
import com.qts.tracker.demo_filling_tracker.model.Statutory;
import com.qts.tracker.demo_filling_tracker.repository.StatutoryRepository;
import com.qts.tracker.demo_filling_tracker.service.StatutoryService;

@RestController
public class StatutoryController {
	@Autowired
	StatutoryRepository statutoryRepository;
	@Autowired
	StatutoryService statutoryService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/createStatutory")
	public Statutory createStatutory(@RequestBody Statutory statutory) {
		return statutoryService.saveStatutoryDetails(statutory);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getAllStatutory")
	public List<Statutory> getAllStatutory() {
		List<Statutory> obj = new ArrayList<Statutory>();
		obj = statutoryService.findAllStatutory();
		return obj;
	}
	@CrossOrigin(origins = "*")
   @DeleteMapping("/deleteStatutoryById/{statutoryId}")
   public String deleteStatutoryById(@PathVariable("statutoryId") Integer statutoryId) {
	   return statutoryService.deleteStatutory(statutoryId);
   }
	@CrossOrigin(origins = "*")
   @PutMapping("/updateStatutoryDetails")
   public String updateStatutory(@RequestBody Statutory statutory) {
	   return statutoryService.updateStatutory(statutory);
   }
	@CrossOrigin(origins = "*")
   @GetMapping("/getStatutoryByStatutoryId/{statutoryId}")
   public Statutory getStatutoryByStatutoryId(@PathVariable("statutoryId")Integer statutoryId) {
	   return statutoryService.editStatutoryById(statutoryId);
   }
	
	@GetMapping(value="/enableStatutory/{statutoryId}")
   	public ResponseEntity<ResponceMessage> enableDivisionEndUser(@PathVariable("statutoryId") int statutoryId){
    	String message = "";
    	Optional<Statutory> statutory = statutoryRepository.findById(statutoryId);
    	Statutory newData = statutory.get();
   		newData.setEnabled(true);
   		try {
      		 message = "Statutory Enable Successfully";
   		newData = statutoryRepository.save(newData);
   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		}catch (Exception e) {
		 message = "Statutory Is Not Enabled Right Now";
		 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		} 
   	}
	 @CrossOrigin(origins = "*")
	    @GetMapping(value="/disableStatutory/{statutoryId}")
	   	public ResponseEntity<ResponceMessage> disableDivisionEndUser(@PathVariable("statutoryId") int statutoryId){
	    	String message = "";
	    	Optional<Statutory> statutory = statutoryRepository.findById(statutoryId);
	    	Statutory newData = statutory.get();
	   		newData.setEnabled(false);
	   		try {
	   		 message = "Statutory Disabled Successfully";
	   		newData = statutoryRepository.save(newData);
	   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
	   		}catch (Exception e) {
				 message = "Statutory Is Not Disabled Right Now";
				 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
			 } 
	   	}
   
}
