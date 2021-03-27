package com.xf.controller;

import com.xf.mapper.BoardMapper;
import com.xf.pojo.Account;
import com.xf.pojo.Board;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @Autowired
    BoardMapper boardMapper;

    @RequestMapping("postmsg")
    @ResponseBody
    public String postmsg(@RequestParam("ta")String text)
    {

        if (text!=null)
        {
            Account account = (Account) SecurityUtils.getSubject().getPrincipal();
            boardMapper.AddMsg(account.getUsername(), text);
            return "success";
        }
        else return "fail";

    }
}
