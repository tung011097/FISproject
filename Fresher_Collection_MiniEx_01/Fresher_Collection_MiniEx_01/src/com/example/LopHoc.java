package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<SinhVien> getDsLop() {
        return dsLop;
    }

    public void setDsLop(List<SinhVien> dsLop) {
        this.dsLop = dsLop;
    }

    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }

    //TODO Cau 4
    public String inDiem() {
        int i = 1;
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        StringBuilder sb = new StringBuilder("Danh Sach Diem Lop : " + this.ten + "\n ")
                .append("Giao Vien Chu Nhiem : " + this.giaoVien)
                .append("STT" + "  " + "MSSV" + " " + " Ten" + "  " + " Diem TB" + " " + "Xep Loai"+ "\n ");
        for ( SinhVien danhsachlop: dsLop) {
            sb.append(i + " " + danhsachlop.getMssv() + " " + danhsachlop.getTen() + " " + danhsachlop.tinhDiemTrungBinh() + " " + danhsachlop.xepLoai()+ "\n ");
        }
        //...
        return sb.toString();
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        return top10().stream()
                .sorted(Comparator.comparing(SinhVien ::tinhDiemTrungBinh))
                .limit(10)
                .collect(Collectors.toList());
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        //Tra ve danh sach vien vien xep loai YEU
        List<SinhVien> list = this.dsLop.stream().filter(t -> t.xepLoai().equals("YEU")).collect(Collectors.toList());
        //...

        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LopHoc lopHoc = (LopHoc) o;

        if (ten != null ? !ten.equals(lopHoc.ten) : lopHoc.ten != null) return false;
        if (giaoVien != null ? !giaoVien.equals(lopHoc.giaoVien) : lopHoc.giaoVien != null) return false;
        return dsLop != null ? dsLop.equals(lopHoc.dsLop) : lopHoc.dsLop == null;
    }

    @Override
    public int hashCode() {
        int result = ten != null ? ten.hashCode() : 0;
        result = 31 * result + (giaoVien != null ? giaoVien.hashCode() : 0);
        result = 31 * result + (dsLop != null ? dsLop.hashCode() : 0);
        return result;
    }
}
