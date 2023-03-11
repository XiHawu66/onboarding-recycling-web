package com.recycling.controller;

import com.recycling.model.repository.LgaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LgaController {

    @RequestMapping("/Lga")
    public ModelAndView LgaInfo() {
        String lgaInfo = "Get it later from database";



        ModelAndView mav = new ModelAndView("Lga");
        mav.addObject("Lga",lgaInfo);
        return mav;

    }

}
