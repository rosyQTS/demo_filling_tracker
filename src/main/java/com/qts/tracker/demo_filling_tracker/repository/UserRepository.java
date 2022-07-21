package com.qts.tracker.demo_filling_tracker.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qts.tracker.demo_filling_tracker.model.User;
import com.qts.tracker.demo_filling_tracker.request.SignupRequest;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Object findByUsername(String username);

	Object findByEmail(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);


	Object save(SignupRequest signupRequest);


}
