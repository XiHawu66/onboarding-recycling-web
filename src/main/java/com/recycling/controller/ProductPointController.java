package com.recycling.controller;

import com.recycling.model.Lga;
import com.recycling.model.Product;
import com.recycling.model.Product_Point;
import com.recycling.service.LgaService;
import com.recycling.service.ProductPointService;
import com.recycling.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class ProductPointController {


    @Autowired
    private ProductPointService productPointService;


    @RequestMapping("/productpoint")
    public ModelAndView ProductPointInfor(int product_id){

        Product_Point product_point = productPointService.findById(product_id);

        ModelAndView mav = new ModelAndView("product_point");
        mav.addObject("product_point",product_point);
        return mav;
    }
}
