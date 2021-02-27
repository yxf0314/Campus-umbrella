package com.xf.service;

import com.xf.pojo.Form;

import java.util.List;

public interface ShareService {
    public List<Form> Findall();
    public int AddShareForm(String username,String origin,String destin,String datetime);
    public int AcceptForm(String username,int fid);
    public List<Form> FindUserForm(String username);
    public int DeleteForm(int fid);

}
