package com.recycling.model;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lga")
public class Lga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lga_pid")
    private String lga_pid;

    @Column(name = "lga_name")
    private String lga_name;

    @Column(name = "recycle_bin")
    private String recycle_bin;

    @Column(name = "rubbish_bin")
    private String rubbish_bin;

    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinTable(name = "lga_product",
            joinColumns = {@JoinColumn(name = "lga_pid", referencedColumnName = "lga_pid")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    @WhereJoinTable(clause = "is_accepted = 1")
    private Set<Product> recyclingProducts = new HashSet<>();

    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinTable(name = "lga_product",
            joinColumns = {@JoinColumn(name = "lga_pid", referencedColumnName = "lga_pid")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    @WhereJoinTable(clause = "is_accepted = 0")
    private Set<Product> nonRecyclingProducts = new HashSet<>();

    public String getLga_pid() {
        return lga_pid;
    }

    public void setLga_pid(String lga_pid) {
        this.lga_pid = lga_pid;
    }

    public String getLga_name() {
        return lga_name;
    }

    public void setLga_name(String lga_name) {
        this.lga_name = lga_name;
    }

    public String getRecycle_bin() {
        return recycle_bin;
    }

    public void setRecycle_bin(String recycle_bin) {
        this.recycle_bin = recycle_bin;
    }

    public String getRubbish_bin() {
        return rubbish_bin;
    }

    public void setRubbish_bin(String rubbish_bin) {
        this.rubbish_bin = rubbish_bin;
    }

    public Set<Product> getRecyclingProducts() {
        return recyclingProducts;
    }

    public void setRecyclingProducts(Set<Product> recyclingProducts) {
        this.recyclingProducts = recyclingProducts;
    }

    public Set<Product> getNonRecyclingProducts() {
        return nonRecyclingProducts;
    }

    public void setNonRecyclingProducts(Set<Product> nonRecyclingProducts) {
        this.nonRecyclingProducts = nonRecyclingProducts;
    }

    @Override
    public String toString() {
        return "Lga{" +
                "lga_pid='" + lga_pid + '\'' +
                ", lga_name='" + lga_name + '\'' +
                ", recycle_bin='" + recycle_bin + '\'' +
                ", rubbish_bin='" + rubbish_bin + '\'' +
                '}';
    }
}
