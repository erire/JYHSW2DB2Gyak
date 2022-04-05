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
				System.out.println("Menü pontok \r 1. Lekérdezés \r 2. Adat Modositás \r 3. Új Adat Felvétel \r"
						+ " 4. Adat Törlés \r 5. Kurzor \r 6. Kilépés");
				System.out.println("Válasszon: ");
				int valasztas_1 = sc.nextInt();
				switch (valasztas_1) {
				case 1:
					while (exitSubMenu != 1) {
						System.out.println("Menü pontok \r 1. Mérési Adatok \r 2. Mérö Eszköz \r 3. Szerelö "
								+ "\r 4. Telephely \r 5. EszKöz Mérések \r 6. Kilépés \rVálaszon: ");
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
					System.out.println("Menü pontok \r 1. Mérési Adatok Modositása \r 2. Méröeszköz Adatok Modositása"
							+ "\r 3. Szerelö Adatok Modositása"
							+ "\r 4. Telephely Adatok Modositása \r 5. Kilépés \rVálaszon: ");
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
					System.out.println("Menü pontok \r 1. Új Mérési Adatok Felvétele"
							+ "\r 2. Új Méröeszköz Adatok Felvétele"
								+ "\r 3. Új Szerelö Adatok Felvétele"
								+ "\r 4. Új Telephely Adatok Felvétele \r 5. Kilépés \rVálaszon: ");
					int valasztas_2 = sc.nextInt();
					switch (valasztas_2) {
					case 1:
						felv.ujMeresiAdatok(conn);
						break;
					case 2:
						felv.ujMeröezköz(conn);
						break;
					case 3:
						felv.ujSzerelö(conn);
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
					System.out.println("Menü pontok \r 1. Mérési Adatok Törlése"
								+ "\r 2. Méröeszköz Adatok Törlése"
									+ "\r 3. Szerelö Adatok Törlése"
									+ "\r 4. Telephely Adatok Törlése \r 5. Kilépés \rVálaszon: ");
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
		System.out.println("Kérem a felhasználó nevet: ");
		String user = sc.nextLine();
		System.out.println("Kérem a jelszót: ");
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