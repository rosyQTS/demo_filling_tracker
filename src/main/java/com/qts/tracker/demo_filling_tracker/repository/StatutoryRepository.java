package com.qts.tracker.demo_filling_tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qts.tracker.demo_filling_tracker.model.Statutory;
@Repository
public interface StatutoryRepository extends JpaRepository<Statutory, Integer>{



	

}
