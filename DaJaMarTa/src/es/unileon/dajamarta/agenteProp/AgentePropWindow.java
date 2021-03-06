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

public class AgentePropWindow extends JFrame{
	ImageIcon imagen;
	String nombre;
	private static AgentePropWindow instance; // Singleton
	private ControlerAgentePropWindow listener;
	private Empleadobbdd[] lista; //Lista con todos los empleados
	protected JTextField textField_Calle;
	protected JTextField textField_numero;
	protected JTextField textField_Puerta;
	protected JTextField textField_piso;
	protected JTextField textField_Poblacion;
	protected JTextField textField_escalera;
	protected JComboBox comboBox = new JComboBox();
	protected JTextField textField_Precio;
	protected JTextField textField_titulo;
	protected JSpinner spinner;
	protected JComboBox comboBox_provincia = new JComboBox();
	
	private AgentePropWindow() {
		EmpleadobbddDAO sesion = new EmpleadobbddDAO();
		lista = sesion.obtenerEmpleados();//Rellenamos lista con los empleados
		
		JFrame frmConsultarYEditar = new JFrame("Demo application");
		frmConsultarYEditar.setTitle("Consultar y editar propiedades");
		frmConsultarYEditar.setSize(684, 549);
		frmConsultarYEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.listener = new ControlerAgentePropWindow(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmConsultarYEditar.getContentPane().add(panel);
		placeComponents(panel);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(539, 390, 89, 50);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_Propiedad = new JLabel("Elija propiedad:");
		lblNewLabel_Propiedad.setBounds(330, 61, 141, 14);
		panel.add(lblNewLabel_Propiedad);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AgentePropWindow.class.getResource("/es/unileon/imagenes/logo.PNG")));
		lblNewLabel_1.setBounds(39, 61, 219, 311);
		panel.add(lblNewLabel_1);
		
		textField_numero = new JTextField();
		textField_numero.setBounds(375, 160, 53, 20);
		panel.add(textField_numero);
		textField_numero.setColumns(10);
		
		textField_Calle = new JTextField();
		textField_Calle.setBounds(375, 129, 253, 20);
		panel.add(textField_Calle);
		textField_Calle.setColumns(10);
		
		textField_Puerta = new JTextField();
		textField_Puerta.setBounds(557, 160, 71, 20);
		panel.add(textField_Puerta);
		textField_Puerta.setColumns(10);
		
		textField_escalera = new JTextField();
		textField_escalera.setBounds(557, 191, 71, 20);
		panel.add(textField_escalera);
		textField_escalera.setColumns(10);
		textField_piso = new JTextField();
		textField_piso.setBounds(375, 191, 53, 20);
		panel.add(textField_piso);
		textField_piso.setColumns(10);
		
		JLabel lblNewLabel_Calle = new JLabel("Calle");
		lblNewLabel_Calle.setBounds(330, 132, 46, 14);
		panel.add(lblNewLabel_Calle);
		
		JLabel lblNewLabel_numero = new JLabel("N�");
		lblNewLabel_numero.setBounds(330, 163, 86, 14);
		panel.add(lblNewLabel_numero);
		
		JLabel lblNewLabel_puerta = new JLabel("Puerta");
		lblNewLabel_puerta.setBounds(488, 163, 85, 14);
		panel.add(lblNewLabel_puerta);
		
		JLabel lblNewLabel_piso = new JLabel("Piso");
		lblNewLabel_piso.setBounds(330, 194, 46, 14);
		panel.add(lblNewLabel_piso);
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addKeyListener(listener);
		btnEditar.addActionListener(listener);
		btnEditar.setBounds(330, 390, 89, 50);
		panel.add(btnEditar);
		
		JLabel lblNewLabel_escalera = new JLabel("Escalera");
		lblNewLabel_escalera.setBounds(488, 194, 63, 14);
		panel.add(lblNewLabel_escalera);
		
		textField_Poblacion = new JTextField();
		textField_Poblacion.setBounds(394, 222, 234, 20);
		panel.add(textField_Poblacion);
		textField_Poblacion.setColumns(10);
		
		JLabel lblNewLabel_poblacion = new JLabel("Poblacion");
		lblNewLabel_poblacion.setBounds(330, 225, 78, 14);
		panel.add(lblNewLabel_poblacion);
		
		JLabel lblNewLabel_superficie = new JLabel("Superficie\r\n");
		lblNewLabel_superficie.setBounds(330, 253, 78, 14);
		panel.add(lblNewLabel_superficie);
		
		spinner = new JSpinner();
		spinner.setBounds(500, 284, 128, 20);
		panel.add(spinner);
		
		JLabel lblNewLabel_provincia = new JLabel("Provincia");
		lblNewLabel_provincia.setBounds(330, 319, 78, 14);
		panel.add(lblNewLabel_provincia);
		
		comboBox_provincia.setBounds(394, 315, 234, 22);
		panel.add(comboBox_provincia);
		
		JLabel lblNewLabel_precio = new JLabel("Precio");
		lblNewLabel_precio.setBounds(330, 287, 78, 14);
		panel.add(lblNewLabel_precio);
		
		textField_Precio = new JTextField();
		textField_Precio.setColumns(10);
		textField_Precio.setBounds(500, 253, 128, 20);
		panel.add(textField_Precio);
		
		JLabel lblNewLabel_titulo = new JLabel("T\u00EDtulo");
		lblNewLabel_titulo.setBounds(330, 344, 78, 14);
		panel.add(lblNewLabel_titulo);
		
		textField_titulo = new JTextField();
		textField_titulo.setColumns(10);
		textField_titulo.setBounds(394, 344, 234, 20);
		panel.add(textField_titulo);
		
		JMenuBar menuBar = new JMenuBar();
		frmConsultarYEditar.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("A\u00F1adir propiedad");
		mntmNewMenuItem.addActionListener(listener);
		mntmNewMenuItem.addKeyListener(listener);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ayuda");
		mntmNewMenuItem_2.addActionListener(listener);
		mntmNewMenuItem_2.addKeyListener(listener);
		mnNewMenu.add(mntmNewMenuItem_2);

		frmConsultarYEditar.setVisible(true);
		
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}
	
	public synchronized static AgentePropWindow getInstance(){

		if (instance == null) {
			try {
				instance = new AgentePropWindow();
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
		registerButton.setBounds(535, 21, 93, 50);
		panel.add(registerButton);
		
		
		
		comboBox.setBounds(330, 86, 298, 22);
		comboBox.addActionListener(listener);
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

							
				//Crear sesi�n
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