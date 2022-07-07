package com.qts.tracker.demo_filling_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qts.tracker.demo_filling_tracker.model.Company;
@Service
public interface CompanyService {

	Company saveCompanyData(Company company);

	List<Company> findAllCompany();

	String editCompanyDetails(Company company);

	String deleteAllCompanyDetails(Company company);

	String deleteAllCompanyDetailsById(Integer cid);

	Company getAllCompanyByCompanyId(Integer cid);

	List<Company> findAllByOrderByCidDesc();




	
	
	
	
	
	
	





}
