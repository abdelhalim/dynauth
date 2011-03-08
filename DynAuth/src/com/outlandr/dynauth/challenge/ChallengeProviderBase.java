package com.outlandr.dynauth.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.outlandr.dynauth.BasicAuthServlet;

public abstract class ChallengeProviderBase implements ChallengeProvider {

	protected static String ID;
	protected Map<String, Integer> parameters = new HashMap();
	
    protected static final Logger log = Logger.getLogger(ChallengeProviderBase.class.getName());

	
	public ChallengeProviderBase() {
		super();
	}

	public String getID() {
		return ID;
	}

	@Override
	public Map<String, Integer> getParameters() {
		return  parameters;
	}
	

}