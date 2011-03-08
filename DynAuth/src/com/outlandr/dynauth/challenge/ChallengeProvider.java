package com.outlandr.dynauth.challenge;

/*
 * Interface for Challenge Provider
 * Any challenge provider must implement this interface
 * 
 */

public interface ChallengeProvider {
	
	public String getID();
	
	public String getChallenge();
	
	public boolean validateResponse(String response);
	
}
