package com.qts.tracker.demo_filling_tracker.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	@GetMapping("/user")
	@PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('GROUPUSER') or hasRole('COMPANYADMIN') or hasRole('DIVISIONADMIN') or hasRole('DIVISIONHEAD') or hasRole('DIVISIONENDUSER')")
	public String userAccess() {
		return "User Content.";
	}
	
	@GetMapping("/superAdmin")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public String superAdminAccess() {
		return "Super_Admin Board.";
	}
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
}
