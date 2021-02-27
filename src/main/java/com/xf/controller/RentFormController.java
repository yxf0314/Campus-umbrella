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


}
