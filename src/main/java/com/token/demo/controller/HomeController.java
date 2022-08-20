package com.token.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.token.demo.model.JwtRequest;
import com.token.demo.model.JwtResponse;
import com.token.demo.service.UserService;
import com.token.demo.utility.JWTUtility;

@RestController
public class HomeController {
	
	@Autowired
	private JWTUtility jwtutility;
	
	@Autowired
	private AuthenticationManager  authenzticationmaanger;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to  Jwt Demo Project";
	}
	
   @PostMapping("/authenticate")
   public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
	   try {
		   authenzticationmaanger.authenticate(
				   new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		    }catch (BadCredentialsException e) {
		    	throw new Exception("INVALID_CRENDENTIALS",e);
		    }
	   
   }
   
}
