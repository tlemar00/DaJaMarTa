package es.unileon.dajamarta.agenteProp;

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

public class NuevaPropWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static NuevaPropWindow instance; // Singleton
	private ControlerNuevaPropWindow listener;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private NuevaPropWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(539, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerNuevaPropWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		textField = new JTextField();
		textField.setBounds(167, 136, 256, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 171, 46, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 202, 46, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(377, 167, 46, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 233, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Calle");
		lblNewLabel_1.setBounds(98, 139, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00BA");
		lblNewLabel_2.setBounds(98, 174, 86, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Piso");
		lblNewLabel_3.setBounds(98, 205, 92, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Puerta");
		lblNewLabel_4.setBounds(321, 170, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Poblaci\u00F3n");
		lblNewLabel_5.setBounds(98, 236, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo");
		lblNewLabel_6.setBounds(98, 100, 46, 14);
		panel.add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(167, 96, 256, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Guardar propiedad");
		btnNewButton.setBounds(184, 468, 152, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Escalera");
		lblNewLabel_7.setBounds(321, 201, 46, 14);
		panel.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(377, 198, 46, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Provincia");
		lblNewLabel_5_1.setBounds(98, 275, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 271, 256, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("Descripci\u00F3n");
		lblNewLabel_8.setBounds(98, 324, 92, 14);
		panel.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(98, 349, 325, 92);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir nueva propiedad");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 24, 221, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(NuevaPropWindow.class.getResource("/es/unileon/imagenes/edificio.png")));
		lblNewLabel_9.setBounds(-22, 416, 180, 165);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Tama\u00F1o");
		lblNewLabel_10.setBounds(321, 236, 46, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Imagen");
		lblNewLabel_11.setBounds(98, 299, 46, 14);
		panel.add(lblNewLabel_11);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static NuevaPropWindow getInstance(){

		if (instance == null) {
			try {
				instance = new NuevaPropWindow();
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