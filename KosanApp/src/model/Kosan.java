package model;

public class Kosan {
    public String id_kostan;
	public String nama_pemilik;
    public String nomor_telepon;
    public AlamatKost alamatKost;
    
    public Kosan(String id_kostan, String nama_pemilik, String nomor_telepon, AlamatKost alamatKost) {
		this.id_kostan = id_kostan;
		this.nama_pemilik = nama_pemilik;
		this.nomor_telepon = nomor_telepon;
		this.alamatKost = alamatKost;
	}
    
    public String getId_kostan() {
		return id_kostan;
	}

	public void setId_kostan(String id_kostan) {
		this.id_kostan = id_kostan;
	}

	public String getNama_pemilik() {
		return nama_pemilik;
	}

	public void setNama_pemilik(String nama_pemilik) {
		this.nama_pemilik = nama_pemilik;
	}

	public String getNomor_telepon() {
		return nomor_telepon;
	}

	public void setNomor_telepon(String nomor_telepon) {
		this.nomor_telepon = nomor_telepon;
	}

	public AlamatKost getAlamatKost() {
		return alamatKost;
	}

	public void setAlamatKost(AlamatKost alamatKost) {
		this.alamatKost = alamatKost;
	}
}