package com.qts.tracker.demo_filling_tracker.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.CompanyAdmin;
import com.qts.tracker.demo_filling_tracker.model.CompanyWiseStatutory;
import com.qts.tracker.demo_filling_tracker.model.DivisionAdmin;
import com.qts.tracker.demo_filling_tracker.model.DivisionEndUser;
import com.qts.tracker.demo_filling_tracker.model.Statutory;
import com.qts.tracker.demo_filling_tracker.repository.CompanyRepository;
import com.qts.tracker.demo_filling_tracker.repository.CompanyWiseStatutoryRepository;
import com.qts.tracker.demo_filling_tracker.repository.StatutoryRepository;
import com.qts.tracker.demo_filling_tracker.request.CompanyWiseStatutoryRequest;
import com.qts.tracker.demo_filling_tracker.service.CompanyWiseStatutoryService;
@Component
public class CompanyWiseStatutoryServiceImpl implements CompanyWiseStatutoryService {
	@Autowired
	CompanyWiseStatutoryRepository companyWiseStatutoryRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	StatutoryRepository statutoryRepository;

	@Override
	public CompanyWiseStatutory companyWiseStatutorySaveData(CompanyWiseStatutoryRequest companyWiseStatutoryRequest) {
		// TODO Auto-generated method stub
		Optional<Company> compOptional = companyRepository.findById(companyWiseStatutoryRequest.getCompanyId());
		Company company = compOptional.get();
		
		List<Statutory> statutoryList = statutoryRepository.findAllById(companyWiseStatutoryRequest.getStatutoryId());
//		Statutory statutory = statutoryOptional.get();
		
		CompanyWiseStatutory companyWiseStatutory = new CompanyWiseStatutory(company,statutoryList,companyWiseStatutoryRequest.isEnabled());

		
		return companyWiseStatutoryRepository.save(companyWiseStatutory);
	}

	@Override
	public List<CompanyWiseStatutory> getAllCompanyWiseStatutory() {
		// TODO Auto-generated method stub
		List<CompanyWiseStatutory> obj=new ArrayList<CompanyWiseStatutory>();
		obj=(List<CompanyWiseStatutory>) companyWiseStatutoryRepository.findAll();
		return obj;
	}

	@Override
	public CompanyWiseStatutory getCompanyWiseStatutoryById(int companyWiseStatutoryId) {
		// TODO Auto-generated method stub
		Optional<CompanyWiseStatutory> companyWiseStatutoryDb=this.companyWiseStatutoryRepository.findById(companyWiseStatutoryId);
		return companyWiseStatutoryDb.get();
	}

}
