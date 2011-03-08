package com.outlandr.dynauth.challenge.providers;

import java.util.Random;

import com.outlandr.dynauth.user.Info;

public class Picky extends TextChallengeProvider {

	
	private Info info;
	private int challengePosition;
	private Random rn = new Random();

	public Picky() {
		ID = "com.outlandr.dynauth.picky";
	}
	
	@Override
	public String getChallenge(Info info) {
		this.info = info;
		challengePosition = Math.abs(rn.nextInt()) % info.getAnswer().length();
		return info.getQuestion() + 
			"<br>" +
			"Enter only character at position " + challengePosition;
	}

	@Override
	public boolean validateResponse(String response) {
		if (response.length() > 1)
			return false;
		
		if (response.charAt(0) != info.getAnswer().charAt(challengePosition))
			return false;
		
		return true;
	}


}
