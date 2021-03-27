package com.xf.mapper;

import com.xf.pojo.Form;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShareMapper {
    public List<Form> Findall();
    public int AddShareForm(String username,String origin,String destin,String datetime);
    public int AcceptForm(String username,int fid);
    Form FindById(int fid);
    List<Form> FindUserForm(String username);
    int DeleteForm(int fid);

    int FinishForm(int ifid);
}
