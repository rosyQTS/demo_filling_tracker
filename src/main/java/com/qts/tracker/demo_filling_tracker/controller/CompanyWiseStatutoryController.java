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
import com.qts.tracker.demo_filling_tracker.model.CompanyAdmin;
import com.qts.tracker.demo_filling_tracker.model.CompanyWiseStatutory;
import com.qts.tracker.demo_filling_tracker.model.Statutory;
import com.qts.tracker.demo_filling_tracker.repository.CompanyRepository;
import com.qts.tracker.demo_filling_tracker.repository.CompanyWiseStatutoryRepository;
import com.qts.tracker.demo_filling_tracker.repository.StatutoryRepository;
import com.qts.tracker.demo_filling_tracker.request.CompanyWiseStatutoryRequest;
import com.qts.tracker.demo_filling_tracker.service.CompanyWiseStatutoryService;

@RestController
public class CompanyWiseStatutoryController {
	@Autowired
	CompanyWiseStatutoryRepository companyWiseStatutoryRepository;
	@Autowired
	CompanyWiseStatutoryService companyWiseStatutoryService;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	StatutoryRepository statutoryRepository;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/companyWiseStatutorySaveData") 
	public List<CompanyWiseStatutory> companyWiseStatutorySaveData(@RequestBody CompanyWiseStatutoryRequest companyWiseStatutoryRequest) {
		return companyWiseStatutoryService.companyWiseStatutorySaveData(companyWiseStatutoryRequest);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getAllCompanyWiseStatutory")
	public List<CompanyWiseStatutory> getAllCompanyWiseStatutory() {
		List<CompanyWiseStatutory> obj = new ArrayList<CompanyWiseStatutory>();
		obj = companyWiseStatutoryService.getAllCompanyWiseStatutory();
		return obj;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(value="/enableCompanyWiseStatutory/{companyWiseStatutoryId}")
   	public ResponseEntity<ResponceMessage> enableCompanyAdmin(@PathVariable("companyWiseStatutoryId") int companyWiseStatutoryId){
    	String message = "";
    	Optional<CompanyWiseStatutory> companyWiseStatutory = companyWiseStatutoryRepository.findById(companyWiseStatutoryId);
    	CompanyWiseStatutory newData = companyWiseStatutory.get();
   		newData.setEnabled(true);
   		try {
      		 message = "Company wise Statutory  Enabled Successfully";
   		newData = companyWiseStatutoryRepository.save(newData);
   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		}catch (Exception e) {
		 message = "Company wise Statutory  Is Not Enabled Right Now";
		 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		} 
   	}
	 @CrossOrigin(origins = "*")
	    @GetMapping(value="/disableCompanyWiseStatutory/{companyWiseStatutoryId}")
	   	public ResponseEntity<ResponceMessage> disableCompanyAdmin(@PathVariable("companyWiseStatutoryId") int companyWiseStatutoryId){
	    	String message = "";
	    	Optional<CompanyWiseStatutory> companyWiseStatutory = companyWiseStatutoryRepository.findById(companyWiseStatutoryId);
	    	CompanyWiseStatutory newData = companyWiseStatutory.get();
	   		newData.setEnabled(false);
	   		try {
	   		 message = "Company wise Statutory Disabled Successfully";
	   		newData = companyWiseStatutoryRepository.save(newData);
	   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
	   		}catch (Exception e) {
				 message = "Company wise Statutory  Is Not Disabled Right Now";
				 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
			 } 
	   	}
	 @CrossOrigin(origins = "*")
	 @GetMapping("/getCompanyWiseStatutoryById/{companyWiseStatutoryId}")
	 public CompanyWiseStatutory getCompanyWiseStatutoryById(@PathVariable("companyWiseStatutoryId") int companyWiseStatutoryId) {
		 return companyWiseStatutoryService.getCompanyWiseStatutoryById(companyWiseStatutoryId);
	 }
//	 @GetMapping("/findAllCompanyWiseStatutoryByCompId/{companyId}")
//	 public List<Statutory> findAllCompanyWiseStatutoryByCompId(@PathVariable("companyId") int companyId) {
//		 return companyWiseStatutoryService.findAllCompanyWiseStatutoryByCompId(companyId);
//	 }
//	 @PostMapping("/insertCompanyWiseStatutory/{companyId}/Statutory")
//	  public ResponseEntity<Statutory> createStatutory(@PathVariable(value = "companyId") int companyId,
//	      @RequestBody Statutory CompanyWiseStatutoryRequest) {
//		 Statutory statutory = companyRepository.findById(companyId).map(Statutory -> {
//			 CompanyWiseStatutoryRequest.;
//	      return companyWiseStatutoryRepository.save(CompanyWiseStatutoryRequest);
//	    }).orElseThrow(() -> new ResourceNotFoundException("Not found Company with id = " + companyId));
//
//	  }
	 @GetMapping("/findAllCompanyWiseStatutory")
	 public List<CompanyWiseStatutory> findAllCompanyWiseStatutory(){
//		 System.out.println("Hello One");
		 List<CompanyWiseStatutory> obj=new  ArrayList<CompanyWiseStatutory>();
		 obj=companyWiseStatutoryService.findAllCompanyWiseStatutory();
//		 System.out.println("Hello Two");
		 return obj;
				 
		 
	 }
	 
	 
	 


	

}
