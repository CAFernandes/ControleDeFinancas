package controller.acoes.relatorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RadioButtonController implements ActionListener {

	JRadioButton rdbtnRenda, rdbtnDespesa;
	JTable tblRenda, tblDespesa;
	JScrollPane scrollPane;
	
	public RadioButtonController(JRadioButton rdbtnRenda, JRadioButton rdbtnDespesa, JTable tblRenda, JTable tblDespesa, JScrollPane scrollPane) {
		this.rdbtnRenda = rdbtnRenda;
		this.rdbtnDespesa = rdbtnDespesa;
		this.tblRenda = tblRenda;
		this.tblDespesa = tblDespesa;
		this.scrollPane = scrollPane;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (rdbtnRenda.isSelected()) {
			scrollPane.setViewportView(tblRenda);
			RelatoriosController rController = new RelatoriosController(tblRenda);
 			rController.tableRenda();
		}else {
			scrollPane.setViewportView(tblDespesa);
			RelatoriosController rController = new RelatoriosController(tblDespesa);
 			rController.tableDespesa();
		}
	}
}
