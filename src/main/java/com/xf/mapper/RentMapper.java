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
    public int ReturnUmbrella(int uid,String location);//归还雨伞

    public int AddRentForm(int umb_id, String username, String location);//新建租借订单
    int ReturnForm(int fid,String location);//归还时将订单的归还时间地点补全

    public Umbrella FindUmbrella(int id);//查询雨伞
    RentForm FindRentFormById(int fid);//查询订单
    public RentForm FindUserRentForm(String username);//查询用户的订单

    public List<Store> AllStore();//查询所有地点
    public int changecount(String location,int num);//改变某地点内伞的数量

    void addUmb(int uid, String location);//新增一把伞


}
