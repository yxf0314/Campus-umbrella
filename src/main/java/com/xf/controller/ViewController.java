package com.xf.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.xf.pojo.Account;
import com.xf.pojo.Form;
import com.xf.pojo.RentForm;
import com.xf.pojo.Store;
import com.xf.service.RentServiceImpl;
import com.xf.service.ShareServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    ShareServiceImpl ShareService;
    @Autowired
    RentServiceImpl RentService;

    @RequestMapping({"/","/admin"})
    public String admin(Model model)
    {
        Account a = (Account) SecurityUtils.getSubject().getPrincipal();
        if(a!=null)
            model.addAttribute("cur_account",a);
        return "admin";
    }

    @RequestMapping("/share")//接单大厅
    public String pinsan(Model model)
    {
        //查询所有订单
        List<Form> forms = ShareService.Findall();
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("cur_account",account);
        model.addAttribute("forms",forms);
        return "pinsan/addresslist";
    }

    @RequestMapping("/topostshare")//发布订单
    public String topostshare(Model model)
    {

        return "pinsan/postshare";
    }

    @RequestMapping("/tomyform")//我的订单
    public String toMyForm(Model model)
    {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        List<Form> forms = ShareService.FindUserForm(account.getUsername());

        model.addAttribute("forms",forms);
        return "pinsan/myform";
    }


    @RequestMapping("/rent_umbrella")
    public String rent_umbrella(Model model)
    {
        List<Store> stores = RentService.AllStore();
        model.addAttribute("stores",stores);
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        //查找当前账号下是否有未归还的伞
        RentForm rentForm = RentService.FindUserRentForm(account.getUsername());
        //无未归还伞的情况则告知前端可以租用
        boolean rentable = true;
        if(rentForm.getReturntime()==null||rentForm.getReturn_loc()==null)
        {
            rentable=false;
            model.addAttribute("rentForm",rentForm);
        }

            model.addAttribute("rentable",rentable);


        return "rent_umbrella";
    }

}
