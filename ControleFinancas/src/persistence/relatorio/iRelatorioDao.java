package persistence.relatorio;

import java.sql.SQLException;
import java.util.List;

import model.Despesa;
import model.Renda;

public interface iRelatorioDao {

	public List<Despesa> GerarRelatorioDespesa () throws ClassNotFoundException, SQLException ;
	public List<Renda> GerarRelatorioRenda () throws ClassNotFoundException, SQLException ;
	
}
