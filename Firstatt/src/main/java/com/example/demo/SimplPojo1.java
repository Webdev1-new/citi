package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimplPojo1 {
	@Id
	private String id5;
	public String getId5() {
		return id5;
	}
	public void setId5(String id5) {
		this.id5 = id5;
	}
	public String getId6() {
		return id6;
	}
	public void setId6(String id6) {
		this.id6 = id6;
	}
	public String getId7() {
		return id7;
	}
	public void setId7(String id7) {
		this.id7 = id7;
	}
	public String getId8() {
		return id8;
	}
	public void setId8(String id8) {
		this.id8 = id8;
	}
	private String id6;
	private String id7;
	private String id8;
}
