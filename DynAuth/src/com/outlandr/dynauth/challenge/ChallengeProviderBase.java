package com.outlandr.dynauth.challenge;

import java.util.logging.Logger;

public abstract class ChallengeProviderBase implements ChallengeProvider {

	protected static String ID;
	
    protected static final Logger log = Logger.getLogger(ChallengeProviderBase.class.getName());


	public String getID() {
		return ID;
	}

	

}