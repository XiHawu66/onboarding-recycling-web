package com.recycling.controller;

import com.recycling.model.Lga;
import com.recycling.service.GeoSpatialService;
import com.recycling.service.LgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class LgaController {

    @Autowired
    private LgaService lgaService;

    @RequestMapping("/lga")
    public ModelAndView LgaInfo(String address, String postcode) {

        String lgaPid = null;
        GeoSpatialService geoSpatialService = new GeoSpatialService();

        String lngLat = geoSpatialService.geocoding(address + " " + postcode);
        String lng = lngLat.split(",")[0];
        String lat = lngLat.split(",")[1];

        try {
            lgaPid = geoSpatialService.geoShapeQuery(Double.parseDouble(lng),Double.parseDouble(lat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Lga lga = lgaService.findById(lgaPid);

        ModelAndView mav = new ModelAndView("lga");
        mav.addObject("lga",lga);
        return mav;

    }



}
