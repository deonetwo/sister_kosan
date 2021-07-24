package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.AlamatKost;
import model.Kamar;
import model.Kosan;
import model.Pembayaran;
import model.Pemesan;

public class ServerApp extends UnicastRemoteObject implements IKosanApp {
	// private Database db;
	private ArrayList<Kosan> listKosan;
	private ArrayList<Kamar> listKamar;
	private ArrayList<Pembayaran> listPembayaran;


	public ServerApp() throws RemoteException {
		super();
		// db = Database.getDbInstance();

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
		listKamar.add(new Kamar("K01", "Tipe A", 600000.0, 3, 
						"Kosan sekitar SD Pasir Pogor. Adem. Termasuk biaya listrik. Kamar mandi bersama. Tidak ada jam malam.",
						3.0, 2.5));
		listKamar.add(new Kamar("K01", "Tipe B", 750000.0, 1, 
						"Kosan sekitar SD Pasir Pogor. Adem. Termasuk biaya listrik dan Wifi. Kamar mandi dalam. Tidak ada jam malam.",
						4.0, 3.0));
		
		// add Kamar to Kosan K02
		listKamar.add(new Kamar("K01", "Tipe B", 750000.0, 1, 
						"Kosan sekitar SD Pasir Pogor. Adem. Termasuk biaya listrik dan Wifi. Kamar mandi dalam. Tidak ada jam malam.",
						4.0, 3.0));
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		try {
			Registry registry = LocateRegistry.createRegistry(7777);
			registry.bind("squared", new ServerApp());
			System.out.println("The Server is running fast as fu*k..");
		}
		catch(Exception e) {
			System.out.println("ERROR: HAHA!");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Kamar> getListKamar() throws RemoteException {
		return this.listKamar;
	}

	@Override
	public void performPesanKamar(int id_kamar, LocalDateTime tanggal_pembayaran, double total_pembayaran,
			int jumlah_bulan_dipesan, Pemesan pemesan) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
