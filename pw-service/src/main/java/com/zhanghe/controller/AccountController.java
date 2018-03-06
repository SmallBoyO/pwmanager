package com.zhanghe.controller;

import com.zhanghe.fast.starter.util.PageUtil;
import com.zhanghe.fast.starter.util.ReturnValue;
import com.zhanghe.vo.AddAccountVo;
import com.zhanghe.vo.UpdateAccountVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
	 * @param addvo
	 * @return   
	 * @author Clevo  
	 * @date 2018/2/27 22:45  
	*/  
	public String addAccount(AddAccountVo addvo){
		Account account = new Account();
		BeanUtils.copyProperties(addvo,account);
		accountService.insertAccount(account);
		return new ReturnValue<String>(1,"").toJson();
	}
	@ApiOperation(value="更改账号", notes="更改账号")
	@PostMapping(value = "/update_account")
	@ResponseBody
	/**
	 * @param updatevo  
	 * @return   
	 * @author Clevo  
	 * @date 2018/2/27 22:45  
	*/  
	public String updateAccount(UpdateAccountVo updatevo){
		Account account = new Account();
		BeanUtils.copyProperties(updatevo,account);
		accountService.updateAccount(account);
		return new ReturnValue<String>(1,"").toJson();
	}
	
}
