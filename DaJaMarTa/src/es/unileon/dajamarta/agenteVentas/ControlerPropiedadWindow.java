package es.unileon.dajamarta.agenteVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerPropiedadWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private PropiedadWindow propiedadWindow;

	public ControlerPropiedadWindow(PropiedadWindow propiedadWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		//Creamos la LoginWindow
		this.propiedadWindow = propiedadWindow;
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		if (arg0.getActionCommand().equals("Login")) {
			// LLamamos al dao y nos devuelve la profesion del empleado que quiere acceder
			System.out.println("Has pulsado login");
			//System.out.println("Contrasena="+u.getContrasenia());
			
			//System.out.println(loginWindow.userText.getText().toString());
		} else if (arg0.getActionCommand().equals("Registro")) {
			//Llamamos al dao para que meta en la bbdd (anadirUsuario clase usuario)
			System.out.println("Has pulsado registro");
			//usuarioDao.crearUsuario(5, "hola", "hola");
			/*adminWindow = AdminWindow.getInstance();

			adminWindow.setVisible(true);
		
			adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
			
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
