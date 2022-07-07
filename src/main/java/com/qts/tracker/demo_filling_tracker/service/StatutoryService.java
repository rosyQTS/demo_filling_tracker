package com.qts.tracker.demo_filling_tracker.service;

import java.util.List;

import com.qts.tracker.demo_filling_tracker.model.Statutory;

public interface StatutoryService {

	Statutory saveStatutoryDetails(Statutory statutory);

	List<Statutory> findAllStatutory();

	String deleteStatutory(Integer statutoryId);

	String updateStatutory(Statutory statutory);

	Statutory editStatutoryById(Integer statutoryId);

}
