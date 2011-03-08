package com.outlandr.dynauth.challenge;

import java.util.logging.Logger;

public abstract class ChallengeProviderBase implements ChallengeProvider {

    protected static final Logger log = Logger.getLogger(ChallengeProviderBase.class.getName());


	@Override
	public String getChallenge() {
		// Not implemented
		return null;
	}

}