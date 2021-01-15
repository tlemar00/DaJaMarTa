package es.unileon.dajamarta.agenteVentas;

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
			agenteVentasWindow.list.add(lista[i].getIdPropiedad()+"."+lista[i].getTipoPropiedad()+" en calle "+lista[i].getDireccion()+" nÃºmero "+lista[i].getNumero());
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		String id = Character.toString(agenteVentasWindow.list.getSelectedItem().charAt(0));
		String segundoValor = null;
		if(agenteVentasWindow.list.getSelectedItem().charAt(1)!='.') {
			segundoValor = Character.toString(agenteVentasWindow.list.getSelectedItem().charAt(1));
			id = id+segundoValor;
		} else if(arg0.getActionCommand().equals("Ayuda")) {
			JOptionPane.showMessageDialog(null, "En esta pÃ¡gina podrÃ¡s: \n "
					+ "\n Reservar propiedad: \n 1) Elije la propiedad \n 2) Selecciona el botÃ³n 'Reservar propiedad' \n"
					+ "\n Vender propiedad: \n 1) Elije la propiedad \n 2) Selecciona el botÃ³n 'Vender propiedad' \n 3) Rellena los datos del comprador", null, JOptionPane.INFORMATION_MESSAGE);
		}
		
		PropiedadWindow.getInstance(Integer.parseInt(id));
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
