package persistence.main;

import java.sql.SQLException;

public interface iMainDao {
	public float consultaSaldo () throws SQLException;
	public float consultaLimite () throws SQLException;
}
