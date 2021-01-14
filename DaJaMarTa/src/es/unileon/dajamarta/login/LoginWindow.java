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
		JFrame frame = new JFrame();
		frame.setSize(608, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerLoginWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginWindow.class.getResource("/es/unileon/imagenes/inmobiliaria.png")));
		lblNewLabel.setBounds(191, 32, 231, 140);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginWindow.class.getResource("/es/unileon/imagenes/edificio.png")));
		lblNewLabel_1.setBounds(2, 357, 231, 233);
		panel.add(lblNewLabel_1);

		frame.setVisible(true);
		
	}
	
	/*public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}*/
	
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
		userLabel.setBounds(137, 207, 80, 25);
		panel.add(userLabel);
		
		//userText = new HintTextField("USUARIO",55);
		//JTextField userText = new JTextField(20);
		userText.setBounds(265, 207, 220, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Contrase\u00F1a");
		passwordLabel.setBounds(137, 278, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(265, 278, 220, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("Login");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.RED);
		loginButton.addKeyListener(listener);
		loginButton.addActionListener(listener);
		loginButton.setBounds(253, 340, 86, 50);
		panel.add(loginButton);
		
		JButton abrirAdmin = new JButton("Abrir ventana administrador");
		abrirAdmin.addKeyListener(listener);
		abrirAdmin.addActionListener(listener);
		abrirAdmin.setBounds(369, 433, 202, 21);
		panel.add(abrirAdmin);
		
		JButton abrirVentas = new JButton("Abrir ventana agente de propiedades");
		abrirVentas.addKeyListener(listener);
		abrirVentas.addActionListener(listener);
		abrirVentas.setBounds(369, 465, 202, 23);
		panel.add(abrirVentas);
		
		JButton abrirProp = new JButton("Abrir ventana agente de ventas");
		abrirProp.addKeyListener(listener);
		abrirProp.addActionListener(listener);
		abrirProp.setBounds(369, 500, 202, 23);
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