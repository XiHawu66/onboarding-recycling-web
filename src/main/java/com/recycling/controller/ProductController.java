package com.recycling.controller;

import com.recycling.model.Product;
import com.recycling.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public ModelAndView ProductInfo() {

        Product product = productService.findById(1);

        ModelAndView mav = new ModelAndView("product");
        mav.addObject("product",product);
        return mav;
    }
}