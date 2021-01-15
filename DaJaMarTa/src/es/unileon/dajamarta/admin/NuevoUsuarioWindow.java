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

public class NuevoUsuarioWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static NuevoUsuarioWindow instance; // Singleton
	private ControlerNuevoUsuarioWindow listener;
	protected JTextField nombreField;
	protected JTextField apellido1Field;
	protected JTextField apellido2Field;
	protected JTextField nifField;
	protected JTextField emailField;
	protected JTextField usuarioField;
	protected JTextField contraField;
	protected JTextField contra2Field;
	protected JComboBox comboBox = new JComboBox();
	
	private NuevoUsuarioWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(445, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerNuevoUsuarioWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		nombreField = new JTextField();
		nombreField.setBounds(130, 113, 86, 20);
		panel.add(nombreField);
		nombreField.setColumns(10);
		
		apellido1Field = new JTextField();
		apellido1Field.setBounds(130, 144, 86, 20);
		panel.add(apellido1Field);
		apellido1Field.setColumns(10);
		
		apellido2Field = new JTextField();
		apellido2Field.setBounds(130, 175, 86, 20);
		panel.add(apellido2Field);
		apellido2Field.setColumns(10);
		
		nifField = new JTextField();
		nifField.setBounds(130, 206, 86, 20);
		panel.add(nifField);
		nifField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(130, 237, 263, 20);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(28, 116, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Primer apellido");
		lblNewLabel_2.setBounds(28, 147, 86, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Segundo apellido");
		lblNewLabel_3.setBounds(28, 178, 92, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NIF/NIE");
		lblNewLabel_4.setBounds(28, 209, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(28, 240, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Puesto");
		lblNewLabel_6.setBounds(28, 271, 46, 14);
		panel.add(lblNewLabel_6);
		
		comboBox.setBounds(130, 267, 263, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Crear empleado");
		btnNewButton.addActionListener(listener);
		btnNewButton.addKeyListener(listener);
		btnNewButton.setBounds(165, 332, 119, 23);
		panel.add(btnNewButton);
		
		JLabel lblAadirNuevoCliente = new JLabel("A\u00F1adir nuevo cliente");
		lblAadirNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAadirNuevoCliente.setBounds(111, 25, 221, 47);
		panel.add(lblAadirNuevoCliente);
		
		JLabel lblNewLabel_7 = new JLabel("Contrase\u00F1a");
		lblNewLabel_7.setBounds(239, 147, 58, 14);
		panel.add(lblNewLabel_7);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(307, 113, 86, 20);
		panel.add(usuarioField);
		usuarioField.setColumns(10);
		
		contraField = new JTextField();
		contraField.setBounds(307, 144, 86, 20);
		panel.add(contraField);
		contraField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(NuevoUsuarioWindow.class.getResource("/es/unileon/imagenes/edificio.png")));
		lblNewLabel_8.setBounds(-17, 284, 201, 175);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Repita");
		lblNewLabel_9.setBounds(239, 175, 58, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("contrase\u00F1a");
		lblNewLabel_10.setBounds(239, 188, 63, 14);
		panel.add(lblNewLabel_10);
		
		contra2Field = new JTextField();
		contra2Field.setBounds(307, 175, 86, 20);
		panel.add(contra2Field);
		contra2Field.setColumns(10);
		
		JLabel lblNewLabel_10_1 = new JLabel("usuario");
		lblNewLabel_10_1.setBounds(239, 122, 63, 14);
		panel.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Nombre");
		lblNewLabel_9_1.setBounds(239, 109, 58, 14);
		panel.add(lblNewLabel_9_1);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static NuevoUsuarioWindow getInstance(){

		if (instance == null) {
			try {
				instance = new NuevoUsuarioWindow();
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