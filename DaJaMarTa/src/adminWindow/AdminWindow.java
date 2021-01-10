package adminWindow;

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

import DAO.EmpleadobbddDAO;
import DAO.PropiedadesDAO;
import DAO.UsuariosDAO;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;

public class AdminWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static AdminWindow instance; // Singleton
	private ControlerAdminWindow listener;
	
	private AdminWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(540, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerAdminWindow(this);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(381, 167, 89, 50);
		panel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(44, 181, 166, 22);
		panel.add(comboBox);
		
		JButton btnAadirNuevoUsusario = new JButton("A\u00F1adir nuevo ususario");
		btnAadirNuevoUsusario.setBounds(150, 362, 214, 50);
		panel.add(btnAadirNuevoUsusario);
		
		JLabel lblNewLabel = new JLabel("Elija usuario:");
		lblNewLabel.setBounds(44, 156, 78, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Imagen inmobiliaria");
		lblNewLabel_1.setBounds(205, 46, 134, 14);
		panel.add(lblNewLabel_1);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static AdminWindow getInstance(){

		if (instance == null) {
			try {
				instance = new AdminWindow();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		JButton registerButton = new JButton("Editar");
		registerButton.addKeyListener(listener);
		registerButton.addActionListener(listener);
		registerButton.setBounds(246, 167, 93, 50);
		panel.add(registerButton);
		
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