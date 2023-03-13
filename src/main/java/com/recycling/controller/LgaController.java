package com.recycling.controller;

import com.recycling.model.Lga;
import com.recycling.model.repository.LgaRepository;
import com.recycling.service.LgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LgaController {

    @Autowired
    private LgaService lgaService;

    @RequestMapping("/lga")
    public ModelAndView LgaInfo(String id) {

        Lga lga = lgaService.findById(id);

//        List<Lga> all = lgaRepository.findAll();

        ModelAndView mav = new ModelAndView("lga");
        mav.addObject("lga",lga);
        return mav;

    }



}
