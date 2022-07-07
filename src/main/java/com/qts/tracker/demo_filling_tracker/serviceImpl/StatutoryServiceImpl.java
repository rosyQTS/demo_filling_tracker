package com.qts.tracker.demo_filling_tracker.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.Company;
import com.qts.tracker.demo_filling_tracker.model.Statutory;
import com.qts.tracker.demo_filling_tracker.repository.StatutoryRepository;
import com.qts.tracker.demo_filling_tracker.service.StatutoryService;
@Component
public class StatutoryServiceImpl implements StatutoryService {
       @Autowired
       StatutoryRepository statutoryRepository;
	@Override
	public Statutory saveStatutoryDetails(Statutory statutory) {
		// TODO Auto-generated method stub
		statutoryRepository.save(statutory);
		return statutoryRepository.save(statutory);
	}
	@Override
	public List<Statutory> findAllStatutory() {
		// TODO Auto-generated method stub
		List<Statutory> obj= new ArrayList<Statutory>();
		obj=(List<Statutory>) statutoryRepository.findAll();
		return obj;
	}
	@Override
	public String deleteStatutory(Integer statutoryId) {
		// TODO Auto-generated method stub
		statutoryRepository.deleteById(statutoryId);
		return null;
	}
	@Override
	public String updateStatutory(Statutory statutory) {
		// TODO Auto-generated method stub
		statutoryRepository.save(statutory);
		return null;
	}
	@Override
	public Statutory editStatutoryById(Integer statutoryId) {
		// TODO Auto-generated method stub
		Optional<Statutory> statutoryDb=this.statutoryRepository.findById(statutoryId);
		return statutoryDb.get();
	}

}
