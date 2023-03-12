package com.recycling.model;

import javax.persistence.*;

@Entity
@Table(name = "Bin")
public class Bin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bin")
    private String bin;
    @Column(name = "bin_image")
    private String bin_image;

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getBin_image() {
        return bin_image;
    }

    public void setBin_image(String bin_image) {
        this.bin_image = bin_image;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "bin='" + bin + '\'' +
                ", bin_image='" + bin_image + '\'' +
                '}';
    }


}
