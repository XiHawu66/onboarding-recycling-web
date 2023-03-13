package com.recycling.controller;

import com.recycling.model.Product;
import com.recycling.model.ProductPoint;
import com.recycling.service.ProductPointService;
import com.recycling.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductPointController {


    @Autowired
    private ProductPointService productPointService;

    @Autowired
    private ProductService productService;


    @RequestMapping("/productpoint")
    public ModelAndView ProductPointInfo(String pid){

        Integer productId = Integer.parseInt(pid);
        Product product = productService.findById(productId);

        List<ProductPoint> productInstructions = productPointService.findAllByProductId(productId);
        ProductPoint productInstruction = productInstructions.get(0);
//        List<ProductPoint> productNotes = productPointService.findAllByProductId(productId);

        ModelAndView mav = new ModelAndView("product_point");
        mav.addObject("productInstruction",productInstruction);
//        mav.addObject("productNotes",productNotes);
        mav.addObject("product",product);

        return mav;
    }
}
