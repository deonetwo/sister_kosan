package model;

import java.io.Serializable;

/*
Kelas 
 */
public class Kamar implements Serializable{
    private String id_kostan;
    private String tipe_kamar;
    private double harga;
    private int sisa_kamar;
    private String deskripsi;
    private double panjang_kamar;
    private double lebar_kamar;

    public Kamar(String id_kostan, String tipe_kamar, double harga, int sisa_kamar, String deskripsi,
			double d, double e) {
		super();
		this.id_kostan = id_kostan;
		this.tipe_kamar = tipe_kamar;
		this.harga = harga;
		this.sisa_kamar = sisa_kamar;
		this.deskripsi = deskripsi;
		this.panjang_kamar = d;
		this.lebar_kamar = e;
	}
	public String getId_kostan() {
		return id_kostan;
	}
	public void setId_kostan(String id_kostan) {
		this.id_kostan = id_kostan;
	}
	public String getTipe_kamar() {
		return tipe_kamar;
	}
	public void setTipe_kamar(String tipe_kamar) {
		this.tipe_kamar = tipe_kamar;
	}
	public double getHarga() {
		return harga;
	}
	public void setHarga(double harga) {
		this.harga = harga;
	}
	public int getSisa_kamar() {
		return sisa_kamar;
	}
	public void setSisa_kamar(int sisa_kamar) {
		this.sisa_kamar = sisa_kamar;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public double getPanjang_kamar() {
		return panjang_kamar;
	}
	public void setPanjang_kamar(float panjang_kamar) {
		this.panjang_kamar = panjang_kamar;
	}
	public double getLebar_kamar() {
		return lebar_kamar;
	}
	public void setLebar_kamar(float lebar_kamar) {
		this.lebar_kamar = lebar_kamar;
	}
}
