package com.byk.visit.boke.mapper;

import com.byk.visit.boke.entity.DisplayWorks;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DisplayWorksMapper {


    int deleteByPrimaryKey(String id);

    int insert(DisplayWorks record);

    int insertSelective(DisplayWorks record);

    DisplayWorks selectByPrimaryKey(String id);

    List<DisplayWorks> list(Map<String, Object> map);

    int updateByPrimaryKeySelective(DisplayWorks record);

    int updateByPrimaryKey(DisplayWorks record);
}