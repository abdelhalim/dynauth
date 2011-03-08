package com.outlandr.dynauth;

/*
 * Information Provider, stores a question for the user
 */
public class InfosProvider {
	
	private String id;
	
	private String question;

	public InfosProvider(String id, String question) {
		this.id = id;
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public String getId() {
		return id;
	}

}
