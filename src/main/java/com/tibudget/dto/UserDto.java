package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class UserDto implements Serializable {
	
	private static final long serialVersionUID = -3197840914209817145L;

	private String id;
	
	private String email;
	
	private Date lastConnection;
	
	private Date lastConnectionCurrent;
	
	private String nickname;
	
	private String locale;
	
	private transient Locale userLocale;

	public UserDto(String id, String userEmail, Date lastConnection, Date lastConnectionCurrent, String nickname, String locale) {
		super();
		this.id = id;
		this.email = userEmail;
		this.lastConnection = lastConnection;
		this.lastConnectionCurrent = lastConnectionCurrent;
		this.nickname = nickname;
		this.locale = locale != null ? locale : Locale.FRANCE.toString();
		this.userLocale = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLocaleCode() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public Locale getLocale() {
		if (userLocale == null && locale != null) {
			String[] langCountry = locale.split("_");
			userLocale = new Locale(langCountry[0], langCountry[1]);
		}
		return userLocale;
	}

	public Date getLastConnection() {
		return lastConnection;
	}

	public Date getLastConnectionCurrent() {
		return lastConnectionCurrent;
	}
}
