package com.outlandr.dynauth.challenge.providers;

import java.util.Random;

import com.outlandr.dynauth.user.Info;

public class Substring extends TextChallengeProvider {

	private Info info;
	private int from;
	private int to;
	private Random rn = new Random();
	

	@Override
	public String getChallenge(Info info) {
		this.info = info;
		
		if (info.getAnswer().length() < 2) {
			from = to = 0;
		} else {
		
			from = Math.abs(rn.nextInt()) % info.getAnswer().length();
			to = Math.abs(rn.nextInt()) % info.getAnswer().length();
			
			
			while (from == to) {
				to = Math.abs(rn.nextInt()) % info.getAnswer().length();
			}
			
			if (from > to) {
				from = from ^ to;
				to = to ^ from;
				from = from ^ to;
			}
		}

		
		return info.getQuestion() 
			+ "<br>" 
		    + "Enter substring from " + from + " to " + to;
		
	}

	@Override
	public boolean validateResponse(String response) {
		log.info("Substring validator");
		if (response.length() != (to - from)) {
			return false;
		}
		
		String substring = info.getAnswer().substring(from, to);
		if (!substring.equals(response)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String getID() {
		return  "com.outlandr.dynauth.substring";
	}

}
