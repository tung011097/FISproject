package com.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void getTen() {
        MonHoc monHoc = new MonHoc("CTDL",3,1);
        assertEquals("CTDL", monHoc.getTen());
        assertNotEquals("Cấu trúc dữ liệu", monHoc.getTen());
    }
    @Test
    void getTcLT() {
    }

    @Test
    void getTcTH() {
    }
    @Test
    void testWithCollection(){
        List<MonHoc> dsMonHoc = new ArrayList<>();
        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("OOP",2,1);
        dsMonHoc.add(monHoc1);
        dsMonHoc.add(monHoc2);
        MonHoc monHoc3 = new MonHoc("CTDL",3,1);
        assertEquals(0, dsMonHoc.indexOf(monHoc3));
        assertEquals(0, dsMonHoc.indexOf(monHoc1));

        Collections.sort(dsMonHoc);
        System.out.println(dsMonHoc);
    }
    @Test
    void  testWithset(){
        Set<MonHoc> monHocSet = new HashSet<>();
        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("OOP",2,1);
        monHocSet.add(monHoc1);
        monHocSet.add(monHoc2);
        MonHoc monHoc3 = new MonHoc("CTDL",3,1);
        monHocSet.add(monHoc3);
        assertEquals(2,monHocSet.size());
    }
}