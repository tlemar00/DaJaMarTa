package es.unileon.dajamarta.agenteVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import es.unileon.dajamarta.agenteVentas.AgenteVentasWindow;
import es.unileon.dajamarta.agenteVentas.open.PropiedadWindow;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerAgenteVentasWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private AgenteVentasWindow agenteVentasWindow;
	private PropiedadesDAO  propiedadDao;
	private PropiedadWindow propiedadWindow;
	private Propiedades[] lista; //Lista con todas las propiedades

	public ControlerAgenteVentasWindow(AgenteVentasWindow agenteVentasWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		propiedadDao = new PropiedadesDAO();
		this.agenteVentasWindow = agenteVentasWindow;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		lista = propiedadDao.obtenerPropiedades();//Rellenamos lista con los empleados
		//Rellenamos la Combobox
		for(int i=0; i< lista.length; i++) {//Rellenamos la lista
			agenteVentasWindow.list.add(lista[i].getIdPropiedad()+"."+lista[i].getTipoPropiedad()+" en calle "+lista[i].getDireccion()+" número "+lista[i].getNumero());
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//HAY QUE CAMBIAR ESTO SI QUEREMOS MÁS DE 10 PROPIEDADES
		if(arg0.getActionCommand().equals("Ver propiedad")) {
			PropiedadWindow.getInstance(Character.getNumericValue(agenteVentasWindow.list.getSelectedItem().charAt(0)));
			//System.out.println(Character.getNumericValue(agenteVentasWindow.list.getSelectedItem().charAt(0)));
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
