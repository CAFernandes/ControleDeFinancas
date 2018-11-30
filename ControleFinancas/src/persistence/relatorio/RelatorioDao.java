package persistence.relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Despesa;
import model.Renda;
import persistence.GenericDao;
import persistence.iGenericDao;

public class RelatorioDao implements iRelatorioDao {
	
	private Connection connection;	

	public RelatorioDao () throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
	}
	
	@Override
	public List<Despesa> GerarRelatorioDespesa() throws SQLException {
		List<Despesa> list = new ArrayList<Despesa>();
		String sql = "SELECT valor, data_despesa, descricao, parcela FROM despesa ORDER BY data_despesa ASC";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Despesa des = new Despesa();
			des.setValor(rs.getFloat("valor"));
			des.setData(rs.getString("data_despesa"));
			des.setDescricao(rs.getString("descricao"));
			des.setParcela(rs.getInt("parcela"));
			list.add(des);
		}
		return list;
	}

	@Override
	public List<Renda> GerarRelatorioRenda() throws SQLException {
		List<Renda> list = new ArrayList<Renda>();
		String sql = "SELECT valor, data_renda, descricao FROM renda ORDER BY data_renda ASC";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Renda renda = new Renda();
			renda.setValor(rs.getFloat("valor"));
			renda.setData(rs.getString("data_renda"));
			renda.setDescricao(rs.getString("descricao"));
			list.add(renda);
		}
		return list;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
