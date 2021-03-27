package com.xf.controller;

import com.xf.service.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RentFormController {
    @Autowired
    RentServiceImpl RentService;

    @RequestMapping("/addrentform")
    @ResponseBody
    public String addrentform(Model model, @RequestParam("uid")int uid) throws Exception
    {
        int result = RentService.rent_out(uid);
        if(result==1)
            return "success";
        else
            return "fail";
    }

    @RequestMapping("/return_umb")//归还雨伞
    @ResponseBody
    public String return_umb(Model model, @RequestParam("fid")int fid,
                             @RequestParam("loc")String loc)
    {
        int result = RentService.return_umb(fid,loc);
        if(result==1)
            return "success";
        else
            return "fail";
    }

    @RequestMapping("/add_umb")//归还雨伞
    @ResponseBody
    public String add_umb(Model model, @RequestParam("adduid")String uid,
                             @RequestParam("addstore")String loc)
    {
        if (uid!=null&&loc!=null)
        {
            int iuid=Integer.parseInt(uid);
            int result = RentService.add_umb(iuid,loc);
            if(result==1)
                return "success";
        }
            return "fail";
    }
}
