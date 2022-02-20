public class JYHSW22fel {
	public void DriverReg() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sikeres driver regisztrálás\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	};

	public void Connect() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@193.6.5.58:1521:XE";
		String user = "H22_JYHSW2";
		String pwd = "JYHSW2";
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Sikeres Kapcsolodás\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void LeKapcs() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Sikeres lekapcsolodás\\n");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
