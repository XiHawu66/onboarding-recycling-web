package com.recycling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlasticController {

    @RequestMapping("/Plastic")
    public ModelAndView PlasticInfo() {
        String PlasticInfo = "Get it later from database";


        ModelAndView mav = new ModelAndView("Plastic");
        mav.addObject("Plastic", PlasticInfo);
        return mav;

    }
}