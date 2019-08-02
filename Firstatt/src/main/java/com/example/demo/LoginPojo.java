package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginPojo {
	@Id
	private String login1;
	private String login2;
	public String getLogin1() {
		return login1;
	}
	public void setLogin1(String login1) {
		this.login1 = login1;
	}
	public String getLogin2() {
		return login2;
	}
	public void setLogin2(String login2) {
		this.login2 = login2;
	}

}
