package com.xf.service;

import com.xf.mapper.RentMapper;
import com.xf.pojo.Account;
import com.xf.pojo.RentForm;
import com.xf.pojo.Store;
import com.xf.pojo.Umbrella;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RentServiceImpl implements RentService{
    @Autowired
    RentMapper rentMapper;

    @Override
    public int rent_out(int umb_id) {
        Umbrella umbrella = rentMapper.FindUmbrella(umb_id);
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        if(umbrella.getState()=="可租用")
        {
            rentMapper.rent(umb_id);//变更雨伞租借状态
            //将结果输入订单
            rentMapper.AddRentForm(umb_id,account.getUsername(),umbrella.getLocation());
            return 1;
        }
        else return 0;

    }

    @Override
    public RentForm FindUserRentForm(String username) {
        return rentMapper.FindUserRentForm(username);
    }

    @Override
    public List<Store> AllStore() {
        return rentMapper.AllStore();
    }
}
