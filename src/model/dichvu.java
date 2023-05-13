package model;

public class dichvu {
	private String maDV, tenDV, donvitinh;
	private float giaDV;
	public dichvu(String maDV, String tenDV, String donvitinh, float giaDV) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donvitinh = donvitinh;
		this.giaDV = giaDV;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getDonvitinh() {
		return donvitinh;
	}
	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}
	public float getGiaDV() {
		return giaDV;
	}
	public void setGiaDV(float giaDV) {
		this.giaDV = giaDV;
	}
	@Override
	public String toString() {
		return "dichvu [maDV=" + maDV + ", tenDV=" + tenDV + ", donvitinh=" + donvitinh + ", giaDV=" + giaDV + "]";
	}
}