package com.zhanghe.controller;

import com.zhanghe.fast.starter.util.PageUtil;
import com.zhanghe.fast.starter.util.ReturnValue;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhanghe.fast.starter.vo.PageVO;
import com.zhanghe.model.Account;
import com.zhanghe.service.AccountService;
import com.zhanghe.vo.SearchAccountVo;

/**
 * AccountController
 *
 * @author Clevo
 * @date 2018/2/27 0:44
 */
@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	@ApiOperation(value="分页查询账号", notes="分页查询账号")
	@PostMapping(value = "/list_account_bypage")
	@ResponseBody
	/**
	 * @param searchvo
	 * @param pagevo
	 * @return
	 * @author Clevo
	 * @date 2018/2/27 0:44
	*/
	public String listAccountByPage(SearchAccountVo searchvo,PageVO<Account> pagevo){
		PageUtil<Account> page =  accountService.getAccountByPage(searchvo, pagevo);
		ReturnValue r = new ReturnValue<Account>(1,"");
		r.setPage(page);
		return r.toJson();
	}
	@ApiOperation(value="添加账号", notes="添加账号")
	@PostMapping(value = "/add_account")
	@ResponseBody
	/**
	 * @param   
	 * @return   
	 * @author Clevo  
	 * @date 2018/2/27 0:45  
	*/  
	public String addAccount(){
		return "啥";
	}

	
}
