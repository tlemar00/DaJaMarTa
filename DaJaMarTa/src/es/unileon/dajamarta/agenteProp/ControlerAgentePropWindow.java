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
import modelo.Clientes;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerAgentePropWindow implements ActionListener, KeyListener{
	private PropiedadesDAO propiedadesDao;
	private AgentePropWindow agentePropWindow;
	private Propiedades[] lista; //Lista con todas las propiedades
	private NuevaPropWindow nuevaPropWindow;

	public ControlerAgentePropWindow(AgentePropWindow agentePropWindow)  {
		
		propiedadesDao = new PropiedadesDAO();
		this.agentePropWindow = agentePropWindow;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		
		lista = propiedadesDao.obtenerPropiedades();//Rellenamos lista con las propiedades
		//Rellenamos la Combobox
		for(int i=0; i< lista.length; i++) {//Rellenamos la combobox
			agentePropWindow.comboBox_propiedad.addItem(lista[i].getNombre());
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		if(arg0.getActionCommand().equals("Buscar")) {

			agentePropWindow.textField_Calle.setText(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getDireccion());
			agentePropWindow.textField_numero.setText(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getNumero());
			agentePropWindow.textField_Puerta.setText(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getPuerta());
			agentePropWindow.textField_piso.setText(String.valueOf(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getPiso()));
			agentePropWindow.textField_escalera.setText(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getEscalera());
			agentePropWindow.textField_Poblacion.setText(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getCiudad());
			agentePropWindow.textField_Precio.setText(String.valueOf(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getPrecio()));
			agentePropWindow.textField_titulo.setText(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getNombre());
			agentePropWindow.spinner.setValue(lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()].getTamanio());
		
		}else if(arg0.getActionCommand().equals("Editar")) {
			System.out.println("Boton editar");
			Propiedades propiedadEditada = lista[agentePropWindow.comboBox_propiedad.getSelectedIndex()];
			
			//Creamos objeto con los nuevos datos
			
			propiedadEditada.setNombre(nuevaPropWindow.textTitulo.getText());
			propiedadEditada.setDireccion(nuevaPropWindow.textCalle.getText());
			propiedadEditada.setCiudad(nuevaPropWindow.textPobl.getText());
			propiedadEditada.setProvincia(nuevaPropWindow.comboBox_1.getSelectedItem().toString());
			propiedadEditada.setPrecio(Float.parseFloat(nuevaPropWindow.textPrecio.getText()));
			propiedadEditada.setNumero(nuevaPropWindow.textNumero.getText());
			propiedadEditada.setPuerta(nuevaPropWindow.textPuerta.getText());
			propiedadEditada.setPiso(Integer.parseInt(nuevaPropWindow.textPiso.getText()));
			propiedadEditada.setEscalera(nuevaPropWindow.textEscalera.getText());
			
			propiedadesDao.actualizarPropiedad(propiedadEditada);//Mete base de datos

			
		}else if(arg0.getActionCommand().equals("Añadir propiedad")) {
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
