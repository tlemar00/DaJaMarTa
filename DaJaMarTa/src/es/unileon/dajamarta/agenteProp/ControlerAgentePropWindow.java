package es.unileon.dajamarta.agenteProp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import es.unileon.dajamarta.agenteProp.AgentePropWindow;
import es.unileon.dajamarta.agenteVentas.AgenteVentasWindow;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerAgentePropWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private AgentePropWindow agentePropWindow;
	private Empleadobbdd[] lista; //Lista con todos los empleados
	private NuevaPropWindow nuevaPropWindow;

	public ControlerAgentePropWindow(AgentePropWindow agentePropWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		this.agentePropWindow = agentePropWindow;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		lista = empleadoDao.obtenerEmpleados();//Rellenamos lista con los empleados
		//Rellenamos la Combobox
		for(int i=0; i< lista.length; i++) {//Rellenamos la combobox
			agentePropWindow.comboBox.addItem(lista[i].getEmail());
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		if(arg0.getActionCommand().equals("Buscar")) {
			agentePropWindow.campoNombre.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getNombre());
			agentePropWindow.campoApellido.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getApellido1());
			agentePropWindow.campoApellido2.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getApellido2());
			agentePropWindow.campoEmail.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getEmail());
			agentePropWindow.campoNif.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getNifnie());
			//agentePropWindow.campoPuesto.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getPuesto());
		}else if(arg0.getActionCommand().equals("Editar")) {
			System.out.println("Boton editar");
			Empleadobbdd empleadoEditado = lista[agentePropWindow.comboBox.getSelectedIndex()];
			
			//Creamos objeto con los nuevos datso
			empleadoEditado.setNombre(agentePropWindow.campoNombre.getText());
			
			//Lo enviamos a la bbdd
			empleadoDao.actualizarEmpleado(empleadoEditado);
		}else if(arg0.getActionCommand().equals("Crear nuevo empleado")) {
			NuevaPropWindow.getInstance();
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
