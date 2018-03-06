package com.zhanghe.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhanghe.model.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
	@Select("select * from user where UserName=#{UserName}")
    public User getUserByUserName(@Param(value = "UserName") String userName);
}
