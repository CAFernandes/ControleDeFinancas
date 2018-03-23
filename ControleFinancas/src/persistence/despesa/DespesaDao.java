package persistence.despesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Despesa;
import persistence.GenericDao;
import persistence.iGenericDao;

public class DespesaDao implements iDespesaDao {

	private Connection connection;
	
	public DespesaDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
	}
	
	@Override
	public void salvar(Despesa despesa) throws SQLException {
		String sql = "INSERT INTO despesa (valor, data_despesa, descricao) VALUES(?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setFloat(1, despesa.getValor());
		ps.setString(2, despesa.getData());
		ps.setString(3, despesa.getDescricao());
		ps.execute();
		ps.close();
	}
	
	public String consultaData() throws SQLException{
		String sql = "SELECT CONVERT(VARCHAR(10), GETDATE(), 103) AS data_atual";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getString("data_atual");
		}else {
			return "erro";
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
