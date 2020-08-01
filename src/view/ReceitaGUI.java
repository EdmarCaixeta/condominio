package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;

import model.bean.Receita;
import model.dao.DespesasDAO;
import model.dao.RendaDAO;

import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ReceitaGUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceitaGUI window = new ReceitaGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReceitaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Calendar data = Calendar.getInstance();
		frame = new JFrame();
		frame.setBounds(100, 100, 456, 309);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Nova Receita");
		frame.getContentPane().setLayout(null);

		JButton btnOK = new JButton("OK");
		btnOK.setBounds(16, 243, 80, 23);
		frame.getContentPane().add(btnOK);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(335, 243, 89, 23);
		frame.getContentPane().add(btnCancelar);

		JRadioButton rdbtnDespesas = new JRadioButton("Despesas");
		buttonGroup.add(rdbtnDespesas);
		rdbtnDespesas.setBounds(143, 11, 89, 23);
		frame.getContentPane().add(rdbtnDespesas);

		JRadioButton rdbtnRenda = new JRadioButton("Renda");
		buttonGroup.add(rdbtnRenda);
		rdbtnRenda.setSelected(true);
		rdbtnRenda.setBounds(294, 11, 80, 23);
		frame.getContentPane().add(rdbtnRenda);

		JLabel lblLabel = new JLabel("Tipo de Receita:");
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLabel.setBounds(16, 9, 119, 23);
		frame.getContentPane().add(lblLabel);

		JTextArea txtrDescrio = new JTextArea();
		txtrDescrio.setWrapStyleWord(true);
		txtrDescrio.setLineWrap(true);

		JScrollPane scroll = new JScrollPane(txtrDescrio);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(16, 112, 408, 120);
		txtrDescrio.setBounds(16, 66, 408, 120);
		frame.getContentPane().add(scroll);

		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(16, 79, 80, 39);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(72, 45, 228, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Valor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(16, 47, 46, 21);
		frame.getContentPane().add(lblNewLabel_1);

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.add(0, "�ltimos 15 dias");
		listModel.add(1, "�ltimos 30 dias");
		listModel.add(2, "�ltimos 6 meses");
		listModel.add(3, "�ltimo ano");

		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Receita receita = new Receita();
				receita.setValor(textField.getText());
				receita.setMes(data.get(Calendar.MONTH) + 1);
				receita.setAno(data.get(Calendar.YEAR));
				receita.setDescricao(txtrDescrio.getText());
				
				if(rdbtnDespesas.isSelected()) {
					DespesasDAO despesa = new DespesasDAO();
					despesa.create(receita);
				}
				
				else if(rdbtnRenda.isSelected()) {
					RendaDAO renda = new RendaDAO();
					renda.create(receita);
				}

 				frame.dispose();
			}
		});
	}
}
