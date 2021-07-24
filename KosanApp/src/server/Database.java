package server;

import java.util.ArrayList;

import model.AlamatKost;
import model.Kamar;
import model.Kosan;
import model.Pembayaran;

public class Database {
	// instance database
	private static Database db;

	private ArrayList<Kosan> listKosan;
	private ArrayList<Kamar> listKamar;
	private ArrayList<Pembayaran> listPembayaran;

	private Database() {
		listKosan = new ArrayList<Kosan>();
		listKamar = new ArrayList<Kamar>();
		listPembayaran = new ArrayList<Pembayaran>(); // empty on first instance, no payment had been made

		// add some Kosan
		listKosan.add(new Kosan("K01", "Sudarsono", "555-556-123", 
						new AlamatKost("Jl. Ciwastra Komplek Ciwastra Endah no. 3", "01", "02", "Manjahlega", "Buah Batu", "Bandung")));
		listKosan.add(new Kosan("K02", "Darul Budiman", "987-556-123", 
						new AlamatKost("Jl. Sarimanis II no. 12", "08", "03", "Turangga", "Lengkong", "Bandung")));
		listKosan.add(new Kosan("K03", "Rexa Iwan", "555-765-123", 
						new AlamatKost("Gang Terasana no. 79", "05", "04", "Cisaranten Kulon", "Arcamanik", "Bandung")));

		// add Kamar to Kosan K01
		listKamar.add(new Kamar("K01", 1, "Tipe A", 600000.0, 3, 
						"Kosan sekitar SD Pasir Pogor. Adem. Termasuk biaya listrik. Kamar mandi bersama. Tidak ada jam malam.",
						3.0, 2.5));
		listKamar.add(new Kamar("K01", 2, "Tipe B", 750000.0, 0, 
						"Kosan sekitar SD Pasir Pogor. Adem. Termasuk biaya listrik dan Wifi. Kamar mandi dalam. Tidak ada jam malam.",
						4.0, 3.0));
		
		// add Kamar to Kosan K02
		listKamar.add(new Kamar("K02", 3, "Tipe A", 650000.0, 5, 
						"Kosan dekat Buah Batu. Adem. Tidak termasuk biaya listrik dan air. Kamar mandi dalam. Tidak ada jam malam.",
						4.0, 3.0));
		listKamar.add(new Kamar("K02", 4, "Tipe B", 700000.0, 3, 
						"Kosan dekat Buah Batu. Adem. Termasuk biaya listrik. Kamar mandi bersama. Tidak ada jam malam.",
						4.0, 3.0));
		listKamar.add(new Kamar("K02", 5, "Tipe C", 1200000.0, 1, 
						"Kosan dekat Buah Batu. Adem. Termasuk biaya listrik, Wifi, dan laundry. Kamar mandi dalam. Tidak ada jam malam.",
						4.0, 3.0));
		
        // add Kamar to Kosan K03
		listKamar.add(new Kamar("K03", 6, "Tipe A", 500000.0, 3, 
						"Kosan sekitar Padepokan 79. Tidak termasuk biaya listrik. Kamar mandi bersama. Tidak ada jam malam.",
						3.0, 2.5));
		listKamar.add(new Kamar("K03", 7, "Tipe B", 550000.0, 10, 
						"Kosan sekitar Padepokan 79. Termasuk biaya listrik. Kamar mandi bersama. Tidak ada jam malam.",
						4.0, 3.0));
	}

	public static Database getDbInstance() {
		if (db == null) {
			return new Database();	
		} else {
			return db; 
		}
	}

	public ArrayList<Kosan> getListKosan() {
		return listKosan;
	}

	public void setListKosan(ArrayList<Kosan> listKosan) {
		this.listKosan = listKosan;
	}

	public ArrayList<Kamar> getListKamar() {
		return listKamar;
	}

	public void setListKamar(ArrayList<Kamar> listKamar) {
		this.listKamar = listKamar;
	}

	public ArrayList<Pembayaran> getListPembayaran() {
		return listPembayaran;
	}

	public void setListPembayaran(ArrayList<Pembayaran> listPembayaran) {
		this.listPembayaran = listPembayaran;
	}

    public Kamar getKamarById(int idKamar) {
        for (Kamar kamar : listKamar) {
            if (kamar.getIdKamar() == idKamar) {
                return kamar;
            }
        }
        return null;
    }
}
