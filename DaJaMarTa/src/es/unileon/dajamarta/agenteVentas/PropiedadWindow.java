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
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class PropiedadWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static PropiedadWindow instance; // Singleton
	private ControlerPropiedadWindow listener;
	
	private PropiedadWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(894, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerPropiedadWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		JButton btnNewButton = new JButton("Reservar propiedad(abrir alerta, si se reserva ningun vendedor podr\u00E1 reservar ni vender)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(374, 379, 474, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(307, 24, 78, 14);
		panel.add(lblNewLabel);
		
		URL img = null;
		try {
			img = new URL("https://www.realia.es/uploads/sizes/blog/blog/2019/comprar-casa-o-piso.jpg");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
		}
		ImageIcon image = new ImageIcon(img);
		JLabel lblNewLabel_1 = new JLabel("", image, JLabel.CENTER);
		lblNewLabel_1.setBounds(10, 11, 287, 277);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("", image, JLabel.CENTER);
		panel.add( label, BorderLayout.CENTER );
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(307, 75, 138, 14);
		panel.add(lblNewLabel_2);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static PropiedadWindow getInstance(){

		if (instance == null) {
			try {
				instance = new PropiedadWindow();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		JButton registerButton = new JButton("Marcar como vendida (Inserta datos de comprador)");
		registerButton.addKeyListener(listener);
		registerButton.addActionListener(listener);
		registerButton.setBounds(30, 377, 287, 38);
		panel.add(registerButton);
	}
}