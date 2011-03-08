package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.user.Info;

public class Reverse extends TextChallengeProvider {

	private Info info;
	
	public Reverse() {
		ID = "com.outlandr.dynauth.reverse";	
	}
	
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
		
		for (int i=0; i<length; i++) {
			if (response.charAt(i) != info.getAnswer().charAt(length - i -1)) {
				return false;
			}
		}
		return true;
	}

}
