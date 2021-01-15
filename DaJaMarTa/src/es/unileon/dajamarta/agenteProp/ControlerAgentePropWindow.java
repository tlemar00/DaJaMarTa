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

	public ControlerAgentePropWindow(AgentePropWindow agentePropWindow)  {
		
		propiedadesDao = new PropiedadesDAO();
		this.agentePropWindow = agentePropWindow;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		
		lista = propiedadesDao.obtenerPropiedades();//Rellenamos lista con las propiedades
		//Rellenamos la Combobox
		for(int i=0; i< lista.length; i++) {//Rellenamos la combobox
			agentePropWindow.comboBox.addItem(lista[i].getIdPropiedad()+"."+lista[i].getTipoPropiedad()+" en calle "+lista[i].getDireccion()+" número "+lista[i].getNumero());
		}
		
		String provincias[] = {"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
	               "Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
	               "Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
	               "Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
	               "Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
		for(int i=0; i < provincias.length; i++) {
			agentePropWindow.comboBox_provincia.addItem(provincias[i]);
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		if(arg0.getActionCommand().equals("Buscar")) {

			agentePropWindow.textField_Calle.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getDireccion());
			agentePropWindow.textField_numero.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getNumero());
			agentePropWindow.textField_Puerta.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getPuerta());
			agentePropWindow.textField_piso.setText(String.valueOf(lista[agentePropWindow.comboBox.getSelectedIndex()].getPiso()));
			agentePropWindow.textField_escalera.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getEscalera());
			agentePropWindow.textField_Poblacion.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getCiudad());
			agentePropWindow.textField_Precio.setText(String.valueOf(lista[agentePropWindow.comboBox.getSelectedIndex()].getPrecio()));
			agentePropWindow.textField_titulo.setText(lista[agentePropWindow.comboBox.getSelectedIndex()].getNombre());
			agentePropWindow.spinner.setValue(lista[agentePropWindow.comboBox.getSelectedIndex()].getTamanio());
			agentePropWindow.comboBox_provincia.setSelectedItem(lista[agentePropWindow.comboBox.getSelectedIndex()].getProvincia());
		
		}else if(arg0.getActionCommand().equals("Editar")) {
			System.out.println("Boton editar");
			Propiedades propiedadEditada = lista[agentePropWindow.comboBox.getSelectedIndex()];
			
			//Creamos objeto con los nuevos datos
			
			//propiedadEditada.setNombre(nuevaPropWindow.textTitulo.getText());
			System.out.println(agentePropWindow.textField_titulo.getText());
			propiedadEditada.setDireccion(agentePropWindow.textField_Calle.getText());
			propiedadEditada.setCiudad(agentePropWindow.textField_Poblacion.getText());
			propiedadEditada.setProvincia(agentePropWindow.comboBox_provincia.getSelectedItem().toString());
			propiedadEditada.setPrecio(Float.parseFloat(agentePropWindow.textField_Precio.getText()));
			propiedadEditada.setNumero(agentePropWindow.textField_numero.getText());
			propiedadEditada.setPuerta(agentePropWindow.textField_Puerta.getText());
			propiedadEditada.setPiso(Integer.parseInt(agentePropWindow.textField_piso.getText()));
			propiedadEditada.setEscalera(agentePropWindow.textField_escalera.getText());
			
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
