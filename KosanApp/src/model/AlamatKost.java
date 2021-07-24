package model;

public class AlamatKost {
	private String teks_alamat;
    private String rt;
    private String rw;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    
    public AlamatKost(String teks_alamat, String rt, String rw, String kelurahan, String kecamatan, String kota) {
		super();
		this.teks_alamat = teks_alamat;
		this.rt = rt;
		this.rw = rw;
		this.kelurahan = kelurahan;
		this.kecamatan = kecamatan;
		this.kota = kota;
	}
    
    public String getTeks_alamat() {
		return teks_alamat;
	}
	public void setTeks_alamat(String teks_alamat) {
		this.teks_alamat = teks_alamat;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getRw() {
		return rw;
	}
	public void setRw(String rw) {
		this.rw = rw;
	}
	public String getKelurahan() {
		return kelurahan;
	}
	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}
	public String getKecamatan() {
		return kecamatan;
	}
	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
}