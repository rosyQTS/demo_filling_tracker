package com.qts.tracker.demo_filling_tracker.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
	public List<CompanyWiseStatutory> companyWiseStatutorySaveData(CompanyWiseStatutoryRequest companyWiseStatutoryRequest) {
		// TODO Auto-generated method stub
		Optional<Company> compOptional = companyRepository.findById(companyWiseStatutoryRequest.getCompanyId());
		Company company = compOptional.get();
		List<CompanyWiseStatutory> companyWiseStatutoryList= new ArrayList<CompanyWiseStatutory>();
		for(int statutoryId : companyWiseStatutoryRequest.getStatutoryId()) {
//			System.out.println(statutoryId);
			Optional<Statutory> stOptional = statutoryRepository.findById(statutoryId);
			Statutory statutory = stOptional.get();
		
			//create object of companyWisest via calling the constructor
			CompanyWiseStatutory companyWiseStatutory=new CompanyWiseStatutory(company, statutory, true);
			
			companyWiseStatutoryList.add(companyWiseStatutory);
			System.out.println(companyWiseStatutoryList.size());
//			companyWiseStatutoryRepository.save(companyWiseStatutory);
		}
		System.out.println("final"+companyWiseStatutoryList.size());
//		List<Statutory> statutoryList = statutoryRepository.findAllById(companyWiseStatutoryRequest.getStatutoryId());
//		Statutory statutory = statutoryOptional.get();
		
//		CompanyWiseStatutory companyWiseStatutory = new CompanyWiseStatutory(company,statutoryList,companyWiseStatutoryRequest.isEnabled());

		
		return companyWiseStatutoryRepository.saveAll(companyWiseStatutoryList);
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

	@Override
	public Map<Company,List<CompanyWiseStatutory>> findAllCompanyWiseStatutory() {
		System.out.println("Test in IMPL");
		List<CompanyWiseStatutory> companyWiseStatutoryList= companyWiseStatutoryRepository.findAll();
		
		
		Map<Company,List<CompanyWiseStatutory>> companyWiseStatutoryListByCompany = companyWiseStatutoryList.stream().collect(Collectors.groupingBy(CompanyWiseStatutory::getCompany));  
		Set set = companyWiseStatutoryListByCompany.entrySet();//Converting to set
		Iterator itr = set.iterator();
		
//		while(itr.hasNext()){
//			//Convert to Map.Entry so that we can get keys
//			Map.Entry entry= (Map.Entry)itr.next();
//			System.out.println(entry);
//		}
		System.out.println("Test out IMPL");
		return companyWiseStatutoryListByCompany;
	}

//	@Override
//	public List<Statutory> findAllCompanyWiseStatutoryByCompId(int companyId) {
//		// TODO Auto-generated method stub
//		List<Statutory> statutory=new ArrayList<Statutory>();
//		statutory=statutoryRepository.findAllById(companyId);
//		return statutory;
//	}

	
//	public List<ProductVersion> getProductVersionByProductId(int productid) {
//		// TODO Auto-generated method stub
//		List<ProductVersion> productVersion = new ArrayList<ProductVersion>();
//		productVersion=productVersionRepo.findAllByProductId(productid);
//		return productVersion;
//	}
//	// TODO Auto-generated method stub
//			List<Product> Products = new ArrayList<Product>();
//			Products=ProductRepo.findAllByBrandId(brandId);
//			return Products;
	

}
