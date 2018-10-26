package com.byk.visit.boke.service;


import com.byk.visit.boke.entity.BokeMessage;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 14:43
 * @Todo:
 */

public interface MessageService {

    int deleteByPrimaryKey(String id);

    int insert(BokeMessage record);

    int insertSelective(BokeMessage record);

    BokeMessage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BokeMessage record);

    int updateByPrimaryKey(BokeMessage record);
}


