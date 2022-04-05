package jyhsw2db2;
import java.sql.Connection;

public interface Modos {
	public void meresiAdatModositas(Connection connect);
	public void meroEszkozModositas(Connection connect);
	public void szereloMododitas(Connection connect);
	public void telephelyModositas(Connection connect);
}
