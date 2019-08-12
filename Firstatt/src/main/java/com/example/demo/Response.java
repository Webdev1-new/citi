package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Response {
private String msg;
private List<SimplPojo> getinfo;
private List<SimplPojo> getinfo1;
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public List<SimplPojo> getGetinfo() {
	return getinfo;
}
public void setGetinfo(List<SimplPojo> getinfo) {
	this.getinfo = getinfo;
}
public List<SimplPojo> getGetinfo1() {
	return getinfo1;
}
public void setGetinfo1(List<SimplPojo> getinfo1) {
	this.getinfo1 = getinfo1;
}
}
