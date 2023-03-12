package com.recycling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @RequestMapping("/product")
    public ModelAndView PlasticInfo() {
        String ProductInfo = "Get it later from database";


        ModelAndView mav = new ModelAndView("product");
        mav.addObject("product", ProductInfo);
        return mav;

    }
}