package com.zhanghe.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhanghe.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserserviceTest {

	@Autowired
	private UserService UserService;
	
	@Test
	public void TestgetUserByUserName(){
		System.out.println(UserService.getUserByUserName("zhang"));
	}
	
}
