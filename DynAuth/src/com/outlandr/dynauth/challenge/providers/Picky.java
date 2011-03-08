package com.outlandr.dynauth.challenge.providers;

import java.util.Random;

import com.outlandr.dynauth.user.Info;
/*
 * Picky Challenge Provider
 * challenge the user by asking for selected characters from his stored
 * info
 */
public class Picky extends TextChallengeProvider {

	
	private Info info;
	private int challengePosition;
	private Random rn = new Random();
	
	@Override
	public String getChallenge(Info info) {
		this.info = info;
		challengePosition = Math.abs(rn.nextInt()) % info.getAnswer().length();
		return info.getQuestion() + 
			"<br>" +
			"Enter only character at position " 
			+ "<img src=\"images/i" + challengePosition + ".png\"/>";
	}

	@Override
	public boolean validateResponse(String response) {
		if (response.length() > 1)
			return false;
		
		if (response.charAt(0) != info.getAnswer().charAt(challengePosition))
			return false;
		
		return true;
	}

	@Override
	public String getID() {
		return "com.outlandr.dynauth.picky";
	}

}
