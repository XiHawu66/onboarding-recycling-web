package com.recycling.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lga")
public class Lga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "la_pid")
    private String lga_pid;
    @Column(name = "lga_name")
    private String lga_name;
    @Column(name = "bin")
    private String bin;

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

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    @Override
    public String toString() {
        return "Lga{" +
                "lga_pid='" + lga_pid + '\'' +
                ", lga_name='" + lga_name + '\'' +
                ", bin='" + bin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lga lga = (Lga) o;
        return Objects.equals(lga_pid, lga.lga_pid) && Objects.equals(lga_name, lga.lga_name) && Objects.equals(bin, lga.bin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lga_pid, lga_name, bin);
    }
}
