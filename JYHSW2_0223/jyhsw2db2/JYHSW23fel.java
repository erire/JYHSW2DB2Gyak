package jyhsw2db2;
import java.sql.Connection;
import java.sql.DriverManager;

public class JYHSW23fel {
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
}
