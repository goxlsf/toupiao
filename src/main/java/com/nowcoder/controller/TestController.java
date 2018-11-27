package com.nowcoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("retire")
public class TestController {
    @RequestMapping(value = "add/dead")
    public ModelAndView addDead(){
        ModelAndView mv = new ModelAndView("addModel");
        return mv;
    }
}
