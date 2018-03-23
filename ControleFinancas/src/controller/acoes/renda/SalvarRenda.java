package controller.acoes.renda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.acoes.main.MainController;
import model.Renda;
import persistence.renda.RendaDao;

public class SalvarRenda implements ActionListener {
	JTextField txtRenda, txtData;
	JTextPane txtDesc;
	MainController mController;

	public SalvarRenda(JTextField txtRenda, JTextPane txtDesc, JTextField txtData, MainController mController) {
		this.txtRenda = txtRenda;
		this.txtDesc = txtDesc;
		this.txtData = txtData;
		this.mController = mController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Renda renda = new Renda();
		renda = novo();
		try {
			RendaDao rDao = new RendaDao();
			rDao.salvar(renda);
			limpaCampos();
			JOptionPane.showMessageDialog(null, "Renda Registrada", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			mController.actionPerformed(null);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private Renda novo() {
		Renda novo = new Renda();
		novo.setValor(Float.parseFloat(txtRenda.getText()));
		novo.setData(txtData.getText());
		novo.setDescricao(txtDesc.getText());
		return novo;
	}
	
	private void limpaCampos() {
		txtDesc.setText("");
		txtRenda.setText("");
	}
}
