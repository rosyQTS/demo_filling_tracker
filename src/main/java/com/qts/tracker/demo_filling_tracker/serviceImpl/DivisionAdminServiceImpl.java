package com.qts.tracker.demo_filling_tracker.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.CompanyAdmin;
import com.qts.tracker.demo_filling_tracker.model.DivisionAdmin;
import com.qts.tracker.demo_filling_tracker.repository.CompanyRepository;
import com.qts.tracker.demo_filling_tracker.repository.DivisionAdminRepository;
import com.qts.tracker.demo_filling_tracker.request.DivisionAdminRequest;
import com.qts.tracker.demo_filling_tracker.service.DivisionAdminService;
@Component
public class DivisionAdminServiceImpl implements DivisionAdminService{
	@Autowired
	DivisionAdminRepository divisionAdminRepository;
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public DivisionAdmin createOrUpdateDivisionAdmin(DivisionAdminRequest divisionAdminRequest) {
		// TODO Auto-generated method stub
		Optional<Company> compOptional = companyRepository.findById(divisionAdminRequest.getCompanyId());
		Company company = compOptional.get();
		DivisionAdmin divisionAdmin = new DivisionAdmin(divisionAdminRequest.getDivisionAdminId(),divisionAdminRequest.getFullName(),divisionAdminRequest.getEmailId(),divisionAdminRequest.getPhoneNumber(),divisionAdminRequest.getDivisionName(),divisionAdminRequest.getPassword(),divisionAdminRequest.isEnabled(),company);
		divisionAdminRepository.save(divisionAdmin);
		return divisionAdminRepository.save(divisionAdmin);
	}

	@Override
	public List<DivisionAdmin> getAllDivisionAdminDetails() {
		// TODO Auto-generated method stub
		List<DivisionAdmin> obj=new ArrayList<DivisionAdmin>();
		obj=(List<DivisionAdmin>) divisionAdminRepository.findAll();
		return obj;
	}

	@Override
	public String deleteDivisionById(int divisionAdminId) {
		// TODO Auto-generated method stub
		divisionAdminRepository.deleteById(divisionAdminId);
		return "DivisionAdmin Deleted Successfully";
	}

	@Override
	public DivisionAdmin getDivisionAdminById(int divisionAdminId) {
		// TODO Auto-generated method stub
		Optional<DivisionAdmin> divisionAdminDb=this.divisionAdminRepository.findById(divisionAdminId);
		return divisionAdminDb.get();
	}
	


	

}
