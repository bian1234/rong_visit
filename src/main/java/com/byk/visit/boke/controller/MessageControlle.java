package com.byk.visit.boke.controller;


import com.byk.visit.boke.entity.BokeMessage;
import com.byk.visit.boke.service.MessageService;
import com.byk.visit.commen.util.IPUtil;
import com.byk.visit.commen.util.MailUtil;
import com.byk.visit.commen.util.SMSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 14:47
 * @Todo:
 */
@RestController
@RequestMapping("/message")
public class MessageControlle extends BaseController{


    @Autowired
    private MessageService messageService;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    protected SMSUtil smsUtil;



    @PostMapping("/insert")
    public Map insert(HttpServletRequest request, BokeMessage bokeMessage) throws Exception{
        String ip = IPUtil.getIpAddr(request);
        bokeMessage.setUserIp(ip);
        //先发送邮件再操作数据库
        try {
            mailUtil.sendEmailToVistor(bokeMessage);
        }catch (Exception e){
            logger.info("邮箱地址错误");
            bokeMessage.setReply(1);
        }
        //先发送短信再操作数据库
        try {
            smsUtil.sendSMS(bokeMessage.getPhonenumber());
        }catch (Exception e){
            logger.info("欢迎短信发送失败");
            bokeMessage.setReply(1);
        }
        if (messageService.insertSelective(bokeMessage) > 0) {
            mailUtil.sendEmailToMe(bokeMessage,ip);
            logger.info("Ip为"+ip+"的用户留言了");
            return insertSuccseeResponse();

        } else {
           return insertFailedResponse();
        }
    }
}
