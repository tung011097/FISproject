package com.example;

import java.util.*;

public class SinhVien {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }
    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }
    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        double sumDiem = 0;
        int sumTC = 0;
        for (Diem s: monDaHoc) {
            sumDiem += s.getDiem()*(s.getMon().getTcLT()+s.getMon().getTcTH());
            sumTC += s.getMon().getTcLT()+s.getMon().getTcTH();
        }
        return sumDiem/sumTC;
    }
    //TODO Cau 2
    public String bangDiem() {
        int i = 1;
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder
        StringBuilder sb = new StringBuilder("MSSV : " + this.mssv + "\n")
                .append("Ten : " + this.ten + "\n")
                .append("Danh Sach Diem" + "\n")
                .append("| STT |" + "Ten Mon  |" + "Diem |" + "So Tin Chi |" + "\n");
        for (Diem d: monDaHoc ) {
            sb.append("| "+i +"    "+ d.getMon().getTen()+"     " +  d.getDiem() +"    "+ (d.getMon().getTcTH()+d.getMon().getTcLT())+"\n");
            i++;
        }
            sb.append("Diem Trung Binh " + tinhDiemTrungBinh());
        return sb.toString();
        //return null;
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */
        StringBuilder sb = new StringBuilder("Xep loai sinh vien : ");
               if(tinhDiemTrungBinh() < 5){
                   sb.append(this.ten+ " YEU");
               } else if (tinhDiemTrungBinh() >= 5 && tinhDiemTrungBinh() < 6) {
                   sb.append(this.ten+ " TB");
               }else if (tinhDiemTrungBinh() >= 6 && tinhDiemTrungBinh() < 7) {
                   sb.append(this.ten+" TB - KHA");
               }else if (tinhDiemTrungBinh() >= 7 && tinhDiemTrungBinh() < 8) {
                   sb.append(this.ten+" KHA");
               }else {
                   sb.append(this.ten+" GIOI");
               }
        //...
        return sb.toString();
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<Diem> getMonDaHoc() {
        return monDaHoc;
    }

    public void setMonDaHoc(Set<Diem> monDaHoc) {
        this.monDaHoc = monDaHoc;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SinhVien sinhVien = (SinhVien) o;

        if (mssv != null ? !mssv.equals(sinhVien.mssv) : sinhVien.mssv != null) return false;
        if (ten != null ? !ten.equals(sinhVien.ten) : sinhVien.ten != null) return false;
        return monDaHoc != null ? monDaHoc.equals(sinhVien.monDaHoc) : sinhVien.monDaHoc == null;
    }

    @Override
    public int hashCode() {
        int result = mssv != null ? mssv.hashCode() : 0;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (monDaHoc != null ? monDaHoc.hashCode() : 0);
        return result;
    }
}
