package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.acoes.main.MainController;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3709488714422742419L;
	private JPanel contentPane;
	private JTextField txtSaldo;
	private JTextField txtLimite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setType(Type.UTILITY);
		setTitle("Controle de Finan\u00E7as");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblControleFinanas = new JLabel("Controle de Finan\u00E7as");
		lblControleFinanas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblControleFinanas.setBounds(118, 11, 190, 34);
		contentPane.add(lblControleFinanas);

		JLabel lblSaldo = new JLabel("Saldo :");
		lblSaldo.setBounds(10, 64, 46, 14);
		contentPane.add(lblSaldo);

		txtSaldo = new JTextField();
		txtSaldo.setEditable(false);
		txtSaldo.setBounds(54, 61, 79, 20);
		contentPane.add(txtSaldo);
		txtSaldo.setColumns(10);

		JLabel lblLimitePGasto = new JLabel("Limite p/ Gasto :");
		lblLimitePGasto.setBounds(160, 64, 90, 14);
		contentPane.add(lblLimitePGasto);

		txtLimite = new JTextField();
		txtLimite.setEditable(false);
		txtLimite.setBounds(259, 61, 133, 20);
		contentPane.add(txtLimite);
		txtLimite.setColumns(10);
		

		MainController mController = new MainController(txtSaldo, txtLimite);
		
		JButton btnDespesa = new JButton("Despesa");
		btnDespesa.setBounds(10, 89, 166, 75);
		contentPane.add(btnDespesa);
		btnDespesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Despesa despesa = new Despesa(mController);
				despesa.setVisible(true);
			}
		});
		
		JButton btnRenda = new JButton("Renda");
		btnRenda.setBounds(226, 89, 166, 75);
		contentPane.add(btnRenda);
		btnRenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Renda renda = new Renda(mController);
				renda.setVisible(true);
			}
		});
		
		JButton btnRelatorio = new JButton("Relat\u00F3rio");
		btnRelatorio.setBounds(10, 175, 382, 75);
		contentPane.add(btnRelatorio);
		btnRelatorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Relatorios relatorio = new Relatorios();
				relatorio.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 402, 214);
		contentPane.add(separator);

		// TestConnection test = new TestConnection();
		// test.testConnection();

	}
}
