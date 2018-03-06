package com.zhanghe.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhanghe.model.Account;
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
