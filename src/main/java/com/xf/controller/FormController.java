package com.xf.controller;

import com.xf.mapper.AccountMapper;
import com.xf.mapper.ShareMapper;
import com.xf.pojo.Account;
import com.xf.pojo.Form;
import com.xf.service.ShareServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FormController {
    @Autowired
    ShareServiceImpl shareService;

    @RequestMapping("/postshare")
    @ResponseBody
    public String PostShared(@RequestParam("origin")String origin,
                             @RequestParam("destin")String destin,
                             @RequestParam("datetime")String datetime,
                             Model model){
        System.out.println(origin+' '+destin+' '+datetime);
        Account cur_account= (Account) SecurityUtils.getSubject().getPrincipal();
        System.out.println(cur_account);
        shareService.AddShareForm(cur_account.getUsername(),origin,destin,datetime);
        return "success";
    }

    @RequestMapping("/acceptform")
    @ResponseBody
    public String AcceptForm(@RequestParam("fid")String fid){
        int ifid = Integer.parseInt(fid);
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();

        shareService.AcceptForm(account.getUsername(),ifid);
        return "success";
    }

    @RequestMapping("/deleteform")
    @ResponseBody
    public String DeleteForm(@RequestParam("fid")String fid){
        int ifid = Integer.parseInt(fid);
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();

        shareService.DeleteForm(ifid);
        return "success";
    }

    @RequestMapping("/finishform")
    @ResponseBody
    public String FinishForm(@RequestParam("fid")String fid){
        int ifid = Integer.parseInt(fid);
        //Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        shareService.FinishForm(ifid);
        return "success";
    }

    @RequestMapping("/userform")//订单页面数据接口
    @ResponseBody
    public List<Form> UserForm()
    {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        System.out.println(account.getUsername());
        List<Form> forms = shareService.FindUserForm(account.getUsername());
        for (Form f : forms)
            System.out.println(f);

        return forms;
    }
}
