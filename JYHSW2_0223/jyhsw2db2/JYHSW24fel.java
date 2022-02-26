package jyhsw2db2;

public class JYHSW24fel {
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
