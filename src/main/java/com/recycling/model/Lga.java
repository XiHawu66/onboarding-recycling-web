package com.recycling.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Lga")
public class Lga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "la_pid")
    private String lga_pid;
    @Column(name = "lga_name")
    private String lga_name;
    @Column(name = "recycle_bin")
    private String recycle_bin;
    @Column(name = "rubbish_bin")
    private String rubbish_bin;

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
