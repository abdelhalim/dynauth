package com.outlandr.dynauth.challenge;

import java.util.Map;

import com.outlandr.dynauth.user.Info;

public interface ChallengeProvider {
	
	public String getID();
	
	public String getChallenge(Info info);
	
	public boolean validateResponse(String response);
	
	public Map<String, Integer> getParameters();

}
