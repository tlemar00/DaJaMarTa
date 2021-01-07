package es.unileon.inso.inmobiliaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 
 * @author tlemar00
 *
 */
public class AgenteVentasWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgenteVentasWindow window = new AgenteVentasWindow();
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
	public AgenteVentasWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DaJaMarta Inmobiliaria");
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		
		frame.getContentPane().setLayout(gridBagLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//Nombre del usuario va con la bbdd
		JMenu mnNewMenu = new JMenu("Tania Lema Rodríguez");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mi Perfil");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar Sesión");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		for (int i = 0; i < 1; i ++) {
			for(int j = 0; j < 8; j++) {
				
				//nombres de los usuarios va con la bbdd
				JLabel lblNewLabel = new JLabel("Propiedad");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.gridx = i;
				gbc_lblNewLabel.gridy = j;
				frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
				
				JButton btnNewButton_1 = new JButton("Modificar");
				GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
				gbc_btnNewButton_1.gridx = i+2;
				gbc_btnNewButton_1.gridy = j;
				frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
				
			}
		}
		
	}

}
