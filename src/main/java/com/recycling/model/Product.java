package com.recycling.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "product")
    private String product;
    @Column(name = "image")
    private String image;
    @Column(name = "image_small")
    private String image_small;
    @Column(name = "is_accepted_default")
    private int is_accepted_default;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_small() {
        return image_small;
    }

    public void setImage_small(String image_small) {
        this.image_small = image_small;
    }

    public int getIs_accepted_default() {
        return is_accepted_default;
    }

    public void setIs_accepted_default(int is_accepted_default) {
        this.is_accepted_default = is_accepted_default;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product='" + product + '\'' +
                ", image='" + image + '\'' +
                ", image_small='" + image_small + '\'' +
                ", is_accepted_default=" + is_accepted_default +
                '}';
    }
}
