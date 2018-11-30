package controller.acoes.relatorio;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Despesa;
import model.Renda;
import persistence.relatorio.RelatorioDao;

public class RelatoriosController {
	
	private JTable table;
	
	public RelatoriosController(JTable table) {
		this.setTable(table);
	}

	public void tableRenda() {
		if(table != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			if(model.getRowCount()>0) {
				model.setRowCount(0);
			}
			try {
				RelatorioDao rDao = new RelatorioDao();
				List<Renda> listRenda= rDao.GerarRelatorioRenda();
				for (Renda renda : listRenda) {
					Object[] linha = new Object[3];
					linha[0] = renda.getValor();
					linha[1] = renda.getDescricao();
					linha[2] = renda.getData();
					model.addRow(linha);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void tableDespesa() {
		if(table != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
//			System.out.println(model.getColumnCount());
			if(model.getRowCount()>0) {
				model.setRowCount(0);
			}
			try {
				RelatorioDao rDao = new RelatorioDao();
				List<Despesa> listDespesa = rDao.GerarRelatorioDespesa();
				for (Despesa despesa : listDespesa) {
					Object[] linha = new Object[5];
					linha[0] = despesa.getValor();
					linha[1] = despesa.getDescricao();
					linha[2] = despesa.getData();
					linha[3] = despesa.getParcela() > 0 ? despesa.getParcela() : 0;
					linha[4] = despesa.getParcela() > 0 ? despesa.getValor()/despesa.getParcela() : 0;
					model.addRow(linha);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
			this.table = table;
	}

}
