package com.qts.tracker.demo_filling_tracker.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.qts.tracker.demo_filling_tracker.model.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{


	List<Company> findAllByOrderByCidDesc();



}
