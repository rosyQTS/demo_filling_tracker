package com.qts.tracker.demo_filling_tracker.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.DivisionAdmin;
import com.qts.tracker.demo_filling_tracker.request.DivisionAdminRequest;
@Component
public interface DivisionAdminService {

	DivisionAdmin createOrUpdateDivisionAdmin(DivisionAdminRequest divisionAdminRequest);

	List<DivisionAdmin> getAllDivisionAdminDetails();

	String deleteDivisionById(int divisionAdminId);

	DivisionAdmin getDivisionAdminById(int divisionAdminId);

}
