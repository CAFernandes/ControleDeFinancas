package persistence.despesa;

import java.sql.Connection;
import java.sql.SQLException;

import model.Despesa;

public interface iDespesaDao {
	
	public void salvar(Despesa despesa) throws SQLException;
	public Connection getConnection() throws ClassNotFoundException, SQLException;
	public String consultaData() throws SQLException;
}
