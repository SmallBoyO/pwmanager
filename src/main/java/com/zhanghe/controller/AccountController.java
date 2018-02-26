package com.zhanghe.controller;

import org.springframework.web.bind.annotation.RestController;

import com.zhanghe.fast.starter.vo.PageVO;
import com.zhanghe.model.Account;
import com.zhanghe.service.AccountService;
import com.zhanghe.vo.SearchAccountVo;


@RestController
public class AccountController {

	private AccountService accountService;
	
	public String listAccountByPage(SearchAccountVo searchvo,PageVO<Account> pagevo){
		accountService.getAccountByPage(searchvo, pagevo);
	}
	
	
}
