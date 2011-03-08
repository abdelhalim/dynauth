package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;

public class RandomTextChallengeProvider extends ChallengeProviderBase {

	@Override
	public boolean validateResponse(String response) {
		return true;
	}

	@Override
	public String getChallenge() {
		
		return "Enter some random text";
	}

}
