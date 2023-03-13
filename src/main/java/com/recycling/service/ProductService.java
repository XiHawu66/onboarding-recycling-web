package com.recycling.service;

import com.recycling.model.Lga;
import com.recycling.model.Product;
import com.recycling.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }


}
