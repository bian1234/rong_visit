package com.byk.visit.system.controller;


import com.byk.visit.boke.entity.DisplayWorks;
import com.byk.visit.boke.entity.Visiter;
import com.byk.visit.boke.service.DisplayWorksService;
import com.byk.visit.boke.service.VisiterService;
import com.byk.visit.commen.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 10:14
 * @Todo:   页面跳转
 */
@Controller
public class HomeContrller {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private IPUtil 什么;

    @Autowired
    private VisiterService visiterService;


    @Autowired
    private DisplayWorksService displayWorksService;


    @RequestMapping({"/","","index"})
    public String toIndex(HttpServletRequest request,Model model){

        List<DisplayWorks> displayWorks = displayWorksService.list(null);

        for (DisplayWorks works:displayWorks) {
            works.setPageName(works.getPageAddress()+"/"+works.getPageName());
        }
        if (displayWorks.isEmpty()){
            model.addAttribute("displayWorks",null);
        }else {
           model.addAttribute("displayWorks",displayWorks);
        }
         Visiter visiter = new Visiter();
        String ip = IPUtil.getIpAddr(request);
        logger.info(ip+"访问了网页");
        visiter.setCreateTime(new Date());
        visiter.setVisiterIp(ip);
        visiterService.insertSelective(visiter);
        return "index";
    }
}
