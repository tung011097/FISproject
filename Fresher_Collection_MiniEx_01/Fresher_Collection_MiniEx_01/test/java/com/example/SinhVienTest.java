package com.example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {
    private  SinhVien s = new SinhVien("DTC","1");
    public void person(){
        Set<Diem> monDH = s.getMonDaHoc();
        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("OOP",2,1);
        Diem diem = new Diem(monHoc1,8);
        Diem diem2 = new Diem(monHoc2,7);
        monDH.add(diem);
        monDH.add(diem2);

    }

    @Test
    void themDiem() {
    }

    @Test
    void tinhDiemTrungBinh() {
        person();
        System.out.println(s.tinhDiemTrungBinh());
    }

    @Test
    void bangDiem() {
        person();
        System.out.println(s.bangDiem());

    }

    @Test
    void xepLoai() {
        person();
        System.out.println(s.xepLoai());
    }
}