package com.customer.security;

public class JwtTokenClaims {
	private String username;

	public JwtTokenClaims() {
		// TODO Auto-generated constructor stub
	}

	public JwtTokenClaims(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "JwtTokenClaims [username=" + username + "]";
	}

}
