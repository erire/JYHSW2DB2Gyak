package jyhsw2db2;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Torol implements tor {
	static Scanner sc = new Scanner(System.in);
	static Statement s = null;
	@Override
	public void meresiAdatTorles(Connection connect) {
		Connection conn = connect;
		System.out.println("Hanyas szamú adatot szeretné törölni: ");
		String rsz = sc.next();
		String sqlp = "Delete from meresiadatok where meresiadatkulcs="+rsz+"";
		if (conn != null) {
			try {
				s=conn.createStatement();
				s.executeUpdate(sqlp);
				s.close();
				System.out.println(rsz +". számu adat törölve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void eszkozAdatTorles(Connection connect) {
		Connection conn = connect;
		System.out.println("Hanyas szamú adatot szeretné törölni: ");
		String rsz = sc.next();
		String sqlp = "Delete from meresiadatok where eszkozkulcs="+rsz+"";
		String sqlp1 = "Delete from karbantartas where eszkozkulcs="+rsz+"";
		String sqlp2 = "Delete from meroeszkoz where eszkozkulcs="+rsz+"";
		if (conn != null) {
			try {
				s=conn.createStatement();
				s.executeUpdate(sqlp);
				s.executeUpdate(sqlp1);
				s.executeUpdate(sqlp2);
				s.close();
				System.out.println(rsz +". számu adat törölve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void szereloAdatTorles(Connection connect) {
		Connection conn = connect;
		System.out.println("Hanyas szamú adatot szeretné törölni: ");
		String rsz = sc.next();
		String sqlp = "Delete from szerelo where szerelokulcs="+rsz+"";
		if (conn != null) {
			try {
				s=conn.createStatement();
				s.executeUpdate(sqlp);
				s.close();
				System.out.println(rsz +". számu adat törölve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

	}

	@Override
	public void TelephelyAdatTorles(Connection connect) {
		Connection conn = connect;
		System.out.println("Hanyas szamú adatot szeretné törölni: ");
		String rsz = sc.next();
		String sqlp = "Delete from telephely where telepkulcs="+rsz+"";
		if (conn != null) {
			try {
				s=conn.createStatement();
				s.executeUpdate(sqlp);
				s.close();
				System.out.println(rsz +". számu adat törölve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	}

