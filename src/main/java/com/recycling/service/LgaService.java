package com.recycling.service;

import com.recycling.model.Lga;
import com.recycling.model.repository.LgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LgaService {

    @Autowired
    private LgaRepository lgaRepository;

    public Lga findById(String id) {
        return lgaRepository.findById(id).get();
    }

}
