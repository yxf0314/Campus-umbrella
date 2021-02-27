package com.xf.service;

import com.xf.pojo.RentForm;
import com.xf.pojo.Store;

import java.util.List;

public interface RentService {
    public int rent_out(int umb_id);
    public RentForm FindUserRentForm(String username);
    public List<Store> AllStore();
}
