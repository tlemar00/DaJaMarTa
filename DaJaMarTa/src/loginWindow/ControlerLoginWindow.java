package loginWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import DAO.EmpleadobbddDAO;
import DAO.PropiedadesDAO;
import DAO.UsuariosDAO;
import adminWindow.AdminWindow;
import agentePropWindow.AgentePropWindow;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerLoginWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private LoginWindow loginWindow;
	private AdminWindow adminWindow;
	private AgentePropWindow agentePropWindow;

	public ControlerLoginWindow(LoginWindow loginWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		//Creamos la LoginWindow
		this.loginWindow = loginWindow;
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		Usuarios u = usuarioDao.obtenerUsuario(loginWindow.userText.getText().toString());
		
		if (arg0.getActionCommand().equals("Login")) {
			// LLamamos al dao y nos devuelve la profesion del empleado que quiere acceder
			System.out.println("Has pulsado login");
			System.out.println("Contrasena="+u.getContrasenia());
			
			//System.out.println(loginWindow.userText.getText().toString());
		} else if (arg0.getActionCommand().equals("Registro")) {
			//Llamamos al dao para que meta en la bbdd (anadirUsuario clase usuario)
			System.out.println("Has pulsado registro");
			//usuarioDao.crearUsuario(5, "hola", "hola");
			
		} else if(arg0.getActionCommand().equals("Abrir ventana administrador")) {
			adminWindow = AdminWindow.getInstance();

			adminWindow.setVisible(true);
		
			adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else if(arg0.getActionCommand().equals("Abrir ventana agente de propiedades")) {
			agentePropWindow = AgentePropWindow.getInstance();

			agentePropWindow.setVisible(true);
		
			agentePropWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else if(arg0.getActionCommand().equals("Abrir ventana agente de ventas")) {
			//Cambiar por agente de propiedades
			/*agentePropWindow = AgentePropiedadesWindow.getInstance();

			agentePropWindow.setVisible(true);
		
			agentePropWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
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
