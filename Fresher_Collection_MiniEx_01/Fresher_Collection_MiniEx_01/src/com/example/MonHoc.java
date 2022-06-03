package com.example;

import java.util.Objects;

public class MonHoc implements Comparable<MonHoc>{
    private String ten;
    private int tcLT;
    private int tcTH;

    public MonHoc(String ten, int tcLT, int tcTH) {
        this.ten = ten;
        this.tcLT = tcLT;
        this.tcTH = tcTH;
    }
    public String getTen() {
        return ten;
    }

    public int getTcLT() {
        return tcLT;
    }

    public int getTcTH() {
        return tcTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHoc monHoc = (MonHoc) o;
        return tcLT == monHoc.tcLT && tcTH == monHoc.tcTH && Objects.equals(ten, monHoc.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ten, tcLT, tcTH);
    }

    @Override
    public int compareTo(MonHoc that) {
        if(this.ten.compareTo(that.getTen())>0)
            return 1;
        else if (this.ten.compareTo(that.getTen())<0) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ten='" + ten + '\'' +
                ", tcLT=" + tcLT +
                ", tcTH=" + tcTH +
                '}';
    }
}
