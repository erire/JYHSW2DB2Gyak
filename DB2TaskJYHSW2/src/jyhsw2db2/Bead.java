package jyhsw2db2;

import java.sql.*;
import java.util.Scanner;
import jyhsw2db2.*;

public class Bead {
	static Felvitel felv = new Felvitel();
	static Lekerdez lekerd = new Lekerdez();
	static Modosit modos = new Modosit();
	static Torol tor = new Torol();
	static Kurzor kurzor = new Kurzor();
	static Connection conn = null;
	static Scanner sc = new Scanner(System.in);
	static int exitMainMenu = 0;
	static int exitSubMenu = 0;
	
	
	public static void main(String[] args) {
		try {
			Connect();
			while (exitMainMenu != 1) {
				System.out.println("Men� pontok \r 1. Lek�rdez�s \r 2. Adat Modosit�s \r 3. �j Adat Felv�tel \r"
						+ " 4. Adat T�rl�s \r 5. Kurzor \r 6. Kil�p�s");
				System.out.println("V�lasszon: ");
				int valasztas_1 = sc.nextInt();
				switch (valasztas_1) {
				case 1:
					while (exitSubMenu != 1) {
						System.out.println("Men� pontok \r 1. M�r�si Adatok \r 2. M�r� Eszk�z \r 3. Szerel� "
								+ "\r 4. Telephely \r 5. EszK�z M�r�sek \r 6. Kil�p�s \rV�laszon: ");
					int valasztas_2 = sc.nextInt();
					switch (valasztas_2) {
					case 1:
						lekerd.meresiAdatok(conn);
						break;
					case 2:
						lekerd.meroEszkoz(conn);
						break;
					case 3:
						lekerd.szerelo(conn);
						break;
					case 4:
						lekerd.telephely(conn);
						break;
					case 5:
						lekerd.eszKozMeresek(conn);
						break;
					case 6:
						exitSubMenu = 1;
						break;
					}
					}
					exitSubMenu = 0;
					break;
				case 2:
					while (exitSubMenu != 1) {
					System.out.println("Men� pontok \r 1. M�r�si Adatok Modosit�sa \r 2. M�r�eszk�z Adatok Modosit�sa"
							+ "\r 3. Szerel� Adatok Modosit�sa"
							+ "\r 4. Telephely Adatok Modosit�sa \r 5. Kil�p�s \rV�laszon: ");
					int valasztas_2 = sc.nextInt();
					switch (valasztas_2) {
					case 1:
						modos.meresiAdatModositas(conn);
						break;
					case 2:
						modos.meroEszkozModositas(conn);
						break;
					case 3:
						modos.szereloMododitas(conn);
						break;
					case 4:
						modos.telephelyModositas(conn);
						break;
					case 5:
						exitSubMenu = 1;
						break;
					}
					}
					exitSubMenu = 0;
					break;
				case 3:
					while (exitSubMenu != 1) {
					System.out.println("Men� pontok \r 1. �j M�r�si Adatok Felv�tele"
							+ "\r 2. �j M�r�eszk�z Adatok Felv�tele"
								+ "\r 3. �j Szerel� Adatok Felv�tele"
								+ "\r 4. �j Telephely Adatok Felv�tele \r 5. Kil�p�s \rV�laszon: ");
					int valasztas_2 = sc.nextInt();
					switch (valasztas_2) {
					case 1:
						felv.ujMeresiAdatok(conn);
						break;
					case 2:
						felv.ujMer�ezk�z(conn);
						break;
					case 3:
						felv.ujSzerel�(conn);
						break;
					case 4:
						felv.ujTelephely(conn);
						break;
					case 5:
						exitSubMenu = 1;
						break;
					}
					}
					exitSubMenu = 0;
					break;
				case 4:
					while (exitSubMenu != 1) {
					System.out.println("Men� pontok \r 1. M�r�si Adatok T�rl�se"
								+ "\r 2. M�r�eszk�z Adatok T�rl�se"
									+ "\r 3. Szerel� Adatok T�rl�se"
									+ "\r 4. Telephely Adatok T�rl�se \r 5. Kil�p�s \rV�laszon: ");
					int valasztas_2 = sc.nextInt();
					switch (valasztas_2) {
					case 1:
						tor.eszkozAdatTorles(conn);
						break;
					case 2:
						tor.meresiAdatTorles(conn);
						break;
					case 3:
						tor.szereloAdatTorles(conn);
						break;
					case 4:
						tor.TelephelyAdatTorles(conn);
						break;
					case 5:
						exitSubMenu = 1;
						break;
					}
					}
					exitSubMenu = 0;
					break;
				case 5:
					kurzor.ModosithatoKurzor(conn);
					break;
				case 6:
					exitMainMenu = 1;
					break;
				}
			}
			Lekapcs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	public static void Connect() {
		String url = "jdbc:mysql://localhost:3306/bead";
		System.out.println("K�rem a felhaszn�l� nevet: ");
		String user = sc.nextLine();
		System.out.println("K�rem a jelsz�t: ");
		String password = sc.nextLine();
		try {
			conn = DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void Lekapcs() {
		if (conn != null) {
			try {
			conn.close();
			System.out.println("Sikeres lekapcsolodas \n");
		}catch (Exception e) {
			System.err.println(e.getMessage());
			}
		}
	}
	
}