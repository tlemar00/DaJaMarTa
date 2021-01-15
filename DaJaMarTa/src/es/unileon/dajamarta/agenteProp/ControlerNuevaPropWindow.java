package es.unileon.dajamarta.agenteProp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import es.unileon.dajamarta.DAO.ClientesDAO;
import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import modelo.Clientes;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerNuevaPropWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private PropiedadesDAO propiedadDao;
	private NuevaPropWindow nuevaPropWindow;
	private ClientesDAO clienteDao;

	public ControlerNuevaPropWindow(NuevaPropWindow nuevaPropWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		propiedadDao = new PropiedadesDAO();
		clienteDao = new ClientesDAO();
		this.nuevaPropWindow = nuevaPropWindow;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		//Rellenamos la Combobox
		nuevaPropWindow.comboBox.addItem("Piso");
		nuevaPropWindow.comboBox.addItem("Vivienda");
		nuevaPropWindow.comboBox.addItem("Habitación");
		nuevaPropWindow.comboBox.addItem("Garaje");
		nuevaPropWindow.comboBox.addItem("Trastero");
		nuevaPropWindow.comboBox.addItem("Oficina");
		nuevaPropWindow.comboBox.addItem("Local");
		nuevaPropWindow.comboBox.addItem("Nave");
		nuevaPropWindow.comboBox.addItem("Solar");
		nuevaPropWindow.comboBox.addItem("Terreno");
		nuevaPropWindow.comboBox.addItem("Edificio");
		
		String provincias[] = {"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
		               "Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
		               "Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
		               "Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
		               "Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
		for(int i=0; i < provincias.length; i++) {
			nuevaPropWindow.comboBox_1.addItem(provincias[i]);
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		
		if(nuevaPropWindow.comboBox.getSelectedItem().equals("Piso") ||
				nuevaPropWindow.comboBox.getSelectedItem().equals("Oficina") ||
				nuevaPropWindow.comboBox.getSelectedItem().equals("Habitación") ||
				nuevaPropWindow.comboBox.getSelectedItem().equals("Local")) {
			
			nuevaPropWindow.textEscalera.setVisible(true);
			nuevaPropWindow.textPuerta.setVisible(true);
			nuevaPropWindow.lblNewLabel_4.setVisible(true);
			nuevaPropWindow.lblNewLabel_7.setVisible(true);
		}else {
			nuevaPropWindow.textEscalera.setVisible(false);
			nuevaPropWindow.textPuerta.setVisible(false);
			nuevaPropWindow.lblNewLabel_4.setVisible(false);
			nuevaPropWindow.lblNewLabel_7.setVisible(false);
		}
		
	
		if(arg0.getActionCommand().equals("Guardar propiedad")) {//Cuando pulsamos guardar propiedad
			
			if(nuevaPropWindow.textTitulo.getText().length()==0 || nuevaPropWindow.textCalle.getText().length()==0
					|| nuevaPropWindow.textPobl.getText().length()==0 || nuevaPropWindow.textPrecio.getText().length()==0
					|| nuevaPropWindow.textNumero.getText().length()==0 || nuevaPropWindow.textPiso.getText().length()==0 
					|| nuevaPropWindow.comboBox_1.getSelectedItem().toString() == null) {
				//mensaje de error
				JOptionPane.showMessageDialog(null, "No se ha añadido algún campo necesario.", null, JOptionPane.ERROR_MESSAGE);
			}else {
				Propiedades p = new Propiedades();
				Clientes c = new Clientes();
				Empleadobbdd e = new Empleadobbdd();
				p.setNombre(nuevaPropWindow.textTitulo.getText());
				p.setDireccion(nuevaPropWindow.textCalle.getText());
				p.setCiudad(nuevaPropWindow.textPobl.getText());
				p.setProvincia(nuevaPropWindow.comboBox_1.getSelectedItem().toString());
				p.setPrecio(Float.parseFloat(nuevaPropWindow.textPrecio.getText()));
				p.setNumero(nuevaPropWindow.textNumero.getText());
				p.setPuerta(nuevaPropWindow.textPuerta.getText());
				p.setPiso(Integer.parseInt(nuevaPropWindow.textPiso.getText()));
				p.setEscalera(nuevaPropWindow.textEscalera.getText());
				p.setVendido(0);
				p.setReservado(0);
				p.setClientes(c);
				p.setEmpleadobbdd(e);
				propiedadDao.crearPropiedad(p);//Mete base de datos
			}
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
