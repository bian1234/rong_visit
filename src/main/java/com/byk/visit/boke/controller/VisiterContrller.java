package com.byk.visit.boke.controller;

import com.byk.visit.boke.service.VisiterService;
import com.byk.visit.commen.util.IPUtil;
import com.byk.visit.commen.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bianyakun
 * @Date: 2018/6/15 16:11
 * @Todo:
 */
@RestController
public class VisiterContrller {

    @Autowired
    private IPUtil ipUtil;
    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private VisiterService visiterService;

//    @Scheduled(cron="*/1 * * * * ?")     //每隔1秒打印一句话
//    public void  countIp(){
//        int sum = visiterService.countIp();
//        mailUtil.sendEmailToCount(sum);
//    }


}
