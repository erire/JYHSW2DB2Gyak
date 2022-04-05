package jyhsw2db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Kurzor implements mku {
	private static Scanner sc = new Scanner(System.in);
	private static ResultSet rs;
	private static Statement s = null;
	@Override
	public void ModosithatoKurzor(Connection connect) {
		Connection conn = connect;
		System.out.println("Adja meg a mérö eszköz városát: ");
		String varos = sc.next().trim();
		String sqlp = "select magassag from meroeszkoz where varos= '"+ varos +"'";
		if(conn != null) {
			try {
				s=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
				rs = s.executeQuery(sqlp);
				while(rs.next()) {
					int regimagassag = rs.getInt("magassag");
					rs.updateInt("magassag", (regimagassag+1));
					rs.updateRow();
				}
				System.out.println(varos+" városban feljebb rakták a szenzorokat");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}	
	}

	}


