package model;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/*
Kelas 
 */
public class Kamar implements Serializable{
    private String id_kostan;
	private int id_kamar;
    private String tipe_kamar;
    private double harga;
    private int sisa_kamar;
    private String deskripsi;
    private double panjang_kamar;
    private double lebar_kamar;

    public Kamar(String id_kostan, int id_kamar, String tipe_kamar, double harga, int sisa_kamar, String deskripsi,
			double d, double e) {
		super();
		this.id_kostan = id_kostan;
		this.id_kamar = id_kamar;
		this.tipe_kamar = tipe_kamar;
		this.id_kamar = id_kamar;
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

	public int getIdKamar(){
		return this.id_kamar;
	}

	public void setIdKamar(int idKamar) {
		this.id_kamar = idKamar;
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

	public boolean kurangiStokKamar(){
		int success = 0;
		if (this.sisa_kamar > 0) {
			ReentrantLock mutex = new ReentrantLock();
			try {
				mutex.lock();
				this.sisa_kamar--;
				success = 1;
			} finally {
				mutex.unlock();
			}	
		}
		return success == 1 ? true : false;
	}
	
	@Override
	public String toString() {
		return "Kosan " + this.tipe_kamar + ". " + this.deskripsi.substring(0, 30);
	}
}
