package model;

public class khachHang {
	private String maKH, hotenKH, maphong, diachi, gioitinh;
	private int cmnd, sdt;
	public khachHang(String maKH, String hotenKH, String maphong, String diachi, String gioitinh, int cmnd,
			int sdt) {
		super();
		this.maKH = maKH;
		this.hotenKH = hotenKH;
		this.maphong = maphong;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.cmnd = cmnd;
		this.sdt = sdt;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHotenKH() {
		return hotenKH;
	}
	public void setHotenKH(String hotenKH) {
		this.hotenKH = hotenKH;
	}
	public String getMaphong() {
		return maphong;
	}
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public int getCmnd() {
		return cmnd;
	}
	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "khachHangDTO [maKH=" + maKH + ", hotenKH=" + hotenKH + ", maphong=" + maphong + ", diachi=" + diachi
				+ ", gioitinh=" + gioitinh + ", cmnd=" + cmnd + ", sdt=" + sdt + "]";
	}
	
}
