package jyhsw2db2;

public class JYHSW22fel {
	public void DriverReg() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sikeres driver regisztrálás\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	};
	public void StatikusTablaLetrehozas() {
		String sqlp_auto = "create table auto ( rsz char(6) primary key, " + 
					"tipus char(10) not null, szin char(10) default 'fehér', " +
					"evjarat number(4), ar number(8) check(ar>0) )";
		if (conn != null) {
			try {
				s = conn.createStatement();
				s.executeUpdate(sqlp_auto);
				System.out.println("Autó tábla létrejött\n");
				s.executeUpdate(sqlp_tulaj);
				System.out.println("Tulajdonos tábla létrejött\n");
				s.close();
			} catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	public void StatikusTablaModositas() {
		if (conn != null) {
			String sqlp_tul = "Insert into tulaj values(1, 'Tóth Máté', " +
						" 'Miskolc' , to_date('1980.05.12', 'yyyy.mm.dd'))";
			String[] sqlp = {
					"insert into auto values('aaa111','opel','piros',2014,1650000, 1)",
					"insert into auto values('bbb222','mazda',null,2016,2800000, 1)",
					"insert into auto (rsz, tipus, evjarat, ar) values('ccc333','ford',2009,1500000)",
			};
			try {
				s = conn.createStatement();
				s.executeUpdate(sqlp_tul);
				System.out.println("Tulaj felvéve\n");
				s.close();
			} catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
			for (int i=0; i<sqlp.length; i++) {
				try {
					s = conn.createStatement();
					s.executeUpdate(sqlp[i]);
					System.out.println("Autó felvéve\n");
					s.close();
				} catch(Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		}
	}
	public void DinamikusAdatfelvitel() {
		if (conn != null) {
			String sqlp = "insert into auto (rsz, tipus, szin, evjarat, ar, tulaj_id)" +
					"values (?, ?, ?, ?, ?, ?)";
		}
	}
}
