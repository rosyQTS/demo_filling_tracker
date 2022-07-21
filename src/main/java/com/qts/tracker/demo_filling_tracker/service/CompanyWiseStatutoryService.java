package com.qts.tracker.demo_filling_tracker.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.CompanyWiseStatutory;
import com.qts.tracker.demo_filling_tracker.model.Statutory;
import com.qts.tracker.demo_filling_tracker.request.CompanyWiseStatutoryRequest;

@Service
public interface CompanyWiseStatutoryService {

	List<CompanyWiseStatutory> companyWiseStatutorySaveData(CompanyWiseStatutoryRequest companyWiseStatutoryRequest);

	List<CompanyWiseStatutory> getAllCompanyWiseStatutory();

	CompanyWiseStatutory getCompanyWiseStatutoryById(int companyWiseStatutoryId);

	Map<Company,List<CompanyWiseStatutory>> findAllCompanyWiseStatutory();

//	List<Statutory> findAllCompanyWiseStatutoryByCompId(int companyId);

}
