package com.byk.visit.boke.service;

import com.byk.visit.boke.entity.DisplayWorks;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DisplayWorksService {
    int deleteByPrimaryKey(String id);

    int insert(DisplayWorks record);

    int insertSelective(DisplayWorks record);

    DisplayWorks selectByPrimaryKey(String id);


    /**
     *    展示作品列表
     */
    List<DisplayWorks> list(Map<String, Object> map);

    int updateByPrimaryKeySelective(DisplayWorks record);

    int updateByPrimaryKey(DisplayWorks record);
}