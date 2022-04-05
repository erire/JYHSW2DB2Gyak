package jyhsw2db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Felvitel implements felv {
	static Scanner sc = new Scanner(System.in);
	static PreparedStatement ps = null;
	@Override
	public void ujMeresiAdatok(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="insert into meresiadatok(homerseklet, meres_ideje, paratartalom, szallopor, kendioxid, szenmonoxid, nitrogéndioxid, eszkozkulcs)" + "values(?,?,?,?,?,?,?,?)";
			
			System.out.println("Kérem a hömérséklet adatot: ");
			int homerseklet = sc.nextInt();
			System.out.println("Kérem a mérés idejét: ");
			String meres_ideje = sc.next().trim();
			System.out.println("Kérem a páratartalom adatot: ");
			int paratartalom = sc.nextInt();
			System.out.println("Kérem a szállópor adatot: ");
			int szallopor = sc.nextInt();
			System.out.println("Kérem a kéndioxid adatot: ");
			int kendioxid = sc.nextInt();
			System.out.println("Kérem a szénmonoxid adatot: ");
			int szenmonoxid = sc.nextInt();
			System.out.println("Kérem az nitrogéndioxid adatot: ");
			int nitrogéndioxid = sc.nextInt();
			System.out.println("Kérem a méröezköz számot: ");
			int eszkozkulcs = sc.nextInt();
			
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setInt(1, homerseklet);
				ps.setString(2, meres_ideje);
				ps.setInt(3, paratartalom);
				ps.setInt(4, szallopor);
				ps.setInt(5, kendioxid);
				ps.setInt(6, szenmonoxid);
				ps.setInt(7, nitrogéndioxid);
				ps.setInt(8, eszkozkulcs);
				ps.executeUpdate();
				ps.close();
				System.out.println("Új mérési adatok felvéve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void ujMeröezköz(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="insert into meroeszkoz(gyartas_ido, magassag, irszam, varos, utca, hazszam, tipus, gyarto)" + "values(?,?,?,?,?,?,?,?)";
			
			System.out.println("Kérem adja meg az eszköz tipust: ");
			String tipus = sc.next().trim();
			System.out.println("Kérem adja meg a gyártó nevét: ");
			String gyarto = sc.next().trim();
			System.out.println("Kérem adja meg gyártási idöt: ");
			int gyartas_ido = sc.nextInt();
			System.out.println("Kérem adja meg hány méter magassan helyezkedik el az eszköz: ");
			int magassag = sc.nextInt();
			System.out.println("Kérem adja meg az irányitó számot: ");
			int irszam = sc.nextInt();
			System.out.println("Kérem adja meg a város nevét: ");
			String varos = sc.next().trim();
			System.out.println("Kérem adja meg az utca nevét: ");
			String utca = sc.next().trim();
			System.out.println("Kérem adja meg a házszámot: ");
			int hazszam = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setInt(1, gyartas_ido);
				ps.setInt(2, magassag);
				ps.setInt(3, irszam);
				ps.setString(4, varos);
				ps.setString(5, utca);
				ps.setInt(6, hazszam);
				ps.setString(7, tipus);
				ps.setString(8, gyarto);
				ps.executeUpdate();
				ps.close();
				System.out.println("Új eszköz adatok felvéve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void ujSzerelö(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="insert into szerelo(nev, javitas_határido, telepkulcs)" + "values(?,?,?)";
			
			System.out.println("Kérem adja meg a szerelö nevét: ");
			String nev = sc.next().trim();
			System.out.println("Kérem adja meg a javítási határidöt: ");
			String javitas_határido = sc.next().trim();
			System.out.println("Kérem adja meg a telephely számát");
			int telepkulcs = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, nev);
				ps.setString(2, javitas_határido);
				ps.setInt(3, telepkulcs);
				ps.executeUpdate();
				ps.close();
				System.out.println("Új szerelo adatok felvéve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void ujTelephely(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="insert into telephely(telefonszam, irszam, varos, utca, hazszam)" + "values(?,?,?,?,?)";
			
			System.out.println("Kérem adja meg a telefonszámot: ");
			String telefonszam = sc.next().trim();
			System.out.println("Kérem adja meg a irányitó számot: ");
			int irszam = sc.nextInt();
			System.out.println("Kérem adja meg a várost: ");
			String varos = sc.next().trim();
			System.out.println("Kérem adja meg az Utcát: ");
			String utca = sc.next().trim();
			System.out.println("Kérem adja meg a házszámot: ");
			int hazszam = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, telefonszam);
				ps.setInt(2, irszam);
				ps.setString(3, varos);
				ps.setString(4, utca);
				ps.setInt(5, hazszam);
				ps.executeUpdate();
				ps.close();
				System.out.println("Új telephely adatok felvéve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

}
