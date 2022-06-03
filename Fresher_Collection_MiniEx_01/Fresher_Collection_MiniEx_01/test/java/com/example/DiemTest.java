package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void testEquals() {
        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("OOP",3,1);
        Diem diem = new Diem(monHoc1, 8);
        Diem diem2 = new Diem(monHoc2, 6);
        assertEquals(diem,diem2);
    }

    @Test
    void compareTo() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testClone() {
    }
}