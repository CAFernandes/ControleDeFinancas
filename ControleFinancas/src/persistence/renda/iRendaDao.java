package persistence.renda;

import java.sql.SQLException;

import model.Renda;

public interface iRendaDao {
	public void salvar(Renda renda) throws SQLException;
	public String consultaData() throws SQLException;
}
