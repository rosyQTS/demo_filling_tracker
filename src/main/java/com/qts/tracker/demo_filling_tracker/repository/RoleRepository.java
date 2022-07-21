package com.qts.tracker.demo_filling_tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qts.tracker.demo_filling_tracker.model.ERole;
import com.qts.tracker.demo_filling_tracker.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);

}
