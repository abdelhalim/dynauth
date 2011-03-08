package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;
import com.outlandr.dynauth.user.Info;

/*
 * Challenge Provider Abstract class
 * Provide challenge based on user info
 */
public abstract class TextChallengeProvider extends ChallengeProviderBase {

	/**
	 * get the challenge question
	 * @param info User info
	 * 
	 */
	public abstract String getChallenge(Info info);
}
