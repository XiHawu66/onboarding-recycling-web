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

        List<ProductPoint> productInstructions = productPointService.findProductInstructionByProductId(productId);
        List<ProductPoint> productNotes = productPointService.findProductNoteByProductId(productId);

        ModelAndView mav = new ModelAndView("product_point");
        mav.addObject("productInstructions",productInstructions);
        mav.addObject("productNotes",productNotes);
        mav.addObject("product",product);

        return mav;
    }
}
