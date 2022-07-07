package com.qts.tracker.demo_filling_tracker.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.CompanyAdmin;
import com.qts.tracker.demo_filling_tracker.model.DivisionAdmin;
import com.qts.tracker.demo_filling_tracker.model.DivisionEndUser;
import com.qts.tracker.demo_filling_tracker.repository.CompanyAdminRepository;
import com.qts.tracker.demo_filling_tracker.repository.CompanyRepository;
import com.qts.tracker.demo_filling_tracker.repository.DivisionAdminRepository;
import com.qts.tracker.demo_filling_tracker.repository.DivisionEndUserRepository;
import com.qts.tracker.demo_filling_tracker.request.DivisionEndUserRequest;
import com.qts.tracker.demo_filling_tracker.service.DivisionEndUserService;
@Component
public class DivisionEndUserServiceImpl implements DivisionEndUserService{
	@Autowired
	DivisionEndUserRepository divisionEndUserRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	CompanyAdminRepository companyAdminRepository; 
	@Autowired
	DivisionAdminRepository divisionAdminrepository;
	@Override
	public DivisionEndUser createOrUpdateDivisionEndUser(DivisionEndUserRequest divisionEndUserRequest) {
		// TODO Auto-generated method stub
		Optional<Company> compOptional = companyRepository.findById(divisionEndUserRequest.getCompanyId());
		Company company = compOptional.get();
		
		Optional<CompanyAdmin> compAdOptional = companyAdminRepository.findById(divisionEndUserRequest.getCompanyAdminId());
		CompanyAdmin companyAdmin = compAdOptional.get();
		
		Optional<DivisionAdmin> divAdOptional = divisionAdminrepository.findById(divisionEndUserRequest.getDivisionAdminId());
		DivisionAdmin divisionAdmin = divAdOptional.get();
		
		DivisionEndUser divisionEndUser = new DivisionEndUser(divisionEndUserRequest.getDivEndUserId(),divisionEndUserRequest.getFullName(),divisionEndUserRequest.getMail(),divisionEndUserRequest.getPhoneNumber(),divisionEndUserRequest.isEnabled(),company,companyAdmin,divisionAdmin);
//		divisionEndUserRepository.save(divisionEndUser);
		
		return divisionEndUserRepository.save(divisionEndUser);
	}
	@Override
	public List<DivisionEndUser> getAllDivisionEndUser() {
		// TODO Auto-generated method stub
		List<DivisionEndUser> obj=new ArrayList<DivisionEndUser>();
		obj=(List<DivisionEndUser>) divisionEndUserRepository.findAll();
		return obj;
	}
	@Override
	public DivisionEndUser getDivisionEndUserByEndUserId(int divEndUserId) {
		// TODO Auto-generated method stub
		Optional<DivisionEndUser> divisionEndUserDb=this.divisionEndUserRepository.findById(divEndUserId);
		return divisionEndUserDb.get();
	}

}
