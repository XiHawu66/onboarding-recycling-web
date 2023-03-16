package com.recycling.controller;

import com.recycling.model.Lga;
import com.recycling.service.GeoSpatialService;
import com.recycling.service.LgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Objects;

@Controller
public class LgaController {

    @Autowired
    private LgaService lgaService;

    @RequestMapping("/lga")
    public ModelAndView LgaInfo(String address, String lgaPid) {

        if (address.equals("") && lgaPid == null) {
            ModelAndView mav = new ModelAndView("fault_result");
            mav.addObject("err","You cannot leave the search box blank");

            return mav;
        }

        if (lgaPid == null) {

            GeoSpatialService geoSpatialService = new GeoSpatialService();

            String lngLat;
            try {
                lngLat = geoSpatialService.geocoding(address);
            } catch (Exception e) {
                ModelAndView mav = new ModelAndView("fault_result");
                mav.addObject("err","Sorry, your input is not a valid address");
                return mav;
            }
            String lng = lngLat.split(",")[0];
            String lat = lngLat.split(",")[1];

            try {
                lgaPid = geoSpatialService.geoShapeQuery(Double.parseDouble(lng),Double.parseDouble(lat));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (Objects.equals(lgaPid, "-1") || lgaPid == null) {
                ModelAndView mav = new ModelAndView("fault_result");
                mav.addObject("err","Sorry, your search area is not located in Victoria");
                return mav;
            }

        }

        Lga lga = lgaService.findById(lgaPid);

        ModelAndView mav = new ModelAndView("lga");
        mav.addObject("lga",lga);
        return mav;


    }

}
