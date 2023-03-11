package com.recycling.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "product")
    private String product;
    @Column(name = "image")
    private String image;
    @Column(name = "is_accepted_default")
    private boolean is_accepted_default;
    @Column(name = "instructions")
    private String instructions;

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

    public boolean isIs_accepted_default() {
        return is_accepted_default;
    }

    public void setIs_accepted_default(boolean is_accepted_default) {
        this.is_accepted_default = is_accepted_default;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product='" + product + '\'' +
                ", image='" + image + '\'' +
                ", is_accepted_default=" + is_accepted_default +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product1 = (Product) o;
        return getProduct_id() == product1.getProduct_id() && isIs_accepted_default() == product1.isIs_accepted_default() && Objects.equals(getProduct(), product1.getProduct()) && Objects.equals(getImage(), product1.getImage()) && Objects.equals(getInstructions(), product1.getInstructions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_id(), getProduct(), getImage(), isIs_accepted_default(), getInstructions());
    }
}
