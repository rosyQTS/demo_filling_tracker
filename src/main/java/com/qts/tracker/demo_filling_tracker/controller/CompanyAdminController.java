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
import com.qts.tracker.demo_filling_tracker.model.CompanyAdmin;
import com.qts.tracker.demo_filling_tracker.repository.CompanyAdminRepository;
import com.qts.tracker.demo_filling_tracker.request.CompanyAdminRequest;
import com.qts.tracker.demo_filling_tracker.service.CompanyAdminService;

@RestController
public class CompanyAdminController {
	@Autowired
	CompanyAdminRepository companyAdminRepository;
	@Autowired
	CompanyAdminService companyAdminService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/createOrUpdateCompanyAdminDetails")
	public CompanyAdmin createOrUpdateCompanyAdminDetails(@RequestBody CompanyAdminRequest companyAdminRequest) {
		
		return companyAdminService.createOrUpdateCompanyAdmin(companyAdminRequest);
		
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteCompanyAdminByCompanyId/{cAdminId}")
	public String deleteCompanyAdminByCompanyId(@PathVariable("cAdminId") int cAdminId) {
		return companyAdminService.deleteCompanyAdminByCompanyId(cAdminId);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getCompanyAdminDetailsByCompanyAdminId/{cAdminId}")
	public CompanyAdmin getCompanyAdminDetailsByCompanyAdminId(@PathVariable("cAdminId") int cAdminId) {
	return companyAdminService.getCompanyAdminByCompanyAdminId(cAdminId);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getAllCompanyAdminDetails")
	public List<CompanyAdmin> getAllCompanyAdminDetails() {
		List<CompanyAdmin> obj = new ArrayList<CompanyAdmin>();
		obj = companyAdminService.getAllCompanyAdminDetails();
		return obj;
	} 
	@CrossOrigin(origins = "*")
	@GetMapping(value="/enableCompanyAdmin/{cAdminId}")
   	public ResponseEntity<ResponceMessage> enableCompanyAdmin(@PathVariable("cAdminId") int cAdminId){
    	String message = "";
    	Optional<CompanyAdmin> companyAdmin = companyAdminRepository.findById(cAdminId);
    	CompanyAdmin newData = companyAdmin.get();
   		newData.setEnabled(true);
   		try {
      		 message = "Company Admin Enabled Successfully";
   		newData = companyAdminRepository.save(newData);
   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		}catch (Exception e) {
		 message = "Company Admin Is Not Enabled Right Now";
		 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		} 
   	}
	 @CrossOrigin(origins = "*")
	    @GetMapping(value="/disableCompanyAdmin/{cAdminId}")
	   	public ResponseEntity<ResponceMessage> disableCompanyAdmin(@PathVariable("cAdminId") int cAdminId){
	    	String message = "";
	    	Optional<CompanyAdmin> companyAdmin = companyAdminRepository.findById(cAdminId);
	    	CompanyAdmin newData = companyAdmin.get();
	   		newData.setEnabled(false);
	   		try {
	   		 message = "Company Admin Disabled Successfully";
	   		newData = companyAdminRepository.save(newData);
	   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
	   		}catch (Exception e) {
				 message = "Company Admin Is Not Disabled Right Now";
				 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
			 } 
	   	}
	}


