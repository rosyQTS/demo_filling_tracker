package com.qts.tracker.demo_filling_tracker.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.CompanyAdmin;
import com.qts.tracker.demo_filling_tracker.repository.CompanyAdminRepository;
import com.qts.tracker.demo_filling_tracker.repository.CompanyRepository;
import com.qts.tracker.demo_filling_tracker.request.CompanyAdminRequest;
import com.qts.tracker.demo_filling_tracker.service.CompanyAdminService;
@Component
public class CompanyAdminServiceImpl implements CompanyAdminService{
	@Autowired
	CompanyAdminRepository companyAdminRepository;
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public CompanyAdmin createOrUpdateCompanyAdmin(CompanyAdminRequest companyAdminRequest) {
		
		//0-Set all the data from request to entity
		
//		companyAdmin.setEmailId(companyAdminRequest.getEmailId());
//		companyAdmin.setFullName(companyAdminRequest.getFullName());
//		companyAdmin.setPhno(companyAdminRequest.getPhno());
//		companyAdmin.setPassword(companyAdminRequest.getPassword());
		//1-get the fk-com-id vfrom thwew request id
//		String fk_company_id = 
		//2-get company by the id compRepo.findById(id)
		Optional<Company> compOptional = companyRepository.findById(companyAdminRequest.getcompanyId());
		Company company = compOptional.get();
		//3-set the comp object in the companyAdmin.setCompany()
//		companyAdmin.setCompany(company);
		// TODO Auto-generated method stub
		//String fullName, String emailId, String phno, String password,Company company
		//using constructor
		
		CompanyAdmin companyAdmin = new CompanyAdmin(companyAdminRequest.getcAdminId(),companyAdminRequest.getFullName(),companyAdminRequest.getEmailId(),companyAdminRequest.getphNumber(),companyAdminRequest.getPassword(),companyAdminRequest.isEnabled(),company);
		
		companyAdminRepository.save(companyAdmin);
		return companyAdminRepository.save(companyAdmin);
	}

	@Override
	public String deleteCompanyAdminByCompanyId(int cAdminId) {
		// TODO Auto-generated method stub
		companyAdminRepository.deleteById(cAdminId);
		return "CompanyAdmin Deleted Successfully";
	}

	@Override
	public CompanyAdmin getCompanyAdminByCompanyAdminId(int cAdminId) {
		// TODO Auto-generated method stub
		Optional<CompanyAdmin> companyAdminDb=this.companyAdminRepository.findById(cAdminId);
		return companyAdminDb.get();
	}

	@Override
	public List<CompanyAdmin> getAllCompanyAdminDetails() {
		// TODO Auto-generated method stub
		List<CompanyAdmin> obj=new ArrayList<CompanyAdmin>();
		obj=(List<CompanyAdmin>) companyAdminRepository.findAll();
		return obj;
	}

	


}
