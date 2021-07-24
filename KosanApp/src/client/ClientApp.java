package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import model.Kamar;
import model.Pemesan;
import server.IKosanApp;

public class ClientApp {
	private static Scanner scan = null;
	public static void main (String args[]) {
		ArrayList<Kamar> listKamar = new ArrayList<>();
		ArrayList<Kamar> listKamarDipesan = new ArrayList<>();
		try {
			IKosanApp kosanAPI = (IKosanApp) Naming.lookup("rmi://localhost:7777/kosan");
			
			scan = new Scanner(System.in);
			
			System.out.println("Masukan nama:");
			String nama = scan.nextLine();
			System.out.println("Masukan nomor telepon:");
			String noTelp = scan.nextLine();
			System.out.println("Masukan email:");
			String email = scan.nextLine();
			
			Pemesan pemesan = new Pemesan(nama, noTelp, email);
			
			while(true) {
				listKamar = kosanAPI.getListKamar();
				System.out.println("==============================");
				System.out.println("1. Lihat kamar yang sudah dipesan.");
				System.out.println("2. Cari kamar kosan.");
				System.out.println("Enter choice:");
				int choice = scan.nextInt();
				if(choice == 1) {
					lihatKamarDipesan(listKamarDipesan);
				} else if (choice == 2) {
					Kamar pesananKamar = pilihKamarKosan(listKamar);
					while(pesananKamar.getSisa_kamar() <= 0) {
						System.out.println("Kamar yang dipesan tidak tersedia!");
						pesananKamar = pilihKamarKosan(listKamar);
					}
					// System.out.println(pesananKamar.toString());
					if(performBayarKamar(kosanAPI, pesananKamar, pemesan)) {
						listKamarDipesan.add(pesananKamar);
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: Client failed to running..");
			e.printStackTrace();
		}
	}
	
	public static void lihatKamarDipesan(ArrayList<Kamar> listKamarDipesan) {
		System.out.println("List Kamar yang Sudah Dipesan:");
		int i = 1;
		for (Kamar kamar : listKamarDipesan) { 		      
	           System.out.println(i + ". " + kamar.toString()); 
	           i++;
	    }
		System.out.println();
	}
	
	public static boolean performBayarKamar(IKosanApp kosanAPI, Kamar pesananKamar, Pemesan pemesan) throws RemoteException {
		System.out.println("Masukan jumlah bulan dipesan:");
		int jumlahBulan = scan.nextInt();
		while(jumlahBulan <= 0) {
			System.out.println("Jumlah kamar tidak valid.");
			System.out.println("Masukan jumlah bulan dipesan:");
			jumlahBulan = scan.nextInt();
		}
		
		System.out.println("==============================");
		System.out.println("Kosan\t\t: " + pesananKamar.toString());
		System.out.println("Atas nama\t: " + pemesan.getNama_pemesan());
		System.out.println("Jumlah bulan\t: " + jumlahBulan);
		System.out.println("Total bayar\t: Rp" + jumlahBulan * pesananKamar.getHarga());
		
		System.out.println("Anda yakin ingin memesan kamar?");
		System.out.println("1. Ya");
		System.out.println("2. Tidak");
		System.out.println("Pilihan:");
		int choice = scan.nextInt();
		if (choice == 1) {
			if(kosanAPI.performPesanKamar(pesananKamar.getIdKamar(), LocalDateTime.now(), jumlahBulan * pesananKamar.getHarga(), jumlahBulan, pemesan)) {
				return true;
			}
			else {
				System.out.println("Gagal memesan kamar.");
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static Kamar pilihKamarKosan(ArrayList<Kamar> listKosan) {
		System.out.println("List Kamar yang tersedia:");
		int i = 1;
		for (Kamar kamar : listKosan) { 		
			if (kamar.getSisa_kamar() <= 0) {
				System.out.println(i + ". " + kamar.toString() + "[Tidak ada kamar kosong]"); 
			}
			else {
				System.out.println(i + ". " + kamar.toString()); 
			}
	        i++;
	    }
		System.out.println("Pilih kamar: ");
		return listKosan.get(scan.nextInt() - 1);
	}
}
