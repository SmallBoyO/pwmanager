package com.zhanghe.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhanghe.fast.starter.vo.PageVO;
import com.zhanghe.model.Account;
import com.zhanghe.service.AccountService;
import com.zhanghe.vo.SearchAccountVo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;
	
	//@Test
	public void TestinserAccount(){
		Account account = new Account();
		account.setDomain("www.baidu.com");
		account.setName("百度");
		account.setLoginaccount("smallbouy");
		account.setPassword("123456");
		account.setPhone("15378202040");
		accountService.insertAccount(account);
	}
	//@Test
	public void TestgetAccountByPage(){
		PageVO<Account> vo = new PageVO<Account>();
		vo.setCorrentPage(1L);
		vo.setPageSize(10L);
		
		SearchAccountVo searchAccountVo = new SearchAccountVo();
		searchAccountVo.setName("百");
		System.out.println(accountService.getAccountByPage(searchAccountVo,vo));
	}
	
	@Test
	public void TestUpdateAccount(){
		Account account = new Account();
		account.setId(1L);
		account.setDomain("www.baidu.com2");
		System.out.println(accountService.updateAccount(account));
	}
	
}
