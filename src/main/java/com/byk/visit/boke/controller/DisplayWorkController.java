package com.byk.visit.boke.controller;

import com.byk.visit.boke.entity.DisplayWorks;
import com.byk.visit.boke.service.DisplayWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/6/29 13:02
 * @Todo:
 */
@RestController
@RequestMapping("/displayWork")
public class DisplayWorkController extends BaseController{


    @Autowired
    private DisplayWorksService displayWorksService;



    @GetMapping("/list")
    public List<DisplayWorks> list(Model model){
        List<DisplayWorks> displayWorks = displayWorksService.list(null);
        if (displayWorks.isEmpty()){
            return  null;
        }else {
            for (DisplayWorks works:displayWorks) {
                works.setPageName(works.getPageAddress()+works.getPageName());
            }
            return  displayWorks;
        }
    }
}
