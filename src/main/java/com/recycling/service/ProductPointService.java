package com.recycling.service;

import com.recycling.model.Product_Point;
import com.recycling.model.repository.ProductPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPointService {
    @Autowired
    private ProductPointRepository productPointRepository;

    public Product_Point findById(Integer id) {
        return productPointRepository.findById(id).get();
    }


}
