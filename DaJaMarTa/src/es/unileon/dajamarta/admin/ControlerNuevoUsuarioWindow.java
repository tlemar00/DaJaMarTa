package es.unileon.dajamarta.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerNuevoUsuarioWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private NuevoUsuarioWindow nuevoUsuarioWindow;
	private Empleadobbdd[] lista; //Lista con todos los empleados

	public ControlerNuevoUsuarioWindow(NuevoUsuarioWindow nuevoUsuarioWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		this.nuevoUsuarioWindow = nuevoUsuarioWindow;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		lista = empleadoDao.obtenerEmpleados();//Rellenamos lista con los empleados
		//Rellenamos la Combobox
		for(int i=0; i< lista.length; i++) {//Rellenamos la combobox
			//adminWindow.comboBox.addItem(lista[i].getEmail());
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		if(arg0.getActionCommand().equals("Buscar")) {
			/*adminWindow.campoNombre.setText(lista[adminWindow.comboBox.getSelectedIndex()].getNombre());
			adminWindow.campoApellido.setText(lista[adminWindow.comboBox.getSelectedIndex()].getApellido1());
			adminWindow.campoApellido2.setText(lista[adminWindow.comboBox.getSelectedIndex()].getApellido2());
			adminWindow.campoEmail.setText(lista[adminWindow.comboBox.getSelectedIndex()].getEmail());
			adminWindow.campoNif.setText(lista[adminWindow.comboBox.getSelectedIndex()].getNifnie());*/
			//adminWindow.campoPuesto.setText(lista[adminWindow.comboBox.getSelectedIndex()].getPuesto());
		}else if(arg0.getActionCommand().equals("Editar")) {
			System.out.println("Boton editar");
			//Empleadobbdd empleadoEditado = lista[adminWindow.comboBox.getSelectedIndex()];
			
			//Creamos objeto con los nuevos datso
			//empleadoEditado.setNombre(adminWindow.campoNombre.getText());
			
			//Lo enviamos a la bbdd
			//empleadoDao.actualizarEmpleado(empleadoEditado);
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
