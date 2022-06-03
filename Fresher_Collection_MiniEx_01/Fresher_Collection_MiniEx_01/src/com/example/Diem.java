package com.example;

import java.io.Serializable;
import java.util.Set;

public class Diem implements Comparable<Diem>, Serializable{
    private MonHoc mon;
    private int diem;

    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    public MonHoc getMon() {
        return mon;
    }

    public int getDiem() {
        return diem;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public boolean equals(Object that) {
        // Hai diem duoc goi la bang nhau neu cua cung mot mon
        if (that instanceof Diem) {
            return this.mon.equals(((Diem) that).mon);
        }
        return false;
    }


    @Override
    public int compareTo(Diem o) {
        // TODO Auto-generated method stub
        if(this.diem > o.diem){
            return 1;
        } else if (this.diem < o.diem) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public Diem clone() {
        return null;
    }

}
