package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pembayaran {
    private String id_pembayaran;
    private int id_kamar;
    private LocalDateTime tanggal_pembayaran;
    private double total_bayar;
    private int jumlah_bulan_dipesan;
    private Pemesan pemesan;

    public Pembayaran(){};

    public Pembayaran(String id_pembayaran, int id_kamar, LocalDateTime tanggal_pembayaran, double total_pembayaran, int jumlah_bulan_dipesan, Pemesan pemesan) {
        this.id_pembayaran = id_pembayaran;
        this.id_kamar = id_kamar;
        this.tanggal_pembayaran = tanggal_pembayaran;
        this.total_bayar = total_bayar;
        this.jumlah_bulan_dipesan = jumlah_bulan_dipesan;
        this.pemesan = pemesan;
    }

	public String getId_pembayaran() {
		return id_pembayaran;
	}

	public void setId_pembayaran(String id_pembayaran) {
		this.id_pembayaran = id_pembayaran;
	}

	public int getId_kamar() {
		return id_kamar;
	}

	public void setId_kamar(int id_kamar) {
		this.id_kamar = id_kamar;
	}

	public LocalDateTime getTanggal_pembayaran() {
		return tanggal_pembayaran;
	}

	public void setTanggal_pembayaran(LocalDateTime tanggal_pembayaran) {
		this.tanggal_pembayaran = tanggal_pembayaran;
	}

	public double getTotal_bayar() {
		return total_bayar;
	}

	public void setTotal_bayar(double total_bayar) {
		this.total_bayar = total_bayar;
	}

	public int getJumlah_bulan_dipesan() {
		return jumlah_bulan_dipesan;
	}

	public void setJumlah_bulan_dipesan(int jumlah_bulan_dipesan) {
		this.jumlah_bulan_dipesan = jumlah_bulan_dipesan;
	}

	public Pemesan getPemesan() {
		return pemesan;
	}

	public void setPemesan(Pemesan pemesan) {
		this.pemesan = pemesan;
	}
}
