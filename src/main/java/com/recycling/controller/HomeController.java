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

    @RequestMapping( "/search_result")
    public ModelAndView searchResult(String lng, String lat) {

        // test version only

        GeoSpatialService geoSpatialService = new GeoSpatialService();
        String result = "Area Not Found";

        try {
            boolean within = geoSpatialService.geoShapeQuery(Double.parseDouble(lng),Double.parseDouble(lat));
            if (within) {
                result = "Yes, it is in this area";
            }
            else {
                result = "No, it is not in this area";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelAndView mav = new ModelAndView("search_result");
        mav.addObject("result",result);


        return mav;
    }

}
