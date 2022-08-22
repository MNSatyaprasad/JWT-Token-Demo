package com.token.demo.model;

public class JwtResponse {

	
	private String jetToken;

	public String getJetToken() {
		return jetToken;
	}

	public void setJetToken(String jetToken) {
		this.jetToken = jetToken;
	}

	public JwtResponse(String jetToken) {
		super();
		this.jetToken = jetToken;
	}

	public JwtResponse() {
		super();
	}
	
	
}
