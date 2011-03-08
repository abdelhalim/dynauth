package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.user.Info;

/*
 * Reverse Challenge Provider
 * challenge the user by asking for the info in reverse order
 */

public class Reverse extends TextChallengeProvider {

	private Info info;
	
	@Override
	public String getChallenge(Info info) {
		this.info = info;
		return info.getQuestion() 
		+ "<br>"
		+ "Enter the answer reversed";
	}

	@Override
	public boolean validateResponse(String response) {
		log.info("Reverse validator");
		
		// length should be the same
		int length = response.length();
		if (length != info.getAnswer().length())
			return false;
		
		/* The response and expected answer should match, but 
		 * with reversed order 
		 */
		for (int i=0; i<length; i++) {
			if (response.charAt(i) != info.getAnswer().charAt(length - i -1)) {
				return false;
			}
		}
		return true;
	}


	@Override
	public String getID() {
		return "com.outlandr.dynauth.reverse";	
	}
}
