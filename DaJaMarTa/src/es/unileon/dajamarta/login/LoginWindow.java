package es.unileon.dajamarta.login;

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

public class LoginWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static LoginWindow instance; // Singleton
	private ControlerLoginWindow listener;
	protected JTextField userText = new JTextField(20);
	
	private LoginWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(1022, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerLoginWindow(this);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\git\\DaJaMarTa\\img\\logo.PNG"));
		lblNewLabel.setBounds(546, 92, 212, 277);
		panel.add(lblNewLabel);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static LoginWindow getInstance(){

		if (instance == null) {
			try {
				instance = new LoginWindow();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("Usuario");
		userLabel.setBounds(70, 62, 80, 25);
		panel.add(userLabel);
		
		//userText = new HintTextField("USUARIO",55);
		//JTextField userText = new JTextField(20);
		userText.setBounds(277, 62, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Contrase\u00F1a");
		passwordLabel.setBounds(70, 178, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(277, 178, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("Login");
		loginButton.addKeyListener(listener);
		loginButton.addActionListener(listener);
		loginButton.setBounds(90, 268, 86, 50);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("Registro");
		registerButton.addKeyListener(listener);
		registerButton.addActionListener(listener);
		registerButton.setBounds(277, 268, 93, 50);
		panel.add(registerButton);
		
		JButton abrirAdmin = new JButton("Abrir ventana administrador");
		abrirAdmin.addKeyListener(listener);
		abrirAdmin.addActionListener(listener);
		abrirAdmin.setBounds(90, 348, 280, 21);
		panel.add(abrirAdmin);
		
		JButton abrirVentas = new JButton("Abrir ventana agente de propiedades");
		abrirVentas.addKeyListener(listener);
		abrirVentas.addActionListener(listener);
		abrirVentas.setBounds(90, 380, 280, 23);
		panel.add(abrirVentas);
		
		JButton abrirProp = new JButton("Abrir ventana agente de ventas");
		abrirProp.addKeyListener(listener);
		abrirProp.addActionListener(listener);
		abrirProp.setBounds(90, 414, 280, 23);
		panel.add(abrirProp);
		/*ActionListener oyente =new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println(userText.getText());
				//Ahora hay que pasarlo a la bbdd
				SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(AgentePropiedades.class)
				.buildSessionFactory();

							
				//Crear sesión
				Session session = factory.getCurrentSession();
				
				try {
				System.out.println("Creando objeto");
				AgentePropiedades tempAg = new AgentePropiedades("Juan", "MArtz", "juanm@g.com");
				session.beginTransaction();
				session.save(tempAg);
				session.getTransaction().commit();
				} finally {
				factory.close();
				}
			}
		};*/
		//loginButton.addActionListener(oyente);
	}
}