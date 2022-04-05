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
			String sqlp="insert into meresiadatok(homerseklet, meres_ideje, paratartalom, szallopor, kendioxid, szenmonoxid, nitrog�ndioxid, eszkozkulcs)" + "values(?,?,?,?,?,?,?,?)";
			
			System.out.println("K�rem a h�m�rs�klet adatot: ");
			int homerseklet = sc.nextInt();
			System.out.println("K�rem a m�r�s idej�t: ");
			String meres_ideje = sc.next().trim();
			System.out.println("K�rem a p�ratartalom adatot: ");
			int paratartalom = sc.nextInt();
			System.out.println("K�rem a sz�ll�por adatot: ");
			int szallopor = sc.nextInt();
			System.out.println("K�rem a k�ndioxid adatot: ");
			int kendioxid = sc.nextInt();
			System.out.println("K�rem a sz�nmonoxid adatot: ");
			int szenmonoxid = sc.nextInt();
			System.out.println("K�rem az nitrog�ndioxid adatot: ");
			int nitrog�ndioxid = sc.nextInt();
			System.out.println("K�rem a m�r�ezk�z sz�mot: ");
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
				ps.executeUpdate();
				ps.close();
				System.out.println("�j m�r�si adatok felv�ve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void ujMer�ezk�z(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="insert into meroeszkoz(gyartas_ido, magassag, irszam, varos, utca, hazszam, tipus, gyarto)" + "values(?,?,?,?,?,?,?,?)";
			
			System.out.println("K�rem adja meg az eszk�z tipust: ");
			String tipus = sc.next().trim();
			System.out.println("K�rem adja meg a gy�rt� nev�t: ");
			String gyarto = sc.next().trim();
			System.out.println("K�rem adja meg gy�rt�si id�t: ");
			int gyartas_ido = sc.nextInt();
			System.out.println("K�rem adja meg h�ny m�ter magassan helyezkedik el az eszk�z: ");
			int magassag = sc.nextInt();
			System.out.println("K�rem adja meg az ir�nyit� sz�mot: ");
			int irszam = sc.nextInt();
			System.out.println("K�rem adja meg a v�ros nev�t: ");
			String varos = sc.next().trim();
			System.out.println("K�rem adja meg az utca nev�t: ");
			String utca = sc.next().trim();
			System.out.println("K�rem adja meg a h�zsz�mot: ");
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
				System.out.println("�j eszk�z adatok felv�ve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void ujSzerel�(Connection connect) {
		Connection conn = connect;
		if(conn != null) {
			String sqlp="insert into szerelo(nev, javitas_hat�rido, telepkulcs)" + "values(?,?,?)";
			
			System.out.println("K�rem adja meg a szerel� nev�t: ");
			String nev = sc.next().trim();
			System.out.println("K�rem adja meg a jav�t�si hat�rid�t: ");
			String javitas_hat�rido = sc.next().trim();
			System.out.println("K�rem adja meg a telephely sz�m�t");
			int telepkulcs = sc.nextInt();
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, nev);
				ps.setString(2, javitas_hat�rido);
				ps.setInt(3, telepkulcs);
				ps.executeUpdate();
				ps.close();
				System.out.println("�j szerelo adatok felv�ve\n");
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
			
			System.out.println("K�rem adja meg a telefonsz�mot: ");
			String telefonszam = sc.next().trim();
			System.out.println("K�rem adja meg a ir�nyit� sz�mot: ");
			int irszam = sc.nextInt();
			System.out.println("K�rem adja meg a v�rost: ");
			String varos = sc.next().trim();
			System.out.println("K�rem adja meg az Utc�t: ");
			String utca = sc.next().trim();
			System.out.println("K�rem adja meg a h�zsz�mot: ");
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
				System.out.println("�j telephely adatok felv�ve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

}
