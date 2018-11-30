package controller.acoes.despesa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.acoes.main.MainController;
import model.Despesa;
import persistence.despesa.DespesaDao;

public class SalvarDespesa implements ActionListener {

	JTextField txtDespesa, txtData, txtParcelas;
	JTextPane txtDesc;
	MainController mController;

	public SalvarDespesa(JTextField txtDespesa, JTextPane txtDesc, JTextField txtData, JTextField txtParcelas, MainController mController) {
		this.txtDespesa = txtDespesa;
		this.txtData = txtData;
		this.txtDesc = txtDesc;
		this.txtParcelas = txtParcelas;
		this.mController = mController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Despesa despesa = new Despesa();
		despesa = novo();
		try {
			DespesaDao dDao = new DespesaDao();
			dDao.salvar(despesa);
			JOptionPane.showMessageDialog(null, "Despesa Registrada", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			limpaCampos();
			mController.atualiza();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
			System.err.println(e.getMessage());
		}
	}

	private void limpaCampos() {
		txtDesc.setText("");
		txtDespesa.setText("");
		txtParcelas.setText("");
		
	}

	private Despesa novo() {
		Despesa despesa = new Despesa();
		despesa.setValor(Float.parseFloat(txtDespesa.getText()));
		despesa.setData(txtData.getText());
		despesa.setDescricao(txtDesc.getText());
		despesa.setParcela(txtParcelas.getText().isEmpty() ? 0 : Integer.parseInt(txtParcelas.getText()) );
		return despesa;
	}

}
