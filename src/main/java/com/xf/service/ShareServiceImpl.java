package com.xf.service;

import com.xf.mapper.ShareMapper;
import com.xf.pojo.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareMapper sharemapper;

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

}
