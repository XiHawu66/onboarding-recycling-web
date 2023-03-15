package com.recycling.service;

import com.recycling.model.ProductPoint;
import com.recycling.model.repository.ProductPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPointService {
    @Autowired
    private ProductPointRepository productPointRepository;

    public ProductPoint findById(Integer id) {
        return productPointRepository.findById(id).get();
    }

    public List<ProductPoint> findProductInstructionByProductId(int productId) {
        return productPointRepository.findProductInstructionByProductId(productId);
    }

    public List<ProductPoint> findProductNoteByProductId(int productId) {
        return productPointRepository.findProductNoteByProductId(productId);
    }


}
