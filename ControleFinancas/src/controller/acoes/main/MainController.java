package controller.acoes.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.JTextField;

import persistence.main.MainDao;

public class MainController implements ActionListener {
	JTextField txtSaldo, txtLimite;
	MainController mController = this;

	public MainController(JTextField txtSaldo, JTextField txtLimite) {
		this.txtSaldo = txtSaldo;
		this.txtLimite = txtLimite;
		atualiza();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		atualiza();
	}
	
	public void atualiza(){
		try {
			NumberFormat F = NumberFormat.getCurrencyInstance();
			MainDao mDao = new MainDao();
			txtSaldo.setText(String.valueOf(F.format(mDao.consultaSaldo())));
			txtLimite.setText(String.valueOf(F.format(mDao.consultaLimite())));
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);//e.printStackTrace();
		}
	}
}