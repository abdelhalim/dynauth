package com.outlandr.dynauth.user;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdentityType;


import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class Info {
	
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private String id;
	
	@Persistent
	private String question;
	
	@Persistent
	private String answer;
	
	@Persistent
	private UserInfos user;

	public Info(String id, String question, String answer, UserInfos userInfos) {
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.user = userInfos;
	}


	public Key getKey() {
		return key;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public UserInfos getUser() {
		return user;
	}

	public void setUser(UserInfos user) {
		this.user = user;
	}	

}
