package model;

public class taikhoan {
	private String matk, Username, Pass;

	public taikhoan(String matk, String Username, String Pass) {
		super();
		this.matk = matk;
		this.Username = Username;
		this.Pass = Pass;
	}

	public String getMatk() {
		return matk;
	}

	public void setMatk(String matk) {
		this.matk = matk;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}

	@Override
	public String toString() {
		return "taikhoanDTO [matk=" + matk + ", Username=" + Username + ", Pass=" + Pass + "]";
	}
	
}
