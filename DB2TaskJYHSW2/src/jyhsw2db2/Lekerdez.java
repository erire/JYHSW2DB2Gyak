package jyhsw2db2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Lekerdez implements lekerd {
	static Statement s = null;
	static ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	@Override
	public void meresiAdatok(Connection connect) {
		Connection conn = connect;
		if (conn != null) {
			String sqlp = "select * from meresiadatok";
			System.out.println("Mérésszáma Hömérseklet Mérés ideje Páratartalom Szállopor Kéndioxid Szénmonoxid Nitrogéndioxid Eszközszám");
			System.out.println("------------------------------------------------------------------------------------------------------");
			try {
				s=conn.createStatement();
				s.executeQuery(sqlp);
				rs = s.getResultSet();
				while(rs.next()) {
					int meresiadatkulcs = rs.getInt("meresiadatkulcs");
					int homerseklet = rs.getInt("homerseklet");
					String meres_ideje = rs.getString("meres_ideje");
					int paratartalom = rs.getInt("paratartalom");
					int szallopor = rs.getInt("szallopor");
					int kendioxid = rs.getInt("kendioxid");
					int szenmonoxid = rs.getInt("szenmonoxid");
					int nitrogéndioxid = rs.getInt("nitrogéndioxid");
					int eszkozkulcs = rs.getInt("eszkozkulcs");
					System.out.println(meresiadatkulcs+"\t\t"+homerseklet+"\t"+meres_ideje+"\t"+paratartalom+"\t     "+szallopor+"      \t"+kendioxid+"\t"+szenmonoxid+"        \t"+nitrogéndioxid+"\t   "+eszkozkulcs);
				}
				rs.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	@Override
	public void meroEszkoz(Connection connect) {
		Connection conn = connect;
		if (conn != null) {
			String sqlp = "select * from meroeszkoz";
			System.out.println("Eszközszám Gyártásidö Magasság írányitószám Város Utca  Hazszam    tipus        gyártó");
			System.out.println("------------------------------------------------------------------------------------------------------");
			try {
				s=conn.createStatement();
				s.executeQuery(sqlp);
				rs = s.getResultSet();
				while(rs.next()) {
					int eszkozkulcs = rs.getInt("eszkozkulcs");
					int gyartas_ido = rs.getInt("gyartas_ido");
					int magassag = rs.getInt("magassag");
					int irszam = rs.getInt("irszam");
					String varos = rs.getString("varos");
					String utca = rs.getString("utca");
					int hazszam = rs.getInt("hazszam");
					String tipus = rs.getString("tipus");
					String gyarto = rs.getString("gyarto");
					System.out.println(eszkozkulcs+"\t\t"+gyartas_ido+"\t"+magassag+"\t"+irszam+"\t"+varos+"\t"+utca+"\t"+hazszam+"\t"+tipus+"\t"+gyarto);
				}
				rs.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	@Override
	public void szerelo(Connection connect) {
		Connection conn = connect;
		if (conn != null) {
			String sqlp = "select * from szerelo";
			System.out.println("Szerelöszám    név         Javítási Határidö  telepszám");
			System.out.println("-----------------------------------------------------------");
			try {
				s=conn.createStatement();
				s.executeQuery(sqlp);
				rs = s.getResultSet();
				while(rs.next()) {
					int szerelokulcs = rs.getInt("szerelokulcs");
					String nev = rs.getString("nev");
					String javitas_határido = rs.getString("javitas_határido");
					int telepkulcs = rs.getInt("telepkulcs");
					System.out.println(szerelokulcs+"\t\t"+nev+"\t"+javitas_határido+"\t"+telepkulcs);
				}
				rs.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void telephely(Connection connect) {
		Connection conn = connect;
		if (conn != null) {
			String sqlp = "select * from telephely";
			System.out.println("Telepkulcs Telefonszám írányitószám Város Utca               Házszám");
			System.out.println("----------------------------------------------------------------------");
			try {
				s=conn.createStatement();
				s.executeQuery(sqlp);
				rs = s.getResultSet();
				while(rs.next()) {
					int Telepkulcs = rs.getInt("Telepkulcs");
					String telefonszam = rs.getString("telefonszam");
					int irszam = rs.getInt("irszam");
					String varos = rs.getString("varos");
					String utca = rs.getString("utca");
					int hazszam = rs.getInt("hazszam");
					System.out.println(Telepkulcs+"\t\t"+telefonszam+"\t"+irszam+"\t"+varos+"\t"+utca+"\t"+hazszam);
				}
				rs.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void eszKozMeresek(Connection connect) {
		Connection conn = connect;
		System.out.println("Kérem adja meg annak az eszköznek a számát aminek az adataik kivánja látni: ");
		int eszkozSzam = sc.nextInt();
		String sqlp = "SELECT homerseklet, meres_ideje, paratartalom, szallopor, kendioxid, szenmonoxid, nitrogéndioxid, meresiadatok.eszkozkulcs FROM meresiadatok, meroeszkoz WHERE meresiadatok.eszkozkulcs=meroeszkoz.eszkozkulcs AND meroeszkoz.eszkozkulcs = "+eszkozSzam+";";
		try {
			s=conn.createStatement();
			s.executeQuery(sqlp);
			rs = s.getResultSet();
			while(rs.next()) {
					int homerseklet = rs.getInt("homerseklet");
					String meres_ideje = rs.getString("meres_ideje");
					int paratartalom = rs.getInt("paratartalom");
					int szallopor = rs.getInt("szallopor");
					int kendioxid = rs.getInt("kendioxid");
					int szenmonoxid = rs.getInt("szenmonoxid");
					int nitrogéndioxid = rs.getInt("nitrogéndioxid");
					int eszkozkulcs = rs.getInt("meresiadatok.eszkozkulcs");
					System.out.println(homerseklet+"\t"+meres_ideje+"\t"+paratartalom+"\t     "+szallopor+"      \t"+kendioxid+"\t"+szenmonoxid+"        \t"+nitrogéndioxid+"\t   "+eszkozkulcs);
				}
			rs.close();
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
