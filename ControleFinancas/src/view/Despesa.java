package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import controller.acoes.despesa.SalvarDespesa;
import controller.acoes.main.MainController;
import persistence.renda.RendaDao;

public class Despesa extends JFrame {

	private static final long serialVersionUID = 1768797018741095671L;
	private JPanel contentPane;
	private JTextField txtDespesa;
	private JTextField txtData;

	/**
	 * Create the frame.
	 */
	public Despesa(MainController mController) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Controle de Finan\u00E7as");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblControleDeFinanas = new JLabel("Controle de Despesas");
		lblControleDeFinanas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblControleDeFinanas.setBounds(112, 11, 208, 40);
		contentPane.add(lblControleDeFinanas);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio.setBounds(10, 108, 65, 14);
		contentPane.add(lblDescrio);

		JLabel lblDespesa = new JLabel("Despesa :");
		lblDespesa.setBounds(10, 84, 65, 17);
		contentPane.add(lblDespesa);

		JLabel lblData = new JLabel("Data :");
		lblData.setBounds(253, 84, 46, 14);
		contentPane.add(lblData);

		txtDespesa = new JTextField();
		txtDespesa.setBounds(76, 81, 89, 20);
		contentPane.add(txtDespesa);
		txtDespesa.setColumns(10);

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
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SalvarDespesa sDespesa = new SalvarDespesa(txtDespesa, txtDesc, txtData, mController);
				btnSalvar.addActionListener(sDespesa);
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 434, 166);
		contentPane.add(separator);
	}

}
