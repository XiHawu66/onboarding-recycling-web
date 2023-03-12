package com.recycling.controller;

import com.recycling.model.Lga;
import com.recycling.model.repository.LgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LgaController {

    @Autowired
    private LgaRepository lgaRepository;

    @RequestMapping("/lga")
    public ModelAndView LgaInfo() {
        String lgaInfo = "Get it later from database";

        List<Lga> lgas = lgaRepository.SearchLga();

        ModelAndView mav = new ModelAndView("lga");
        mav.addObject("lga",lgas);
        return mav;

    }



}
