package persistence.renda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Renda;
import persistence.GenericDao;
import persistence.iGenericDao;

public class RendaDao implements iRendaDao{

	private Connection connection;
	
	public RendaDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
	}
	
	@Override
	public void salvar(Renda renda) throws SQLException {
		String sql = "INSERT INTO renda (valor, data_renda, descricao) VALUES(?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setFloat(1, renda.getValor());
		ps.setString(2, renda.getData());
		ps.setString(3, renda.getDescricao());
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
