package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimplPojo {
	
	private String id1;
	@Id
	private String id2;
	private String id3;
	private String id4;
	private String id5;
	private String id6;
	private String id7;
	public String getId7() {
		return id7;
	}
	public void setId7(String id7) {
		this.id7 = id7;
	}
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public String getId2() {
		return id2;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getId3() {
		return id3;
	}
	public void setId3(String id3) {
		this.id3 = id3;
	}
	public String getId4() {
		return id4;
	}
	public void setId4(String id4) {
		this.id4 = id4;
	}
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
	

}
