package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;
import com.outlandr.dynauth.user.Info;

public class Substring extends ChallengeProviderBase {

	public Substring() {
		ID = "com.outlandr.dynauth.substring";
	}

	@Override
	public String getChallenge(Info info) {
		return info.getQuestion() + " substring";
	}

	@Override
	public boolean validateResponse(String response) {
		log.info("Substring validator");
		return true;
	}


}
