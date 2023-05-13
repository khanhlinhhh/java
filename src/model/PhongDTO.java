package model;

public class PhongDTO {
	 String maphong, tenphong, loaiphong;
	 String giaphong, tinhtrang;
	public PhongDTO() {
		super();
	}
	public PhongDTO(String maphong, String tenphong, String loaiphong, String giaphong, String tinhtrang) {
		super();
		this.maphong = maphong;
		this.tenphong = tenphong;
		this.loaiphong = loaiphong;
		this.giaphong = giaphong;
		this.tinhtrang = tinhtrang;
	}
	/**
	 * @return the maphong
	 */
	public String getMaphong() {
		return maphong;
	}
	/**
	 * @param maphong the maphong to set
	 */
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
	/**
	 * @return the tenphong
	 */
	public String getTenphong() {
		return tenphong;
	}
	/**
	 * @param tenphong the tenphong to set
	 */
	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}
	/**
	 * @return the loaiphong
	 */
	public String getLoaiphong() {
		return loaiphong;
	}
	/**
	 * @param loaiphong the loaiphong to set
	 */
	public void setLoaiphong(String loaiphong) {
		this.loaiphong = loaiphong;
	}
	/**
	 * @return the giaphong
	 */
	public String getGiaphong() {
		return giaphong;
	}
	/**
	 * @param giaphong the giaphong to set
	 */
	public void setGiaphong(String giaphong) {
		this.giaphong = giaphong;
	}
	/**
	 * @return the tinhtrang
	 */
	public String getTinhtrang() {
		return tinhtrang;
	}
	/**
	 * @param tinhtrang the tinhtrang to set
	 */
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	@Override
	public String toString() {
		return "PhongDTO [maphong=" + maphong + ", tenphong=" + tenphong + ", loaiphong=" + loaiphong + ", giaphong="
				+ giaphong + ", tinhtrang=" + tinhtrang + "]";
	}
	
	
	
}

	

