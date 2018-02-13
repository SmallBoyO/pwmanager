package com.zhanghe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhanghe.fast.starter.util.PageUtil;
import com.zhanghe.fast.starter.vo.PageVO;
import com.zhanghe.mapper.AccountMapper;
import com.zhanghe.model.Account;
import com.zhanghe.service.AccountService;
import com.zhanghe.vo.SearchAccountVo;

@Service
@Transactional(rollbackFor=Exception.class)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	public int insertAccount( Account account ) {
		return accountMapper.insert(account);
	}

	public PageUtil<Account> getAccountByPage( SearchAccountVo vo,PageVO<Account> pagevo ) {
		EntityWrapper<Account> wrapper = new EntityWrapper<Account>();
		if(vo.getName()!=null){
			wrapper.eq(Account.NAME, vo.getName());
		}
		if(vo.getLoginaccount()!=null&&!"".equals(vo.getLoginaccount())){
			wrapper.like(Account.LOGINACCOUNT, vo.getLoginaccount());
		}
		if(vo.getEmail()!=null&&!"".equals(vo.getEmail())){
			wrapper.like(Account.EMAIL, vo.getEmail());
		}
		if(vo.getPhone()!=null&&!"".equals(vo.getPhone())){
			wrapper.like(Account.PHONE, vo.getPhone());
		}
		if(vo.getDomain()!=null&&!"".equals(vo.getDomain())){
			wrapper.like(Account.DOMAIN, vo.getDomain());
		}
		if(vo.getName()!=null&&!"".equals(vo.getName())){
			wrapper.like(Account.NAME, vo.getName());
		}
		
		PageUtil<Account> page = pagevo.toPageUtil();
		Page<Account> querypage = new Page<Account>(page.getCorrentPage().intValue(), page.getPageSize().intValue());
		page.setResult(accountMapper.selectPage(querypage, wrapper));
		page.setTotal((long)querypage.getTotal());
		return page;
	}

	public Integer updateAccount( Account account ) {
		return accountMapper.updateById(account);
	}

}
