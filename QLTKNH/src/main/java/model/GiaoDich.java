package model;

import java.sql.Date;

public class GiaoDich {
	private String MaGD;
	private String SoTK;
	private String MaLoaiGD;
	private int SoTienGD;
	private Date NgayGD;
	private String NoiDung;
	
	public GiaoDich() {

	}
	
	public GiaoDich(String maGD, String soTK, String maLoaiGD, int soTienGD, Date ngayGD, String noiDung) {
		super();
		MaGD = maGD;
		SoTK = soTK;
		MaLoaiGD = maLoaiGD;
		SoTienGD = soTienGD;
		NgayGD = ngayGD;
		NoiDung = noiDung;
	}
	public String getMaGD() {
		return MaGD;
	}
	public void setMaGD(String maGD) {
		MaGD = maGD;
	}
	public String getSoTK() {
		return SoTK;
	}
	public void setSoTK(String soTK) {
		SoTK = soTK;
	}
	public String getMaLoaiGD() {
		return MaLoaiGD;
	}
	public void setMaLoaiGD(String maLoaiGD) {
		MaLoaiGD = maLoaiGD;
	}
	public int getSoTienGD() {
		return SoTienGD;
	}
	public void setSoTienGD(int soTienGD) {
		SoTienGD = soTienGD;
	}
	public Date getNgayGD() {
		return NgayGD;
	}
	public void setNgayGD(Date ngayGD) {
		NgayGD = ngayGD;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	@Override
	public String toString() {
		return "GiaoDich [MaGD=" + MaGD + ", SoTK=" + SoTK + ", MaLoaiGD=" + MaLoaiGD + ", SoTienGD=" + SoTienGD
				+ ", NgayGD=" + NgayGD + ", NoiDung=" + NoiDung + "]";
	}

	
	
}
