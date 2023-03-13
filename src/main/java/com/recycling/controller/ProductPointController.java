package com.recycling.controller;

import com.recycling.service.ProductPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductPointController {

    @Autowired
    private ProductPointService productPointService;

    @RequestMapping("/productpoint")
    public ModelAndView ProductPointInfor(int product_id){

        ModelAndView mav = new ModelAndView("productpoint");


        return mav;
    }
}
