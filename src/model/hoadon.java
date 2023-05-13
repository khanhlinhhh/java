package model;

import java.util.Date;

public class hoadon {
	private  String maHD, maphong, maNV;
	private Date ngayden, ngaydi;
	private float giaHD;
	public hoadon(String maHD, String maphong, String maNV, Date ngayden, Date ngaydi, float giaHD) {
		super();
		this.maHD = maHD;
		this.maphong = maphong;
		this.maNV = maNV;
		this.ngayden = ngayden;
		this.ngaydi = ngaydi;
		this.giaHD = giaHD;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaphong() {
		return maphong;
	}
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getNgayden() {
		return ngayden;
	}
	public void setNgayden(Date ngayden) {
		this.ngayden = ngayden;
	}
	public Date getNgaydi() {
		return ngaydi;
	}
	public void setNgaydi(Date ngaydi) {
		this.ngaydi = ngaydi;
	}
	public float getGiaHD() {
		return giaHD;
	}
	public void setGiaHD(float giaHD) {
		this.giaHD = giaHD;
	}
	@Override
	public String toString() {
		return "hoadonDTO [maHD=" + maHD + ", maphong=" + maphong + ", maNV=" + maNV + ", ngayden=" + ngayden
				+ ", ngaydi=" + ngaydi + ", giaHD=" + giaHD + "]";
	}
	
}
