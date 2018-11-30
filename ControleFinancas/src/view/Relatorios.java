package view;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Back;
import controller.acoes.relatorio.RadioButtonController;
import controller.acoes.relatorio.RelatoriosController;

public class Relatorios extends JFrame {

	private static final long serialVersionUID = -1555120355275909524L;
	private JPanel contentPane;
	private JTable tblRenda, tblDespesa;

	public Relatorios() {
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

		/* rdbtn Group */
		JRadioButton rdbtnRenda = new JRadioButton("Renda\r\n");
		rdbtnRenda.setSelected(true);
		rdbtnRenda.setBounds(5, 59, 109, 23);
		contentPane.add(rdbtnRenda);

		JRadioButton rdbtnDespesas = new JRadioButton("Despesas");
		rdbtnDespesas.setBounds(319, 59, 109, 23);
		contentPane.add(rdbtnDespesas);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnRenda);
		group.add(rdbtnDespesas);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 227, 89, 23);
		contentPane.add(btnVoltar);

		btnVoltar.addActionListener(new Back(this));

		DefaultTableModel modelRenda = new DefaultTableModel(new Object[][] {},
				new String[] { "Valor", "Descri\u00E7\u00E3o", "Data" });

		DefaultTableModel modelDespesa = new DefaultTableModel(new Object[][] {},
				new String[] { "Valor", "Descri\u00E7\u00E3o", "Data", "Parcelas", "Valor Parcela" });

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 89, 419, 130);
		contentPane.add(scrollPane);
		scrollPane.setVisible(true);

		tblDespesa = new JTable();
		tblDespesa.setModel(modelDespesa);
		tblDespesa.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblDespesa.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblDespesa.getColumnModel().getColumn(2).setPreferredWidth(120);
		tblDespesa.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblDespesa.getColumnModel().getColumn(4).setPreferredWidth(180);
		scrollPane.setViewportView(tblDespesa);

		tblRenda = new JTable();
		tblRenda.setModel(modelRenda);
		tblRenda.getColumnModel().getColumn(0).setPreferredWidth(164);
		tblRenda.getColumnModel().getColumn(1).setPreferredWidth(337);
		tblRenda.getColumnModel().getColumn(2).setPreferredWidth(121);
		scrollPane.setViewportView(tblRenda);

		RelatoriosController rController = new RelatoriosController(tblRenda);
		rController.tableRenda();
		
		RadioButtonController rdbtnController = new RadioButtonController(rdbtnRenda, rdbtnDespesas, tblRenda,
				tblDespesa, scrollPane);
		rdbtnRenda.addActionListener(rdbtnController);
		rdbtnDespesas.addActionListener(rdbtnController);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 434, 166);
		contentPane.add(separator);

	}
}
