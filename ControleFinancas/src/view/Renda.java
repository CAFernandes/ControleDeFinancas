package view;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controller.Back;
import controller.acoes.main.MainController;
import controller.acoes.renda.SalvarRenda;
import persistence.renda.RendaDao;

public class Renda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1212458251045123330L;
	private JPanel contentPane;
	private JTextField txtRenda;
	private JTextField txtData;

	/**
	 * Create the frame.
	 */
	public Renda(MainController mController) {
		setType(Type.UTILITY);
		setTitle("Controle de Finan\u00E7as");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblControleDeFinanas = new JLabel("Controle de Renda");
		lblControleDeFinanas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblControleDeFinanas.setBounds(127, 11, 172, 39);
		contentPane.add(lblControleDeFinanas);

		txtRenda = new JTextField();
		txtRenda.setBounds(76, 81, 89, 20);
		contentPane.add(txtRenda);
		txtRenda.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio.setBounds(10, 108, 65, 14);
		contentPane.add(lblDescrio);

		JLabel lblRenda = new JLabel("Renda :");
		lblRenda.setBounds(10, 84, 46, 14);
		contentPane.add(lblRenda);

		JLabel lblData = new JLabel("Data :");
		lblData.setBounds(253, 84, 46, 14);
		contentPane.add(lblData);

		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(309, 81, 115, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		try {
			RendaDao rDao = new RendaDao();
			txtData.setText(rDao.consultaData());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		JTextPane txtDesc = new JTextPane();
		txtDesc.setBounds(76, 112, 348, 99);
		contentPane.add(txtDesc);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(76, 227, 89, 23);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new Back(this));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		SalvarRenda sRenda = new SalvarRenda(txtRenda, txtDesc, txtData, mController);
		btnSalvar.addActionListener(sRenda);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 434, 166);
		contentPane.add(separator);

	}
}
