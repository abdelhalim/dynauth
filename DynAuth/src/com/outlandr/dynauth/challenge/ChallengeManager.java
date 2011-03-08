package com.outlandr.dynauth.challenge;

import com.outlandr.dynauth.challenge.providers.OTPChallengeProvider;
import com.outlandr.dynauth.challenge.providers.Picky;
import com.outlandr.dynauth.challenge.providers.RandomTextChallengeProvider;
import com.outlandr.dynauth.challenge.providers.Reverse;
import com.outlandr.dynauth.challenge.providers.Substring;

/*
 * Challenge Manager
 * Manages the list of challenge providers, and return them to user when 
 * asked
 * To add a new challenge provider ,simple add it to the list returned
 * by getChallengeProviders() method
 * 
 */

public class ChallengeManager {		

	public static ChallengeProvider[] getChallengeProviders() { 
		return new ChallengeProvider[] {
				new Picky(), 
				new Reverse(), 
				new Substring(),
				new OTPChallengeProvider(),
				new RandomTextChallengeProvider()
				};
	}
}
