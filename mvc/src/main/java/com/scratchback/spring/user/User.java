package com.scratchback.spring.user;

public class User {
	private String id;
	private String password;
	private String confirmPassword;

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public boolean isOk() {
		return (id != null) && id.equals("admin@naver.com")
				&& (password != null) && password.equals("1234");
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
