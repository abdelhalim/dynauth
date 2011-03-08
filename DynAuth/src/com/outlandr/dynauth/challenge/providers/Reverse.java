package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;
import com.outlandr.dynauth.user.Info;

public class Reverse extends ChallengeProviderBase {

	
	public Reverse() {
		ID = "com.outlandr.dynauth.reverse";	
	}
	
	@Override
	public String getChallenge(Info info) {

		return info.getQuestion() + " reversed";
	}

	@Override
	public boolean validateResponse(String response) {
		log.info("Reverse validator");
		return true;
	}

}
