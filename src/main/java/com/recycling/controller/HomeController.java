package com.recycling.controller;

import com.recycling.service.GeoSpatialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/search_result")
    public ModelAndView searchResult(String lng, String lat) {

        String lgaPid = null;
        GeoSpatialService geoSpatialService = new GeoSpatialService();
        ModelAndView mav = new ModelAndView("search_result");

        try {
            lgaPid = geoSpatialService.geoShapeQuery(Double.parseDouble(lng),Double.parseDouble(lat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mav.addObject("lgaPid",lgaPid);


        return mav;
    }

}
