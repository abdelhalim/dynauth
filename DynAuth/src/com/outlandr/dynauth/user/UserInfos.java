package com.outlandr.dynauth.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class UserInfos {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	private String userName;

	@Persistent
	private String hashedPassword;

	@Persistent(defaultFetchGroup = "true", mappedBy = "user")
	@Element(dependent = "true")
	private List<Info> infos = new ArrayList<Info>();

	@Persistent
	private Date date;

	MessageDigest sha1;

	public UserInfos(String userName, String password) {
		initSHA1Instance();

		this.userName = userName;

		// Get Digest of the password, and store the hashed version only
		this.hashedPassword = new String(sha1.digest(password.getBytes())); 
	}

	private void initSHA1Instance() {
		if (sha1 == null) {
			try {
				sha1 = MessageDigest.getInstance("SHA1");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Info> getInfos() {
		return infos;
	}

	public Key getKey() {
		return key;
	}

	public String getUserName() {
		return userName;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public Date getDate() {
		return date;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setHashedPassword(String password) {
		this.hashedPassword = password;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isValidPassword(String password) {
		initSHA1Instance();
		String computedHash = new String(sha1.digest((password).getBytes()));
		if (computedHash.equals(hashedPassword)) {
			return true;
		} else
			return false;
	}
}