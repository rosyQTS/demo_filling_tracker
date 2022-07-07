package com.qts.tracker.demo_filling_tracker.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.CompanyAdmin;
import com.qts.tracker.demo_filling_tracker.request.CompanyAdminRequest;

@Component
public interface CompanyAdminService {

	CompanyAdmin createOrUpdateCompanyAdmin(CompanyAdminRequest companyAdminRequest);

	String deleteCompanyAdminByCompanyId(int cAdminId);

	CompanyAdmin getCompanyAdminByCompanyAdminId(int cAdminId);

	List<CompanyAdmin> getAllCompanyAdminDetails();


}
