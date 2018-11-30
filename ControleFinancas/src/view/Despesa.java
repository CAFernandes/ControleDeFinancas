package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
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
	private JTextField txtParcelas;
	private JTextField txtTotal;

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
		lblDescrio.setBounds(10, 121, 65, 14);
		contentPane.add(lblDescrio);

		JLabel lblDespesa = new JLabel("Despesa :");
		lblDespesa.setBounds(10, 59, 65, 17);
		contentPane.add(lblDespesa);

		JLabel lblData = new JLabel("Data :");
		lblData.setBounds(203, 60, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblParcela = new JLabel("Parcelas:");
		lblParcela.setBounds(10, 96, 65, 14);
		contentPane.add(lblParcela);
		
		JLabel lblTotalParcelas = new JLabel("Total Parcelas:");
		lblTotalParcelas.setBounds(203, 96, 109, 14);
		contentPane.add(lblTotalParcelas);

		
		txtDespesa = new JTextField();
		txtDespesa.setToolTipText("Neste campo informe a sua despesa");
		txtDespesa.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespesa.setBounds(76, 62, 119, 20);
		txtDespesa.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				int parcela = txtParcelas.getText().isEmpty() ?  1 : Integer.parseInt(txtParcelas.getText());
				txtTotal.setText(String.valueOf(parcela == 1 ? txtDespesa.getText(): Float.parseFloat(txtDespesa.getText())/parcela ));
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		contentPane.add(txtDespesa);
		txtDespesa.setColumns(10);

		txtData = new JTextField();
		txtData.setToolTipText("Data gerada automaticamente pelo sistema");
		txtData.setForeground(Color.CYAN);
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setEnabled(false);
		txtData.setEditable(false);
		txtData.setBounds(259, 62, 165, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		try {
			RendaDao rDao = new RendaDao();
			txtData.setText(rDao.consultaData());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		txtParcelas = new JTextField();
		txtParcelas.setToolTipText("Em quantas vezes ser\u00E1 feito o pagamento");
		txtParcelas.setHorizontalAlignment(SwingConstants.CENTER);
		txtParcelas.setBounds(76, 93, 119, 20);
		txtParcelas.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				

			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				int parcela = txtParcelas.getText().isEmpty() ?  1 : Integer.parseInt(txtParcelas.getText());
				txtTotal.setText(String.valueOf(txtDespesa.getText().isEmpty() ? 0
						: Float.parseFloat(txtDespesa.getText())/parcela));
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		contentPane.add(txtParcelas);
		txtParcelas.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setEnabled(false);
		txtTotal.setEditable(false);
		txtTotal.setBounds(309, 90, 115, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JTextPane txtDesc = new JTextPane();
		txtDesc.setToolTipText("Adicione uma descri\u00E7\u00E3o para relembrar sua Despesa");
		txtDesc.setBounds(76, 121, 348, 90);
		contentPane.add(txtDesc);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(76, 227, 89, 23);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new Back(this));

		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		btnSalvar.addActionListener(new SalvarDespesa(txtDespesa, txtDesc, txtData, txtParcelas, mController));
		
//		JButton btnCalcularParcelas = new JButton("Calcular Parcelas");
//		btnCalcularParcelas.setBounds(183, 227, 137, 23);
//		btnCalcularParcelas.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int parcela = txtParcelas.getText().isEmpty() ?  0 : Integer.parseInt(txtParcelas.getText());
//				txtTotal.setText(String.valueOf(txtDespesa.getText().isEmpty() ? 1 
//						: Integer.parseInt(txtDespesa.getText())/parcela));
//			}
//		});
//		contentPane.add(btnCalcularParcelas);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 434, 166);
		contentPane.add(separator);
	}
}
