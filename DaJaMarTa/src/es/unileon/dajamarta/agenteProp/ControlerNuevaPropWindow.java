package es.unileon.dajamarta.agenteProp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

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
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		
		
	
		if(arg0.getActionCommand().equals("Guardar propiedad")) {//Cuando pulsamos guardar propiedad
			
			/*Propiedades p = new Propiedades();
			Clientes c = new Clientes();
			Empleadobbdd e = new Empleadobbdd();
			p.setNombre(nuevaPropWindow.textTitulo.getText());
			p.setDireccion(nuevaPropWindow.textCalle.getText());
			p.setCiudad(nuevaPropWindow.textPobl.getText());
			p.setProvincia("Madrid");
			p.setPrecio(Float.parseFloat(nuevaPropWindow.textPrecio.getText()));
			p.setNumero(nuevaPropWindow.textNumero.getText());
			p.setPuerta(nuevaPropWindow.textPuerta.getText());
			p.setPiso(1);
			p.setEscalera("esc");
			p.setVendido(0);
			p.setReservado(0);
			p.setClientes(c);
			p.setEmpleadobbdd(e);
			propiedadDao.actualizarPropiedad(p);//Mete base de datos*/
		} else if(nuevaPropWindow.comboBox.getSelectedItem().equals("Terreno")) {
			nuevaPropWindow.textEscalera.setVisible(false);
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
