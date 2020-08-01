package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class MenuGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI window = new MenuGUI();
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
	public MenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Gerenciador de Condominio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JLabel lblStatusMenu = new JLabel("Status: Menu");
		frame.getContentPane().add(lblStatusMenu, BorderLayout.SOUTH);
		
		JMenu mnNovo = new JMenu("Receita");
		mnNovo.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				ReceitaGUI.run();
			}
		});
		menuBar.add(mnNovo);
		
		JMenu mnRelatorio = new JMenu("Relat\u00F3rio");
		mnRelatorio.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				RelatorioGUI.run();
			}
		});

		menuBar.add(mnRelatorio);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mnSair);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
	}
}
