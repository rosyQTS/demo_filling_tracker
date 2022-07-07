package com.qts.tracker.demo_filling_tracker.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.DivisionEndUser;
import com.qts.tracker.demo_filling_tracker.request.DivisionEndUserRequest;
@Component
public interface DivisionEndUserService {

	DivisionEndUser createOrUpdateDivisionEndUser(DivisionEndUserRequest divisionEndUserRequest);

	List<DivisionEndUser> getAllDivisionEndUser();

	DivisionEndUser getDivisionEndUserByEndUserId(int divEndUserId);

}
