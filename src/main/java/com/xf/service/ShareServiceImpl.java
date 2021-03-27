package com.xf.service;

import com.xf.mapper.AccountMapper;
import com.xf.mapper.ShareMapper;
import com.xf.pojo.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareMapper sharemapper;
    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Form> Findall() {
        return sharemapper.Findall();
    }

    @Override
    public int AddShareForm(String username, String origin, String destin, String datetime) {
        return sharemapper.AddShareForm(username, origin, destin, datetime);
    }

    @Override
    public int AcceptForm(String username, int fid) {
        return sharemapper.AcceptForm(username,fid);
    }

    @Override
    public List<Form> FindUserForm(String username) {
        return sharemapper.FindUserForm(username);
    }

    @Override
    public int DeleteForm(int fid) {

        return sharemapper.DeleteForm(fid);
    }

    @Override
    public int FinishForm(int ifid) {
        sharemapper.FinishForm(ifid);//将订单状态设置成已完成,state=1
        Form form = sharemapper.FindById(ifid);//找出当前订单并把接单人的积分增加
        accountMapper.ChangeCredit(form.getAccepterid(),1);//i为完成订单增加的分数,具体数值以后再策划

        return 1;
    }
}
