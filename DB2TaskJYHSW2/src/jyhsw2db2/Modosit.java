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
			String sqlp="UPDATE `meresiadatok` SET `homerseklet` = ?, `meres_ideje` = ?, `paratartalom` = ?, `szallopor` = ?, `kendioxid` = ?, `szenmonoxid` = ?, `nitrog�ndioxid` = ?, `eszkozkulcs` = ? WHERE `meresiadatok`.`meresiadatkulcs` = ?;";
			System.out.println("K�rem adja meg hanyas sz�m� adatsort modositan�: ");
			int meresSzam = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott h�m�rsklet adatot: ");
			int homerseklet = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott m�r�si id�t: ");
			String meres_ideje = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott p�ratartalom adatot: ");
			int paratartalom = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott sz�ll�por adatot: ");
			int szallopor = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott k�ndioxid adatot: ");
			int kendioxid = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott sz�ndioxid adatot: ");
			int szenmonoxid = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott nitrog�ndioxid adatot: ");
			int nitrog�ndioxid = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott m�r�ezk�z sz�mot: ");
			int eszkozkulcs = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setInt(1, homerseklet);
				ps.setString(2, meres_ideje);
				ps.setInt(3, paratartalom);
				ps.setInt(4, szallopor);
				ps.setInt(5, kendioxid);
				ps.setInt(6, szenmonoxid);
				ps.setInt(7, nitrog�ndioxid);
				ps.setInt(8, eszkozkulcs);
				ps.setInt(9, meresSzam);
				ps.executeUpdate();
				ps.close();
				System.out.println("M�dosit�s megt�rt�nt\n");
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
			System.out.println("K�rem adja meg hanyas sz�m� adatsort modositan�: ");
			int eszkozkulcs = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott gy�rt�si id� adatot: ");
			int gyartas_ido = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott magass�g adatot: ");
			int magassag = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott �r�nyit�sz�m adatot: ");
			int irszam = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott a v�ros nevet: ");
			String varos = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott utca nevet: ");
			String utca = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott hazszamot: ");
			int hazszam = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott tipus adatot: ");
			String tipus = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott gy�rt� nevet: ");
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
				System.out.println("M�dosit�s megt�rt�nt\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void szereloMododitas(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="UPDATE `szerelo` SET `nev` = ?, `javitas_hat�rido` = ?, `telepkulcs` = ? WHERE `szerelo`.`szerelokulcs` = ?;";
			System.out.println("K�rem adja meg hanyas sz�m� adatsort modositan�: ");
			int szerelokulcs = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott szerel� nevet: ");
			String nev = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott javitsi hat�rid�t: ");
			String javitas_hat�rido = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott telephely sz�mot: ");
			int telepkulcs = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, nev);
				ps.setString(2, javitas_hat�rido);
				ps.setInt(3, telepkulcs);
				ps.setInt(4, szerelokulcs);
				ps.executeUpdate();
				ps.close();
				System.out.println("M�dosit�s megt�rt�nt\n");
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
			System.out.println("K�rem adja meg hanyas sz�m� adatsort modositan�: ");
			int telepkulcs = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott telefonsz�mot: ");
			String telefonszam = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott �r�nyit�sz�mot: ");
			int irszam = sc.nextInt();
			System.out.println("K�rem adja meg a modos�tott v�ros nevet: ");
			String varos = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott utca nevet: ");
			String utca = sc.next().trim();
			System.out.println("K�rem adja meg a modos�tott hazszamot: ");
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
				System.out.println("M�dosit�s megt�rt�nt\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

}
