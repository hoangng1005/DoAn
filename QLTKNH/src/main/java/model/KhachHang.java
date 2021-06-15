package model;

import java.sql.Date;

public class KhachHang {
    private String MaKH;
    private String SoTK;
    private String HoTen;
    private Date NgaySinh;
    private String DiaChi;
    private String CMND;
    private String SoDT;
    private String NgheNghiep;
    private Date NgayCapNhat;
    private String GioiTinh;
    private String Email;
    private String MaCN;

    public KhachHang() {}
    public KhachHang(String maKH, String soTK, String hoTen, Date ngaySinh,
                     String diaChi, String CMND, String soDT, String ngheNghiep,
                     Date ngayCapNhat, String gioiTinh, String email, String maCN) {
        MaKH = maKH;
        SoTK = soTK;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        this.CMND = CMND;
        SoDT = soDT;
        NgheNghiep = ngheNghiep;
        NgayCapNhat = ngayCapNhat;
        GioiTinh = gioiTinh;
        Email = email;
        MaCN = maCN;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getSoTK() {
        return SoTK;
    }

    public void setSoTK(String soTK) {
        SoTK = soTK;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }

    public String getNgheNghiep() {
        return NgheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        NgheNghiep = ngheNghiep;
    }

    public Date getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        NgayCapNhat = ngayCapNhat;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String maCN) {
        MaCN = maCN;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "MaKH='" + MaKH + '\'' +
                ", SoTK='" + SoTK + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", NgaySinh=" + NgaySinh +
                ", DiaChi='" + DiaChi + '\'' +
                ", CMND='" + CMND + '\'' +
                ", SoDT='" + SoDT + '\'' +
                ", NgheNghiep='" + NgheNghiep + '\'' +
                ", NgayCapNhat=" + NgayCapNhat +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", Email='" + Email + '\'' +
                ", MaCN='" + MaCN + '\'' +
                '}';
    }
}
