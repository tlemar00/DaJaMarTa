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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private NuevoUsuarioWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(445, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerNuevoUsuarioWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		textField = new JTextField();
		textField.setBounds(130, 113, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 144, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 175, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 206, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(130, 237, 263, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 267, 263, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Crear empleado");
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
		
		textField_5 = new JTextField();
		textField_5.setBounds(307, 113, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(307, 144, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
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
		
		textField_7 = new JTextField();
		textField_7.setBounds(307, 175, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
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