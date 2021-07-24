package model;

public class Pemesan {
	public String nama_pemesan;
    public String no_telepon_pemesan;
    public String email;

    public Pemesan(String nama_pemasanan,String no_telepon_pemesan, String email){
        this.nama_pemesan=nama_pemesan;
        this.no_telepon_pemesan = no_telepon_pemesan;
        this.email=email;
    }

	public String getNama_pemesan() {
		return nama_pemesan;
	}

	public void setNama_pemesan(String nama_pemesan) {
		this.nama_pemesan = nama_pemesan;
	}

	public String getNo_telepon_pemesan() {
		return no_telepon_pemesan;
	}

	public void setNo_telepon_pemesan(String no_telepon_pemesan) {
		this.no_telepon_pemesan = no_telepon_pemesan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
