package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Back implements ActionListener {

	private JFrame tela;
	
	public Back(JFrame tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
	}

}
