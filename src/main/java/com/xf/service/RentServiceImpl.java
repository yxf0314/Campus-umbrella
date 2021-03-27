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
        System.out.println(umbrella);
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        System.out.println(umbrella.getState());
        if(umbrella.getState().equals("可租用"))
        {
            rentMapper.rent(umb_id);//变更雨伞租借状态
            //将结果输入订单
            rentMapper.AddRentForm(umb_id,account.getUsername(),umbrella.getLocation());
            rentMapper.changecount(umbrella.getLocation(),-1);
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

    @Override
    public int return_umb(int fid,String location) {//根据订单编号fid查询出订单对应的伞编号uid,然后将订单的时间地点补全,雨伞设置成可租用
        if(location!=null)
        {
            rentMapper.ReturnForm(fid, location);//修改订单信息
            RentForm rentForm = rentMapper.FindRentFormById(fid);//查找修改的订单对应的雨伞
            rentMapper.changecount(location,1);
            if(rentForm!=null)
            {
                rentMapper.ReturnUmbrella(rentForm.getUmb_id(),location);//将雨伞设置成可租用
                return 1;
            }
            else return 0;
        }
        else return 0;

    }

    @Override
    public int add_umb(int uid, String location) {
        rentMapper.addUmb(uid,location);
        rentMapper.changecount(location,1);
        return 1;
    }
}
