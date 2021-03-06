package com.zhanghe.controller;

import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zhanghe.fast.starter.util.ReturnValue;
import com.zhanghe.model.User;
import com.zhanghe.service.UserService;

@RestController
public class LoginController {
	@Autowired
	public UserService userService;
	
	@ApiOperation(value="登录", notes="登录")
    @PostMapping(value = "/ajax/loginajax")
    @ResponseBody
    public String login(HttpServletRequest request,String username,String password,HttpServletResponse response) throws Exception {
    	User user=new User();
    	user.setUserName(username);
    	user.setPassword(password);
    	User databaseUser = userService.getUserByUserName(username);
    	
    	if(databaseUser==null){
    		ReturnValue<User> returnvalue=new ReturnValue<User>(-1,"账号不存在!");
        	return returnvalue.toJson();
    	}
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),new Sha256Hash(password, databaseUser.getSalt()).toHex());
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();
        //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
        //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
        //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
        currentUser.login(token);
        //验证是否登录成功  
        if (currentUser.isAuthenticated()) {
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            // 此方法不处理登录成功,由shiro进行处理.
            ReturnValue<User> returnvalue=new ReturnValue<User>();
            user = userService.getUserByUserName(username);
            returnvalue.setObj(user);
            user.setId(null);
            user.setPassword(null);
            user.setSalt(null);
            user.setStatus(null);
            Gson gson = new Gson();
            return  gson.toJson(returnvalue);
        } else {
        	ReturnValue<User> returnvalue=new ReturnValue<User>();
        	returnvalue.setRet(-1);
        	returnvalue.setMessage("账号密码不正确!");
            token.clear();
            Gson gson = new Gson();
            return  gson.toJson(returnvalue);
        }
	}
	
	/**
     * @return   
     * @author Clevo  
     * @date 2018/1/14 15:15  
    */
    @PostMapping("/ajax/checklogin")
    @ResponseBody
    public String checkLogin(){
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated()){
            return new ReturnValue<String>(1,"").toJson();
        }else{
            return new ReturnValue<String>(-100,"未登录").toJson();
        }
    }

    @PostMapping("/ajax/loginOut")
    @ResponseBody
    @RequiresAuthentication
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return new ReturnValue<String>(1,"").toJson();
    }

    public SavedRequest getSavedRequest(ServletRequest request) {  
        SavedRequest savedRequest = null;  
        Subject subject = SecurityUtils.getSubject();  
        Session session = subject.getSession(false);  
        if (session != null) {  
            savedRequest = (SavedRequest) session.getAttribute("shiroSavedRequest");  
        }  
        return savedRequest;  
    }  
	
}
