package com.zhanghe.service;

import com.zhanghe.fast.starter.util.PageUtil;
import com.zhanghe.fast.starter.vo.PageVO;
import com.zhanghe.model.Account;
import com.zhanghe.vo.SearchAccountVo;

public interface AccountService {

	public int insertAccount(Account account);
	
	public PageUtil<Account> getAccountByPage(SearchAccountVo vo,PageVO<Account> pagevo);
	
	public Integer updateAccount(Account account);
}
