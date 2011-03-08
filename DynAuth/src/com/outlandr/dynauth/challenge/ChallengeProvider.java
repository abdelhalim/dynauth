package com.outlandr.dynauth.challenge;


public interface ChallengeProvider {
	
	public String getID();
	
	public String getChallenge();
	
	public boolean validateResponse(String response);
	
}
