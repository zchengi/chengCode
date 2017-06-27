package com.zy.pojo;

public class User {
	private int id;
	private int num;
	private String name;
	private String pass;
	private String repass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", num=" + num + ", name=" + name + ", pass="
				+ pass + ", repass=" + repass + "]";
	}

}
