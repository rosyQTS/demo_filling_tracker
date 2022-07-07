package com.qts.tracker.demo_filling_tracker.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.repository.CompanyRepository;
import com.qts.tracker.demo_filling_tracker.service.CompanyService;
@Component
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company saveCompanyData(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	@Override
	public List<Company> findAllCompany() {
		// TODO Auto-generated method stub
		List<Company> obj= new ArrayList<Company>();
		obj=(List<Company>) companyRepository.findAll();
		return obj;
	}

	@Override
	public String editCompanyDetails(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
		return null;
	}

	@Override
	public String deleteAllCompanyDetails(Company company) {
		// TODO Auto-generated method stub
		companyRepository.delete(company);
		return null;
	}


	@Override
	public String deleteAllCompanyDetailsById(Integer cid) {
		// TODO Auto-generated method stub
		companyRepository.deleteById(cid);
		return null;
	}

	@Override
	public Company getAllCompanyByCompanyId(Integer cid) {
		// TODO Auto-generated method stub
		Optional<Company> companyDb=this.companyRepository.findById(cid);
		return companyDb.get();
	}

	@Override
	public List<Company> findAllByOrderByCidDesc() {
		// TODO Auto-generated method stub
		List<Company> company = new ArrayList<Company>();
		companyRepository.findAllByOrderByCidDesc();
		return companyRepository.findAllByOrderByCidDesc();
	}
}



//	@Override
//	public List<Company> findByAllCompanyDetailsByDesc(String cid) {
//		// TODO Auto-generated method stub
//		return (List<Company>)companyRepository.findAll(Sort.by(Sort.Direction.DESC,cid));
//	}

	


