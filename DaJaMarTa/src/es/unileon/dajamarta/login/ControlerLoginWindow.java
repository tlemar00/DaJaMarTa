package es.unileon.dajamarta.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import es.unileon.dajamarta.agenteProp.AgentePropWindow;
import es.unileon.dajamarta.agenteVentas.AgenteVentasWindow;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerLoginWindow implements ActionListener, KeyListener{
	//private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private LoginWindow loginWindow;
	private AdminWindow adminWindow;
	private EmpleadobbddDAO empleadoDao;
	private AgentePropWindow agentePropWindow;
	private AgenteVentasWindow agenteVentWindow;

	public ControlerLoginWindow(LoginWindow loginWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		//Creamos la LoginWindow
		this.loginWindow = loginWindow;
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario seg�n el nombre introducido
		Usuarios u = usuarioDao.obtenerUsuario(loginWindow.userText.getText().toString());
		
		if (arg0.getActionCommand().equals("Login")) {
			// LLamamos al dao y nos devuelve la profesion del empleado que quiere acceder
			Empleadobbdd logueado = new Empleadobbdd();
			try {
				logueado = empleadoDao.obtenerEmpleadoPorUser(u.getIdUsuario());
			} catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrecto.", null, JOptionPane.ERROR_MESSAGE);
			}
			
			if(logueado.getCategorias().getNombreCategoria().equals("Administrador")) {
				AdminWindow.getInstance();
			} else if(logueado.getCategorias().getNombreCategoria().equals("Propiedades")) {
				AgentePropWindow.getInstance();
			} else if(logueado.getCategorias().getNombreCategoria().equals("Ventas")) {
				AgenteVentasWindow.getInstance();
			} else if (logueado.getNombre().equals(null)){
				//JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrecto.", null, JOptionPane.ERROR_MESSAGE);
			}
		} else if(arg0.getActionCommand().equals("Abrir ventana administrador")) {
			AdminWindow.getInstance();
		} else if(arg0.getActionCommand().equals("Abrir ventana agente de propiedades")) {
			AgentePropWindow.getInstance();
		} else if(arg0.getActionCommand().equals("Abrir ventana agente de ventas")) {
			AgenteVentasWindow.getInstance();
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
