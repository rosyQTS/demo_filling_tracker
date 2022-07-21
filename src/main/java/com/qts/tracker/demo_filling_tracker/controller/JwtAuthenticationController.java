package com.qts.tracker.demo_filling_tracker.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qts.tracker.demo_filling_tracker.config.JwtUtils;
import com.qts.tracker.demo_filling_tracker.message.ResponceMessage;
import com.qts.tracker.demo_filling_tracker.model.ERole;
import com.qts.tracker.demo_filling_tracker.model.Role;
import com.qts.tracker.demo_filling_tracker.model.User;
import com.qts.tracker.demo_filling_tracker.repository.RoleRepository;
import com.qts.tracker.demo_filling_tracker.repository.UserRepository;
import com.qts.tracker.demo_filling_tracker.request.LoginRequest;
import com.qts.tracker.demo_filling_tracker.request.SignupRequest;
import com.qts.tracker.demo_filling_tracker.responce.JwtResponse;
import com.qts.tracker.demo_filling_tracker.serviceImpl.UserDetailsImpl;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/api/auth")
public class JwtAuthenticationController {
	
	@Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;
	@PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getEmail(), 
	                         roles));
	  }
	
	  @RequestMapping(value = "/superAdmin/register", method = RequestMethod.POST)
	  public ResponseEntity<?> saveSuperAdminUser(@RequestBody SignupRequest signupRequest) throws
	  Exception { return ResponseEntity.ok(userRepository.save(signupRequest));
	  }

}
