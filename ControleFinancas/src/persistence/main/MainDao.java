package persistence.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.GenericDao;
import persistence.iGenericDao;

public class MainDao implements iMainDao{
	private Connection connection;

	public MainDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
	}
	
	@Override
	public float consultaSaldo() throws SQLException {
		float valor = 0;
		String sql = "SELECT CASE WHEN (positivo IS NOT NULL) " + 
				"THEN CASE WHEN (negativo IS NOT NULL) THEN positivo - negativo " + 
				"ELSE positivo END ELSE 0.0 END AS saldo " + 
				"FROM (SELECT SUM(renda.valor) AS positivo FROM renda)renda, (SELECT SUM(despesa.valor) AS negativo FROM despesa)despesa";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			valor = rs.getFloat("saldo");
		}
		rs.close();
		ps.close();
		return valor;
	}

	@Override
	public float consultaLimite() throws SQLException {
		float valor = 0;
		String sql = "SELECT CASE WHEN (positivo IS NOT NULL) " + 
				"THEN CASE WHEN (negativo IS NOT NULL) THEN positivo - negativo " + 
				"ELSE positivo END ELSE 0.0 END AS saldo " + 
				"FROM (SELECT SUM(renda.valor) AS positivo FROM renda)renda, (SELECT SUM(despesa.valor) AS negativo FROM despesa)despesa";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			valor = rs.getFloat("saldo");
		}
		rs.close();
		ps.close();
		valor = valor/10;
		return valor;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
