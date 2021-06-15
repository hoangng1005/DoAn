package model;

import java.sql.Date;

public class TaiKhoan {
	private String SoTK;
	private String MaLoaiTK;
	private String MaKH;
	private float SoDu;
	private Date NgayCapNhat;
	private String TrangThaiTK;
	
	public TaiKhoan () {}
	
	public TaiKhoan(String soTK, String maLoaiTK, String maKH, float soDu, Date ngayCapNhat, String trangThaiTK) {
		super();
		SoTK = soTK;
		MaLoaiTK = maLoaiTK;
		MaKH = maKH;
		SoDu = soDu;
		NgayCapNhat = ngayCapNhat;
		TrangThaiTK = trangThaiTK;
	}
	
	public String getSoTK() {
		return SoTK;
	}
	public void setSoTK(String soTK) {
		SoTK = soTK;
	}
	public String getMaLoaiTK() {
		return MaLoaiTK;
	}
	public void setMaLoaiTK(String maLoaiTK) {
		MaLoaiTK = maLoaiTK;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public float getSoDu() {
		return SoDu;
	}
	public void setSoDu(float soDu) {
		SoDu = soDu;
	}
	public Date getNgayCapNhat() {
		return NgayCapNhat;
	}
	public void setNgayCapNhat(Date ngayCapNhat) {
		NgayCapNhat = ngayCapNhat;
	}
	public String getTrangThaiTK() {
		return TrangThaiTK;
	}
	public void setTrangThaiTK(String trangThaiTK) {
		TrangThaiTK = trangThaiTK;
	}

	@Override
	public String toString() {
		return "TaiKhoan [SoTK=" + SoTK + ", MaLoaiTK=" + MaLoaiTK + ", MaKH=" + MaKH + ", SoDu=" + SoDu
				+ ", NgayCapNhat=" + NgayCapNhat + ", TrangThaiTK=" + TrangThaiTK + "]";
	}
	
	
}
