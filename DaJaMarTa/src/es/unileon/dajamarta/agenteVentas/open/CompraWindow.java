package es.unileon.dajamarta.agenteVentas.open;

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

public class CompraWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static CompraWindow instance; // Singleton
	private ControlerCompraWindow listener;
	protected JTextField nombreField;
	protected JTextField apellido1Field;
	protected JTextField apellido2Field;
	protected JTextField nifField;
	protected JTextField movilField;
	protected JTextField userField;
	private JPasswordField passwordField;
	protected int idProp;
	
	private CompraWindow(int idProp) {
		this.idProp = idProp;
		JFrame frame = new JFrame("Demo application");
		frame.setSize(445, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerCompraWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		nombreField = new JTextField();
		nombreField.setBounds(130, 113, 263, 20);
		panel.add(nombreField);
		nombreField.setColumns(10);
		
		apellido1Field = new JTextField();
		apellido1Field.setBounds(130, 144, 263, 20);
		panel.add(apellido1Field);
		apellido1Field.setColumns(10);
		
		apellido2Field = new JTextField();
		apellido2Field.setBounds(130, 175, 263, 20);
		panel.add(apellido2Field);
		apellido2Field.setColumns(10);
		
		nifField = new JTextField();
		nifField.setBounds(130, 206, 263, 20);
		panel.add(nifField);
		nifField.setColumns(10);
		
		movilField = new JTextField();
		movilField.setBounds(130, 237, 263, 20);
		panel.add(movilField);
		movilField.setColumns(10);
		
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
		
		JLabel lblNewLabel_5 = new JLabel("Tel\u00E9fono m\u00F3vil");
		lblNewLabel_5.setBounds(28, 240, 92, 14);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Registrar compra");
		btnNewButton.addActionListener(listener);
		btnNewButton.addKeyListener(listener);
		btnNewButton.setBounds(165, 383, 119, 23);
		panel.add(btnNewButton);
		
		JLabel lblAadirNuevoCliente = new JLabel("Introduzca los datos del comprador");
		lblAadirNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAadirNuevoCliente.setBounds(57, 25, 329, 47);
		panel.add(lblAadirNuevoCliente);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(CompraWindow.class.getResource("/es/unileon/imagenes/edificio.png")));
		lblNewLabel_8.setBounds(-14, 332, 201, 175);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("Introduzca su usuario y contrase\u00F1a para confirmar la compra");
		lblNewLabel.setBounds(70, 268, 323, 14);
		panel.add(lblNewLabel);
		
		userField = new JTextField();
		userField.setBounds(67, 311, 86, 20);
		panel.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Usuario");
		lblNewLabel_6.setBounds(68, 293, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Contrase\u00F1a");
		lblNewLabel_7.setBounds(259, 293, 100, 14);
		panel.add(lblNewLabel_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(259, 311, 100, 20);
		panel.add(passwordField);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static CompraWindow getInstance(int idProp){

		if (instance == null) {
			try {
				instance = new CompraWindow(idProp);
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