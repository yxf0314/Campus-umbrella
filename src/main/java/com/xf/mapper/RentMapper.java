package com.xf.mapper;

import com.xf.pojo.RentForm;
import com.xf.pojo.Store;
import com.xf.pojo.Umbrella;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RentMapper {
    public int rent(int uid);//更改雨伞租借状态
    public int AddRentForm(int umb_id, String username, String location);//新建租借订单
    public Umbrella FindUmbrella(int id);
    public RentForm FindUserRentForm(String username);

    public List<Store> AllStore();


}
