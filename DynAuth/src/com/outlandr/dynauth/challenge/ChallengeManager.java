package com.outlandr.dynauth.challenge;

import com.outlandr.dynauth.challenge.providers.OTPChallengeProvider;
import com.outlandr.dynauth.challenge.providers.Picky;
import com.outlandr.dynauth.challenge.providers.RandomTextChallengeProvider;
import com.outlandr.dynauth.challenge.providers.Reverse;
import com.outlandr.dynauth.challenge.providers.Substring;

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
