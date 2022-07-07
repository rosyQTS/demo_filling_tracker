package com.qts.tracker.demo_filling_tracker.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.qts.tracker.demo_filling_tracker.message.ResponceMessage;
import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.DivisionEndUser;
import com.qts.tracker.demo_filling_tracker.repository.CompanyRepository;
import com.qts.tracker.demo_filling_tracker.service.CompanyService;


import antlr.StringUtils;

@RestController
public class CompanyController {
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	CompanyService companyService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/createCompanyData")
	public Company insertCompanyData(@RequestBody Company company) {
	return	companyService.saveCompanyData(company);
		
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/findAllCompanyName")
	public List<Company> findAll() {
		List<Company> obj = new ArrayList<Company>();
		obj = companyService.findAllCompany();
		return obj;
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/updateCompanyDetails")
	public String editCompanyDetails(@RequestBody Company company) {
		return companyService.editCompanyDetails(company);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteCompanyDetails")
	public String deleteCompanyDetails(@RequestBody Company company) {
		return companyService.deleteAllCompanyDetails(company);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteCompanyDetailsById/{cid}")
	public String deleteCompanyDetailsById(@PathVariable("cid") Integer cid) {
		return companyService.deleteAllCompanyDetailsById(cid);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/getCompanyByCompanyId/{cid}")
	public Company getCompanyByCompanyId(@PathVariable("cid") Integer cid) {
		return companyService.getAllCompanyByCompanyId(cid);
		
	}
	@CrossOrigin(origins = "*")
	@GetMapping(value="/enableCompany/{cid}")
   	public ResponseEntity<ResponceMessage> enableDivisionEndUser(@PathVariable("cid") int cid){
    	String message = "";
    	Optional<Company> company = companyRepository.findById(cid);
    	Company newData = company.get();
   		newData.setEnabled(true);
   		try {
      		 message = "Company Enable Successfully";
   		newData = companyRepository.save(newData);
   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		}catch (Exception e) {
		 message = "Company Is Not Enabled Right Now";
		 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
		} 
   	}
	 @CrossOrigin(origins = "*")
	    @GetMapping(value="/disableCompany/{cid}")
	   	public ResponseEntity<ResponceMessage> disableDivisionEndUser(@PathVariable("cid") int cid){
	    	String message = "";
	    	Optional<Company> company = companyRepository.findById(cid);
	    	Company newData = company.get();
	   		newData.setEnabled(false);
	   		try {
	   		 message = "Company Disabled Successfully";
//	   		newData = companyRepository.save(newData);
	   		 System.out.println("91"+newData);
	   		 Company updatedCompany=companyRepository.save(newData);
	   		 System.out.println("93"+updatedCompany);
	   		
	   		return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
	   		}catch (Exception e) {
				 message = "Company Is Not Disabled Right Now";
				 return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
			 } 
	   	}
	 @CrossOrigin(origins = "*")
	 @GetMapping("/findAllByOrderByCidDesc")
	 public List<Company> findAllByOrderByCidDesc()
		{
			 return (List<Company>)companyService.findAllByOrderByCidDesc();

		
		}

	 private static String UPLOADED_FOLDER = System.getProperty("user.home");

	    @CrossOrigin(origins = "*") 
		 @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) 
		  public String singleFileUpload(@RequestParam("file") List<MultipartFile> file) {
	    	System.out.println("UPLOADED_FOLDER "+UPLOADED_FOLDER);
			 String directory = UPLOADED_FOLDER+"/IMAGEUPLOAD/";
			 System.out.println("directory "+directory);
			 Date date= new Date();
			 long time = date.getTime();
			 String naming = "";
			 File filee = new File(directory);
	      	  filee.mkdirs();
			 for (MultipartFile multipartFile : file) {
				 if (naming.equals("")) {
			       		naming = time+"_"+multipartFile.getOriginalFilename();
			       	}else {
			       		naming = naming+","+time+"_"+multipartFile.getOriginalFilename();
			       	}
				 try {
					 filee = new File(directory + File.separator + time+"_"+multipartFile.getOriginalFilename());
		           	  System.out.println("path "+filee.getAbsolutePath());
		           	  IOUtils.copy(multipartFile.getInputStream(), new FileOutputStream(filee));
		           	 System.out.println("in try");
		       	  }
		       	  catch(Exception e) {
		       		  System.out.println("in catch");
		       		  System.out.println(e);
		       	  }
			 }
			 System.out.println("database name "+naming);
			 return naming;
		 }
	
 
}
