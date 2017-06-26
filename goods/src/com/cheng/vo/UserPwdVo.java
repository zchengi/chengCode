package com.cheng.vo;

import com.cheng.domain.User;

public class UserPwdVo extends User {
	private String newpass;

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	@Override
	public String toString() {
		return super.toString()+"  UserPwdVo [newpass=" + newpass + "]";
	}
}
