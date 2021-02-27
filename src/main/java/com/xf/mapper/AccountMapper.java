package com.xf.mapper;

import com.xf.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper {
    public Account Logincheck(String username);

}
