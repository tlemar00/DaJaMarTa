package es.unileon.dajamarta.admin;

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

public class AdminWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static AdminWindow instance; // Singleton
	private ControlerAdminWindow listener;
	private Empleadobbdd[] lista; //Lista con todos los empleados
	/**
	 * @wbp.nonvisual location=-38,89
	 */
	private final JTextArea textArea = new JTextArea();
	protected JTextField campoNombre;
	protected JTextField campoApellido;
	protected JTextField campoApellido2;
	protected JTextField campoNif;
	protected JTextField campoPuesto;
	protected JTextField campoEmail;
	protected JComboBox comboBox = new JComboBox();
	
	private AdminWindow() {
		EmpleadobbddDAO sesion = new EmpleadobbddDAO();
		lista = sesion.obtenerEmpleados();//Rellenamos lista con los empleados
		
		JFrame frame = new JFrame("Demo application");
		frame.setSize(1060, 721);
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
		btnNewButton.setBounds(924, 439, 89, 50);
		panel.add(btnNewButton);
		
		
		
		JButton btnAadirNuevoUsusario = new JButton("A\u00F1adir nuevo ususario");
		btnAadirNuevoUsusario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadirNuevoUsusario.setBounds(392, 588, 214, 50);
		panel.add(btnAadirNuevoUsusario);
		
		JLabel lblNewLabel = new JLabel("Elija usuario:");
		lblNewLabel.setBounds(249, 371, 78, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminWindow.class.getResource("/es/unileon/imagenes/logo.PNG")));
		lblNewLabel_1.setBounds(407, 11, 219, 311);
		panel.add(lblNewLabel_1);
		
		campoApellido = new JTextField();
		campoApellido.setBounds(163, 454, 107, 20);
		panel.add(campoApellido);
		campoApellido.setColumns(10);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(46, 454, 107, 20);
		panel.add(campoNombre);
		campoNombre.setColumns(10);
		
		campoApellido2 = new JTextField();
		campoApellido2.setBounds(284, 454, 107, 20);
		panel.add(campoApellido2);
		campoApellido2.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(503, 454, 163, 20);
		panel.add(campoEmail);
		campoEmail.setColumns(10);
		campoNif = new JTextField();
		campoNif.setBounds(407, 454, 86, 20);
		panel.add(campoNif);
		campoNif.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(46, 429, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Primer apellido");
		lblNewLabel_3.setBounds(168, 429, 86, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Segundo apellido");
		lblNewLabel_4.setBounds(285, 429, 85, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NIF/NIE");
		lblNewLabel_5.setBounds(408, 429, 46, 14);
		panel.add(lblNewLabel_5);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addKeyListener(listener);
		btnEditar.addActionListener(listener);
		btnEditar.setBounds(801, 439, 89, 50);
		panel.add(btnEditar);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(503, 429, 46, 14);
		panel.add(lblNewLabel_6);
		
		campoPuesto = new JTextField();
		campoPuesto.setBounds(676, 454, 93, 20);
		panel.add(campoPuesto);
		campoPuesto.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Puesto");
		lblNewLabel_7.setBounds(676, 429, 46, 14);
		panel.add(lblNewLabel_7);

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
		
		JButton registerButton = new JButton("Buscar");
		registerButton.addKeyListener(listener);
		registerButton.addActionListener(listener);
		registerButton.setBounds(676, 353, 93, 50);
		panel.add(registerButton);
		
		
		
		comboBox.setBounds(337, 367, 298, 22);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedItem().toString());
			}
		});
		panel.add(comboBox);
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