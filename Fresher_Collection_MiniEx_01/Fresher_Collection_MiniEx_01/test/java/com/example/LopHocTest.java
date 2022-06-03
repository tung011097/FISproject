package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {
    @Test
    void inDiem() {
        LopHoc classSV = new LopHoc("IT", "B");
        List<SinhVien> listsv = classSV.getDsLop();
        SinhVien sv1 = new SinhVien("DTC","B");
        System.out.println(classSV.inDiem());

    }

    @Test
    void top10() {

    }
    @Test
    void sinhVienYeu() {
    }
}