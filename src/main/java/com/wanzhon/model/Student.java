package com.wanzhon.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class Student {

	@NotNull
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	//@past
	@DateTimeFormat
	private Date birth;
}
