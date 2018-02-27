package com.zhanghe.vo;

public class UpdateAccountVo {

	public Long id;
	public String loginaccount;
	public String password;
	public String email;
	public String phone;
	public String domain;
	public String name;
	public String getLoginaccount() {
		return loginaccount;
	}
	public void setLoginaccount( String loginaccount ) {
		this.loginaccount = loginaccount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail( String email ) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone( String phone ) {
		this.phone = phone;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain( String domain ) {
		this.domain = domain;
	}
	public String getName() {
		return name;
	}
	public void setName( String name ) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId( Long id ) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
