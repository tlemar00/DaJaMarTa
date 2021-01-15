package es.unileon.dajamarta.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import es.unileon.dajamarta.DAO.CategoriasDAO;
import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import modelo.Categorias;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerNuevoUsuarioWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private NuevoUsuarioWindow nuevoUsuarioWindow;
	private CategoriasDAO categoriasDao;
	private Empleadobbdd[] lista; //Lista con todos los empleados

	public ControlerNuevoUsuarioWindow(NuevoUsuarioWindow nuevoUsuarioWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		this.nuevoUsuarioWindow = nuevoUsuarioWindow;
		nuevoUsuarioWindow.comboBox.addItem("Administrador");
		nuevoUsuarioWindow.comboBox.addItem("Propiedades");
		nuevoUsuarioWindow.comboBox.addItem("Ventas");
	}
	
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		if(arg0.getActionCommand().equals("Crear empleado")) {
			empleadoDao = new EmpleadobbddDAO();
			usuarioDao = new UsuariosDAO();
			categoriasDao = new CategoriasDAO();
			
			Empleadobbdd e = new Empleadobbdd();
			Usuarios u = new Usuarios();
			Categorias cat = categoriasDao.obtenerCategoriaId(nuevoUsuarioWindow.comboBox.getSelectedIndex()+1);
			//cat.se
			
			e.setIdEmpleado(0);
			e.setCategorias(cat);
			System.out.println(cat.getNombreCategoria());
			e.setNombre(nuevoUsuarioWindow.nombreField.getText());
			e.setApellido1(nuevoUsuarioWindow.apellido1Field.getText());
			e.setApellido2(nuevoUsuarioWindow.apellido2Field.getText());
			e.setNifnie(nuevoUsuarioWindow.nifField.getText());
			e.setEmail(nuevoUsuarioWindow.emailField.getText());
			u.setContrasenia(nuevoUsuarioWindow.contraField.getText());
			u.setIdUsuario(nuevoUsuarioWindow.usuarioField.getText());
			usuarioDao.actualizarUsuario(u);//Creamos el usuario en al bbdd
			e.setUsuarios(u);//Juntamos el usuario al empleado
			empleadoDao.actualizarEmpleado(e);//Creamos empleado en la bbdd
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
