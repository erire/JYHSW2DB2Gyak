package jyhsw2db2;
import java.sql.Connection;

public interface felv {
	public void ujMeresiAdatok(Connection connect);
	public void ujMeröezköz(Connection connect);
	public void ujSzerelö(Connection connect);
	public void ujTelephely(Connection connect);
}
