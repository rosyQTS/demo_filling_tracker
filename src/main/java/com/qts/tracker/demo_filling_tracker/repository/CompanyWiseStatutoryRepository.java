package com.qts.tracker.demo_filling_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qts.tracker.demo_filling_tracker.model.CompanyWiseStatutory;
@Repository
public interface CompanyWiseStatutoryRepository extends JpaRepository<CompanyWiseStatutory, Integer>{

}
