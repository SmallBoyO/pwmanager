package com.zhanghe.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
@TableName("account")
public class Account {
	@TableId(type = IdType.AUTO)
	private Long id;
	//登录账号
	public String loginaccount;
	//密码
	public String password;
	//邮箱
	public String email;
	//电话
	public String phone;
	//网站域名
	public String domain;
	//名称
	public String name;
	
	
	public static final String LOGINACCOUNT="loginaccount";
	public static final String PASSWORD="password";
	public static final String EMAIL="email";
	public static final String PHONE="phone";
	public static final String DOMAIN="domain";
	public static final String NAME="name";
	
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
	public String getLoginaccount() {
		return loginaccount;
	}
	public void setLoginaccount( String loginaccount ) {
		this.loginaccount = loginaccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword( String password ) {
		this.password = password;
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
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
