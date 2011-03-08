package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;

/*
 * accepts any entered text, The purpose is just to confuse any keylogger
 * 
 */
public class RandomTextChallengeProvider extends ChallengeProviderBase {

	@Override
	public boolean validateResponse(String response) {
		return true;
	}

	@Override
	public String getChallenge() {		
		return "Enter some random text";
	}

	@Override
	public String getID() {
		return "com.outlandr.dynauth.randomtext";
	}

}
