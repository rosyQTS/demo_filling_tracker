package com.qts.tracker.demo_filling_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.qts.tracker.demo_filling_tracker.model.DivisionAdmin;
@Component
public interface DivisionAdminRepository extends JpaRepository<DivisionAdmin, Integer> {

}
