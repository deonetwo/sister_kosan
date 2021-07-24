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
	private Database db;

	public ServerApp() throws RemoteException {
		super();
		db = Database.getDbInstance();
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		int port = 7777;
		try {
			Registry registry = LocateRegistry.createRegistry(port);
			registry.bind("kosan", new ServerApp());
			System.out.println("Sever listening to port " + port);
		} catch (Exception e) {
			System.out.println("ERROR: Server failed to running..");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Kamar> getListKamar() throws RemoteException {
		System.out.println("[SUCCESS]" + LocalDateTime.now() + " Retrive List Kamar");
		return db.getListKamar();
	}

	@Override
	public boolean performPesanKamar(int id_kamar, LocalDateTime tanggal_pembayaran, double total_pembayaran,
		int jumlah_bulan_dipesan, Pemesan pemesan) throws RemoteException {
		// insert mutex di database
		if(db.getKamarById(id_kamar).kurangiStokKamar()) {
			System.out.println("[SUCCESS (Pesan Kamar)]" + tanggal_pembayaran + " Pemesan: " + pemesan.nama_pemesan 
					+ " Memesan kamar dengan id=" + id_kamar + " Total Bayar: " + total_pembayaran);
			return true;
		}
		else {
			System.out.println("[FAILED (Pesan Kamar)]" + tanggal_pembayaran + " Pemesan: " + pemesan.nama_pemesan 
					+ " Memesan kamar dengan id=" + id_kamar + " Total Bayar: " + total_pembayaran);
			return false;
		}
	}
}
