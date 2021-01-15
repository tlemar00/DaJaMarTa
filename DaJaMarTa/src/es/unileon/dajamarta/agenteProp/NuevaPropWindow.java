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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;

public class NuevaPropWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static NuevaPropWindow instance; // Singleton
	private ControlerNuevaPropWindow listener;
	protected JTextField textCalle;
	protected JTextField textNumero;
	protected JTextField textPiso;
	protected JTextField textPuerta;
	protected JTextField textPobl;
	protected JTextField textEscalera;
	protected JTextField textDescrip;
	protected JTextField textImagen;
	protected JTextField textPrecio;
	protected JComboBox comboBox = new JComboBox();
	protected JTextField textTitulo;
	protected JComboBox comboBox_1 = new JComboBox();
	
	private NuevaPropWindow() {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(565, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerNuevaPropWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		textCalle = new JTextField();
		textCalle.setBounds(167, 136, 291, 20);
		panel.add(textCalle);
		textCalle.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setBounds(167, 171, 46, 20);
		panel.add(textNumero);
		textNumero.setColumns(10);
		
		textPiso = new JTextField();
		textPiso.setBounds(167, 202, 46, 20);
		panel.add(textPiso);
		textPiso.setColumns(10);
		
		textPuerta = new JTextField();
		textPuerta.setBounds(412, 171, 46, 20);
		panel.add(textPuerta);
		textPuerta.setColumns(10);
		
		textPobl = new JTextField();
		textPobl.setBounds(167, 233, 134, 20);
		panel.add(textPobl);
		textPobl.setColumns(10);
		
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
		lblNewLabel_4.setBounds(311, 174, 86, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Poblaci\u00F3n");
		lblNewLabel_5.setBounds(98, 236, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo");
		lblNewLabel_6.setBounds(98, 100, 46, 14);
		panel.add(lblNewLabel_6);
		
		comboBox.addActionListener(listener);
		comboBox.setBounds(167, 96, 291, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Guardar propiedad");
		btnNewButton.addActionListener(listener);
		btnNewButton.addKeyListener(listener);
		btnNewButton.setBounds(213, 535, 152, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Escalera");
		lblNewLabel_7.setBounds(311, 205, 73, 14);
		panel.add(lblNewLabel_7);
		
		textEscalera = new JTextField();
		textEscalera.setBounds(412, 202, 46, 20);
		panel.add(textEscalera);
		textEscalera.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Provincia");
		lblNewLabel_5_1.setBounds(98, 275, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		
		comboBox_1.setBounds(167, 271, 291, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("Descripci\u00F3n de la propiedad");
		lblNewLabel_8.setBounds(98, 389, 134, 14);
		panel.add(lblNewLabel_8);
		
		textDescrip = new JTextField();
		textDescrip.setBounds(98, 404, 360, 92);
		panel.add(textDescrip);
		textDescrip.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir nueva propiedad");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(177, 25, 221, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(NuevaPropWindow.class.getResource("/es/unileon/imagenes/edificio.png")));
		lblNewLabel_9.setBounds(-21, 471, 180, 165);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Superficie");
		lblNewLabel_10.setBounds(311, 230, 74, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Imagen");
		lblNewLabel_11.setBounds(98, 307, 46, 14);
		panel.add(lblNewLabel_11);
		
		textImagen = new JTextField();
		textImagen.setBounds(167, 304, 291, 20);
		panel.add(textImagen);
		textImagen.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(412, 233, 46, 20);
		panel.add(spinner);
		
		JLabel lblNewLabel_12 = new JLabel(" construida (m2)");
		lblNewLabel_12.setBounds(307, 246, 90, 14);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Precio fijado por el vendedor (\u20AC)");
		lblNewLabel_13.setBounds(98, 338, 190, 14);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("T\u00EDtulo");
		lblNewLabel_14.setBounds(98, 364, 46, 14);
		panel.add(lblNewLabel_14);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(237, 363, 221, 20);
		panel.add(textTitulo);
		textTitulo.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(311, 335, 147, 20);
		panel.add(textPrecio);
		textPrecio.setColumns(10);

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