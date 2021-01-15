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
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class PropiedadWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static PropiedadWindow instance; // Singleton
	private ControlerPropiedadWindow listener;
	protected int idProp;
	protected JLabel lblTitulo = new JLabel();
	protected JTextArea textArea = new JTextArea();
	protected JTextField dimensionField = new JTextField();
	protected JTextField precioField = new JTextField();
	
	private PropiedadWindow(int idProp) {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(798, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = new ControlerPropiedadWindow(this);
		this.idProp = idProp;
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		JButton reservarButton = new JButton("Reservar propiedad");
		reservarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reservarButton.setBounds(455, 351, 175, 35);
		panel.add(reservarButton);
		
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
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(326, 72, 434, 114);
		panel.add(textArea_1);
		
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(326, 11, 522, 33);
		panel.add(lblTitulo);
		
		JLabel lblNewLabel_3 = new JLabel("m2");
		lblNewLabel_3.setBounds(336, 204, 46, 14);
		panel.add(lblNewLabel_3);
		dimensionField.setEditable(false);
		dimensionField.setText("");
		dimensionField.setBounds(362, 201, 86, 20);
		panel.add(dimensionField);
		dimensionField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio marcado por el cliente");
		lblNewLabel_4.setBounds(469, 204, 175, 14);
		panel.add(lblNewLabel_4);
		
		precioField.setEditable(false);
		precioField.setBounds(664, 201, 97, 20);
		panel.add(precioField);
		precioField.setColumns(10);
		
		textArea.setBounds(326, 55, 516, 99);
		panel.add(textArea);

		frame.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static PropiedadWindow getInstance(int idProp){

		if (instance == null) {
			try {
				instance = new PropiedadWindow(idProp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		JButton venderButton = new JButton("Marcar como vendida");
		venderButton.addKeyListener(listener);
		venderButton.addActionListener(listener);
		venderButton.setBounds(153, 349, 175, 38);
		panel.add(venderButton);
	}
}