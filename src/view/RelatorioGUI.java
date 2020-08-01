package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;

public class RelatorioGUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioGUI window = new RelatorioGUI();
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
	public RelatorioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Relat�rio Fiscal");
		frame.getContentPane().setLayout(null);
		
		JButton btnGerarRelatorio = new JButton("Gerar");
		btnGerarRelatorio.setBounds(74, 197, 89, 23);
		frame.getContentPane().add(btnGerarRelatorio);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(285, 197, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		JRadioButton rdbtnDespesas = new JRadioButton("Despesas");
		buttonGroup.add(rdbtnDespesas);
		rdbtnDespesas.setBounds(190, 11, 89, 23);
		frame.getContentPane().add(rdbtnDespesas);
		
		JRadioButton rdbtnRenda = new JRadioButton("Renda");
		buttonGroup.add(rdbtnRenda);
		rdbtnRenda.setBounds(294, 11, 80, 23);
		frame.getContentPane().add(rdbtnRenda);
		
		JRadioButton rdbtnAmbos = new JRadioButton("Ambos");
		buttonGroup.add(rdbtnAmbos);
		rdbtnAmbos.setBounds(117, 11, 71, 23);
		frame.getContentPane().add(rdbtnAmbos);
		
		JLabel lblLabel = new JLabel("Tipo de relat\u00F3rio:");
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLabel.setBounds(6, 11, 119, 23);
		frame.getContentPane().add(lblLabel);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPerodo.setBounds(6, 67, 119, 23);
		frame.getContentPane().add(lblPerodo);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(74, 72, 298, 107);
		frame.getContentPane().add(list);
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.add(0, "�ltimos 15 dias");
		listModel.add(1, "�ltimos 30 dias");
		listModel.add(2, "�ltimos 6 meses");
		listModel.add(3, "�ltimo ano");
		list.setModel(listModel);
	}

}
