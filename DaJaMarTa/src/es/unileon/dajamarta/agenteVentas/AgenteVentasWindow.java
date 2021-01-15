package es.unileon.dajamarta.agenteVentas;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;

public class AgenteVentasWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static AgenteVentasWindow instance; // Singleton
	private ControlerAgenteVentasWindow listener;
	protected List list = new List();
	
	private AgenteVentasWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(918, 698);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerAgenteVentasWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		list.setBounds(32, 342, 828, 228);
		panel.add(list);
		
		JButton btnNewButton = new JButton("Ver propiedad");
		btnNewButton.addKeyListener(listener);
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(394, 590, 136, 58);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AgenteVentasWindow.class.getResource("/es/unileon/imagenes/logo.PNG")));
		lblNewLabel.setBounds(350, 32, 213, 276);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
		mntmNewMenuItem.addKeyListener(listener);
		mntmNewMenuItem.addActionListener(listener);
		mnNewMenu.add(mntmNewMenuItem);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static AgenteVentasWindow getInstance(){

		if (instance == null) {
			try {
				instance = new AgenteVentasWindow();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
	}
}
