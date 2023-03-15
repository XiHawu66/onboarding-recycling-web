package com.recycling.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product_Point")
@IdClass(ProductPoint.PrimaryKey.class)
public class ProductPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer productId;
    @Id
    @Column(name = "point_type")
    private String pointType;
    @Id
    @Column(name = "sequence")
    private Integer sequence;
    @Column(name = "product_point")
    private String productPoint;

    @Data
    static class PrimaryKey implements Serializable {
        private Integer productId;
        private String pointType;
        private Integer sequence;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getProductPoint() {
        return productPoint;
    }

    public void setProductPoint(String productPoint) {
        this.productPoint = productPoint;
    }
}
