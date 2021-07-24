package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Kamar;
import model.Pemesan;

public interface IKosanApp extends Remote {
	public ArrayList<Kamar> getListKamar() throws RemoteException;
	public void performPesanKamar(int id_kamar, LocalDateTime tanggal_pembayaran, double total_pembayaran, int jumlah_bulan_dipesan, Pemesan pemesan) throws RemoteException;
}
