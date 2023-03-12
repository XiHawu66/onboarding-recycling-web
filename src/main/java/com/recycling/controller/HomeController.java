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
    public ModelAndView searchResult(String address, String postcode) {

        String lgaPid = null;
        System.out.println(System.currentTimeMillis());
        GeoSpatialService geoSpatialService = new GeoSpatialService();
        ModelAndView mav = new ModelAndView("search_result");

        String lngLat = geoSpatialService.geocoding(address + " " + postcode);
        System.out.println(System.currentTimeMillis());
        String lng = lngLat.split(",")[0];
        String lat = lngLat.split(",")[1];

        try {
            lgaPid = geoSpatialService.geoShapeQuery(Double.parseDouble(lng),Double.parseDouble(lat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mav.addObject("lgaPid",lgaPid);

        return mav;
    }

}
