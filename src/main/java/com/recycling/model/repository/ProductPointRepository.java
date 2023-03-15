package com.recycling.model.repository;

import com.recycling.model.ProductPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductPointRepository extends JpaRepository<ProductPoint,Integer> {

    @Query(value = "SELECT DISTINCT pp FROM ProductPoint pp " +
            "WHERE (pp.productId = ?1) AND (pp.pointType = 'instruction') ")
    List<ProductPoint> findProductInstructionByProductId(int productId);

    @Query(value = "SELECT DISTINCT pp FROM ProductPoint pp " +
            "WHERE (pp.productId = ?1) AND (pp.pointType = 'note') " )
    List<ProductPoint> findProductNoteByProductId(int productId);
}
