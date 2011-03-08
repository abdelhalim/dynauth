package com.outlandr.dynauth.challenge.providers;

import java.util.Map;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;
import com.outlandr.dynauth.user.Info;

public class Picky extends ChallengeProviderBase {

	
	public Picky() {
		ID = "com.outlandr.dynauth.picky";
	}
	
	@Override
	public String getChallenge(Info info) {
		
		return info.getQuestion() + " picky";
	}

	@Override
	public boolean validateResponse(String response) {
		log.info("Picky validator");
		return true;
	}


}
