package com.recycling.controller;

import com.recycling.model.Lga;
import com.recycling.model.Product;
import com.recycling.service.LgaService;
import com.recycling.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private LgaService lgaService;

    @RequestMapping("/product")
    public ModelAndView ProductInfo(String lgaPid) {

        Lga lga = lgaService.findById(lgaPid);
        Set<Product> recyclingProducts = lga.getRecyclingProducts();
        Set<Product> nonRecyclingProducts = lga.getNonRecyclingProducts();

        ModelAndView mav = new ModelAndView("product");
        mav.addObject("recyclingProducts",recyclingProducts);
        mav.addObject("nonRecyclingProducts",nonRecyclingProducts);
        return mav;
    }
}