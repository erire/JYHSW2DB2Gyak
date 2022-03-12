package jyhsw2db2;

import java.sql.*;
import java.util.Scanner;

public class JYHSW22fel {
	private static String user = "root";

	public void DriverReg() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Sikeres driver regisztrálás\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	};
	
	static Connection conn = null;
	static Statement s = null;
	static PreparedStatement ps = null;
	static ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	static CallableStatement cs;
	
	public static void main(String[] args) {
		Connect();
		//StatikusTablaLetrehozas();
		//StatikusTablaModosiTas();
		//StatikusTablaTorles();
		//StatikusAdatfelvetel();
		//DinamikusAdatfelvetel();
		//Hazi();
		//DinamikusAdattorles();
		//StatikusAdattorles();
		//StatikusLekerdezes();
		//ModosithatoKurzor();
		//InEljarasHivas();
		//OutEljarasHivas();
		Lekapcs();
	}
	
	
	public static void Connect() {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "";
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Sikeres kapcsolodasás\n");
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
	
	public static void StatikusTablaLetrehozas() {
		String sqlp_auto="create table auto(rsz char(6) primary key, " + "tipus char(10) not null, szin char(10) default 'feher', " +
				"evjarat int(4), ar int(8) check(ar>0));";
		String sqlp_tulaj="create table tulaj (id int(3) primary key, " + "nev char(20) not null, cim char(20), szuldatum date)";
		String sqlp_both[]= {
				"create table auto(rsz char(6) primary key, tipus char(10) not null, szin char(10) default 'feher', evjarat int(4), ar int(8) check(ar>0));",
				"create table tulaj (id int(3) primary key, nev char(20) not null, cim char(20), szuldatum date)"
		};
		if(conn!=null) {
			/*try {
				s=conn.createStatement();
				s.executeUpdate(sqlp_auto);
				System.out.println("Autó tábla létrejött\n");
				s.executeUpdate(sqlp_tulaj);
				System.out.println("Tulajdonos tábla létrejött\n");
				s.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}*/
			for(int i = 0;i < sqlp_both.length; i++) {
				try {
					s=conn.createStatement();
					s.executeUpdate(sqlp_both[i]);
					System.out.println("Autó felvive\n");
					s.close();
				}catch(Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		}
	}
	
	public static void StatikusTablaModosiTas() {
		if(conn != null) {}
		try {
			String sqlp="alter table auto ADD CONSTRAINT tulaj_id FOREIGN KEY (tulaj_id) references tulaj (id)";
			s=conn.createStatement();
			s.executeUpdate(sqlp);
			System.out.println("Autó tábla módosítva!\n");
			s.close();
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	public static void Hazi() {
		if(conn!=null) {
			/*String sqlp_all[] = {
					"SELECT * FROM `auto`",
			};
			for(int i = 0;i < sqlp_all.length; i++) {
				try {
					s=conn.createStatement();
					s.executeUpdate(sqlp_all[i]);
					System.out.println("Készen vagyok\n");
					s.close();
				}catch(Exception ex) {
					System.err.println(ex.getMessage());
				}
			}*/
			String sqlp ="SELECT * FROM `auto`";
			try {
				s=conn.createStatement();
				s.executeQuery(sqlp);
				rs = s.getResultSet();
				while(rs.next()) {
					String rsz = rs.getString("rsz");
					String tipus = rs.getString("tipus");
					String szin = rs.getString("szin");
					int evjarat = rs.getInt("evjarat");
					int ar = rs.getInt("ar");
					int tulaj_id = rs.getInt("tulaj_id");
					System.out.println(rsz+"\t\t"+tipus+"\t"+szin+"\t"+evjarat+"\t"+ar+"\t"+tulaj_id);
				}
				rs.close();
				System.out.println("Kérem a modosítandó adat azonosítóját: ");
				String rsz_kerdezett = sc.nextLine();
				System.out.println(""+rsz_kerdezett+"");
				System.out.println("Kérem az új tipust: ");
				String tipus_kerdezett = sc.nextLine();
				System.out.println(""+tipus_kerdezett+"");
				if (tipus_kerdezett != null) {
					String sqlp_tipus ="UPDATE `auto` SET `tipus`='"+tipus_kerdezett+"' Where `auto`.`rsz`='"+rsz_kerdezett+"'";
					s.executeUpdate(sqlp_tipus);
					System.out.println(""+sqlp_tipus+"");
				}
				System.out.println("Kérem az új színt: ");
				String szin_kerdezett = sc.nextLine();
				if (szin_kerdezett != null) {
					String sqlp_szin ="UPDATE `auto` SET tipus='"+szin_kerdezett+"' Where rsz='"+rsz_kerdezett+"'";
					s.executeUpdate(sqlp_szin);
				}
				/*System.out.println("Kérem az új évjáratot: ");
				String evjarat_kerdezett = sc.nextLine();
				if (evjarat_kerdezett != null) {
					String sqlp_evjarat ="UPDATE `auto` SET tipus='"+evjarat_kerdezett+"' Where rsz='"+rsz_kerdezett+"'";
					s.executeUpdate(sqlp_evjarat);
				} else {
					evjarat_kerdezett = null;
				}
				System.out.println("Kérem az új árat: ");
				String ar_kerdezett = sc.nextLine();
				if (ar_kerdezett != null) {
					String sqlp_ar ="UPDATE `auto` SET tipus='"+ar_kerdezett+"' Where rsz='"+rsz_kerdezett+"'";
					s.executeUpdate(sqlp_ar);
				} else {
					ar_kerdezett = null;
				}
				System.out.println("Kérem az új tulaj idt: ");
				String tulaj_id_kerdezett = sc.nextLine();
				if (tulaj_id_kerdezett != null) {
					String sqlp_tulaj_id ="UPDATE `auto` SET tipus='"+tulaj_id_kerdezett+"' Where rsz='"+rsz_kerdezett+"'";
					s.executeUpdate(sqlp_tulaj_id);
				} else {
					tulaj_id_kerdezett = null;
				}*/
				s.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		
	}
	public static void StatikusTablaTorles() {
		if(conn != null) {}
		try {
			String sqlp_auto="DROP TABLE auto";
			String sqlp_tulaj="DROP TABLE tulaj";
			s=conn.createStatement();
			s.executeUpdate(sqlp_auto);
			System.out.println("Autó tábla törölve!\n");
			s.executeUpdate(sqlp_tulaj);
			System.out.println("Tulajdonos tábla törölve!\n");
			s.close();
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void StatikusAdatfelvetel() {
		if(conn != null) {
			String sqlp_tul="insert into tulaj (id, nev, cim, szuldatum) values (1, 'Tóth Máté', " + "'Miskolc', to_date('1980.05.12', 'yyyy.mm.dd'))";
			String sqlp[]= {
				"insert into auto (rsz, tipus, szin, evjarat, ar) values('aaa111', 'opel', 'piros', 2014, 1650000)",
				"insert into auto (rsz, tipus, szin, evjarat, ar) values('bbb222', 'mazda', 'null', 2016, 2650000)",
				"insert into auto (rsz, tipus, evjarat, ar) values('ccc333', 'ford',2009, 1500000)"
			};
			
			/*try {
				s=conn.createStatement();
				s.executeUpdate(sqlp_tul);
				System.out.println("Tulaj felvive\n");
				s.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}*/
			
			for(int i = 0;i < sqlp.length; i++) {
				try {
					s=conn.createStatement();
					s.executeUpdate(sqlp[i]);
					System.out.println("Autó felvive\n");
					s.close();
				}catch(Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		}
	}
	
	public static void DinamikusAdatfelvetel() {
		if(conn != null) {
			String sqlp="insert into auto(rsz, tipus, szin, evjarat, ar, tulaj_id)" + "values(?,?,?,?,?,?)";
			
			System.out.println("Kérem a rendszámot: ");
			String rsz = sc.next().trim();
			System.out.println("Kérem a típust: ");
			String tipus = sc.next().trim();
			System.out.println("Kérem a színt: ");
			String szin = sc.next().trim();
			System.out.println("Kérem az évjáratot: ");
			int evjarat = sc.nextInt();
			System.out.println("Kérem az árat: ");
			float ar = sc.nextFloat();
			System.out.println("Kérem a tulajdonos azonosítóját: ");
			int tulaj_id = sc.nextInt();
			
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, rsz);
				ps.setString(2, tipus);
				ps.setString(3, szin);
				ps.setInt(4, evjarat);
				ps.setFloat(5, ar);
				ps.setInt(6, tulaj_id);
				ps.executeUpdate();
				ps.close();
				System.out.println("Autó felvéve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void DinamikusAdattorles() {
		System.out.println("Törlendo Adatok: ");
		String rsz = sc.next();
		// Az SQL parancsban a ? helyére kerülnek a paraméterek
		String sqlp = "Delete from " + user + ".Auto" + " where rsz=?";
		if (conn != null) {
			try {
				ps=conn.prepareStatement(sqlp);
				ps.setString(1, rsz);
				ps.executeUpdate();
				System.out.println(rsz +" rendszámu Autó törölve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void StatikusAdattorles() {
		System.out.println("Törlendo Adatok: ");
		String rsz = sc.next();
		String sqlp = "Delete from auto where rsz=?";
		if (conn != null) {
			try {
				s=conn.createStatement();
				s.executeUpdate(sqlp);
				System.out.println(rsz +" rendszámu Autó törölve\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void StatikusLekerdezes() {
		if (conn != null) {
			String sqlp = "select * from auto";
			System.out.println("Rendszám tipus Szín Évjárat Ár Tulaj");
			System.out.println("----------------------------------------");
			try {
				s=conn.createStatement();
				s.executeQuery(sqlp);
				rs = s.getResultSet();
				while(rs.next()) {
				// A get metódusoknak a megfelelo típusú táblamezoket kell megadni
					String rsz = rs.getString("rsz");
					String tipus = rs.getString("tipus");
					String szin = rs.getString("szin");
					int evjarat = rs.getInt("evjárat");
					int ar = rs.getInt("ar");
					int tulaj_id = rs.getInt("tulaj_id");
					System.out.println(rsz+"\t\t"+tipus+"\t"+szin+"\t"+evjarat+"\t"+ar+"\t"+tulaj_id);
				}
				rs.close();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void ModosithatoKurzor() {
		System.out.println("Szin: ");
		String szin = sc.next().trim();
		String sqlp = "select ar from auto where szin= '"+ szin +"'";
		if (conn != null) {
			try {
				s = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
				rs = s.executeQuery(sqlp);
				while (rs.next()) {
					int regiar = rs.getInt("ar");
					rs.updateInt("ar", (regiar*2));
					rs.updateRow();
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void InEljarasHivas() {
		if(conn != null) {
			try {
				String sqlp = "create or procedure arcsokkent " + "(kor IN number) is" + 
			"begin "+ "update auto set ar=ar*0.9 where"
						+"to_char (sysdate, 'yyyy' - evjarat > kor; "+ "end;";
				System.out.println("Kor: ");
				int kor  = sc.nextInt();
				s = conn.createStatement();
				s.executeUpdate(sqlp);
				System.out.println("Függvény létrejött\n");
				cs = conn.prepareCall("{call arcsokkent(?)}");
				cs.setInt(1, kor);
				cs.execute();
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void OutEljarasHivas() {
		if(conn != null) {
			try {
				String sqlp = "create or procedure atlagar " + "(sz IN char, atl OUT number) is " + 
			"begin "+ "select avg(ar) into atl from auto where szin = sz; "
						+"end;";
				System.out.println("Szín: ");
				String szin  = sc.next();
				s = conn.createStatement();
				s.executeUpdate(sqlp);
				System.out.println("Eljárás létrejött\n");
				cs = conn.prepareCall("{call atlagar(?, ?)}");
				cs.setString(1, szin);
				cs.registerOutParameter(2, java.sql.Types.FLOAT);
				cs.execute();
				float atlag = cs.getFloat(2);
				System.out.println(szin  + "autók átlagára: "+atlag+"\n");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
}
