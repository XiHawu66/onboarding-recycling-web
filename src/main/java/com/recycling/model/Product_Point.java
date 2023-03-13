package com.recycling.model;

import javax.persistence.*;

@Entity
@Table(name = "Product_Point")
public class Product_Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "point_type")
    private String point_type;
    @Column(name = "sequence")
    private int sequence;
    @Column(name = "product_point")
    private String product_point;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getPoint_type() {
        return point_type;
    }

    public void setPoint_type(String point_type) {
        this.point_type = point_type;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getProduct_point() {
        return product_point;
    }

    public void setProduct_point(String product_point) {
        this.product_point = product_point;
    }

    @Override
    public String toString() {
        return "Product_Point{" +
                "product_id=" + product_id +
                ", point_type='" + point_type + '\'' +
                ", sequence=" + sequence +
                ", product_point='" + product_point + '\'' +
                '}';
    }
}
