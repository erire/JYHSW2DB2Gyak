package jyhsw2db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Modosit implements Modos {
	static Scanner sc = new Scanner(System.in);
	static PreparedStatement ps = null;
	@Override
	public void meresiAdatModositas(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="UPDATE `meresiadatok` SET `homerseklet` = ?, `meres_ideje` = ?, `paratartalom` = ?, `szallopor` = ?, `kendioxid` = ?, `szenmonoxid` = ?, `nitrogéndioxid` = ?, `eszkozkulcs` = ? WHERE `meresiadatok`.`meresiadatkulcs` = ?;";
			System.out.println("Kérem adja meg hanyas számú adatsort modositaná: ");
			int meresSzam = sc.nextInt();
			System.out.println("Kérem adja meg a modosított hömérsklet adatot: ");
			int homerseklet = sc.nextInt();
			System.out.println("Kérem adja meg a modosított mérési idöt: ");
			String meres_ideje = sc.next().trim();
			System.out.println("Kérem adja meg a modosított páratartalom adatot: ");
			int paratartalom = sc.nextInt();
			System.out.println("Kérem adja meg a modosított szállópor adatot: ");
			int szallopor = sc.nextInt();
			System.out.println("Kérem adja meg a modosított kéndioxid adatot: ");
			int kendioxid = sc.nextInt();
			System.out.println("Kérem adja meg a modosított széndioxid adatot: ");
			int szenmonoxid = sc.nextInt();
			System.out.println("Kérem adja meg a modosított nitrogéndioxid adatot: ");
			int nitrogéndioxid = sc.nextInt();
			System.out.println("Kérem adja meg a modosított méröezköz számot: ");
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
				ps.setInt(9, meresSzam);
				ps.executeUpdate();
				ps.close();
				System.out.println("Módositás megtörtént\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	@Override
	public void meroEszkozModositas(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="UPDATE `meroeszkoz` SET `gyartas_ido` = ?, `magassag` = ?, `irszam` = ?, `varos` = ?, `utca` = ?, `hazszam` = ?, `tipus` = ?, `gyarto` = ? WHERE `meroeszkoz`.`eszkozkulcs` = ?;";
			System.out.println("Kérem adja meg hanyas számú adatsort modositaná: ");
			int eszkozkulcs = sc.nextInt();
			System.out.println("Kérem adja meg a modosított gyártási idö adatot: ");
			int gyartas_ido = sc.nextInt();
			System.out.println("Kérem adja meg a modosított magasság adatot: ");
			int magassag = sc.nextInt();
			System.out.println("Kérem adja meg a modosított írányitószám adatot: ");
			int irszam = sc.nextInt();
			System.out.println("Kérem adja meg a modosított a város nevet: ");
			String varos = sc.next().trim();
			System.out.println("Kérem adja meg a modosított utca nevet: ");
			String utca = sc.next().trim();
			System.out.println("Kérem adja meg a modosított hazszamot: ");
			int hazszam = sc.nextInt();
			System.out.println("Kérem adja meg a modosított tipus adatot: ");
			String tipus = sc.next().trim();
			System.out.println("Kérem adja meg a modosított gyártó nevet: ");
			String gyarto = sc.next().trim();
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
				ps.setInt(9, eszkozkulcs);
				ps.executeUpdate();
				ps.close();
				System.out.println("Módositás megtörtént\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void szereloMododitas(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="UPDATE `szerelo` SET `nev` = ?, `javitas_határido` = ?, `telepkulcs` = ? WHERE `szerelo`.`szerelokulcs` = ?;";
			System.out.println("Kérem adja meg hanyas számú adatsort modositaná: ");
			int szerelokulcs = sc.nextInt();
			System.out.println("Kérem adja meg a modosított szerelö nevet: ");
			String nev = sc.next().trim();
			System.out.println("Kérem adja meg a modosított javitsi határidöt: ");
			String javitas_határido = sc.next().trim();
			System.out.println("Kérem adja meg a modosított telephely számot: ");
			int telepkulcs = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, nev);
				ps.setString(2, javitas_határido);
				ps.setInt(3, telepkulcs);
				ps.setInt(4, szerelokulcs);
				ps.executeUpdate();
				ps.close();
				System.out.println("Módositás megtörtént\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void telephelyModositas(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="UPDATE `telephely` SET `telefonszam` = ?, `irszam` = ?, `varos` = ?, `utca` = ?, `hazszam` = ? WHERE `telephely`.`telepkulcs` = ?;";
			System.out.println("Kérem adja meg hanyas számú adatsort modositaná: ");
			int telepkulcs = sc.nextInt();
			System.out.println("Kérem adja meg a modosított telefonszámot: ");
			String telefonszam = sc.next().trim();
			System.out.println("Kérem adja meg a modosított írányitószámot: ");
			int irszam = sc.nextInt();
			System.out.println("Kérem adja meg a modosított város nevet: ");
			String varos = sc.next().trim();
			System.out.println("Kérem adja meg a modosított utca nevet: ");
			String utca = sc.next().trim();
			System.out.println("Kérem adja meg a modosított hazszamot: ");
			int hazszam = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, telefonszam);
				ps.setInt(2, irszam);
				ps.setString(3, varos);
				ps.setString(4, utca);
				ps.setInt(5, hazszam);
				ps.setInt(6, telepkulcs);
				ps.executeUpdate();
				ps.close();
				System.out.println("Módositás megtörtént\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

}
