package client;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

import model.Kamar;
import model.Kosan;
import model.Pemesan;
import server.IKosanApp;

public class ClientApp {
	private static Scanner scan = null;
	public static void main (String args[]) {
		ArrayList<Kamar> listKamar = new ArrayList<>();
		ArrayList<Kamar> listKamarDipesan = new ArrayList<>();
		try {
			IKosanApp kosanAPI = (IKosanApp) Naming.lookup("rmi://localhost:7777/squared");
			
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
				}
				else {
					Kamar pesananKamar = pilihKamarKosan(listKamar);
					System.out.println(pesananKamar.toString());
					// performBayarKamar(kosanAPI, pesananKamar, pemesan, listKamarDipesan);
				}
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: Not running HAHA!");
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
	
	public static void performBayarKamar(IKosanApp kosanAPI, Kamar pesananKamar, Pemesan pemesan, ArrayList<Kamar> listKamarDipesan) {
		
	}
	
	public static Kamar pilihKamarKosan(ArrayList<Kamar> listKosan) {
		System.out.println("List Kamar yang tersedia:");
		int i = 1;
		for (Kamar kamar : listKosan) { 		      
	           System.out.println(i + ". " + kamar.toString()); 
	           i++;
	    }
		System.out.println("Pilih kamar: ");
		return listKosan.get(scan.nextInt());
	}
}
