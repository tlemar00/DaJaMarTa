package es.unileon.dajamarta.agenteVentas.open;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerPropiedadWindow implements ActionListener, KeyListener{
	private PropiedadesDAO propiedadDao;
	private PropiedadWindow propiedadWindow;
	private Propiedades[] lista; //Lista con todos los empleados
	private EmpleadobbddDAO empleadoDao;
	private Propiedades propiedad;
	protected int idProp;

	public ControlerPropiedadWindow(PropiedadWindow propiedadWindow)  {
		propiedadDao = new PropiedadesDAO();
		//Creamos la LoginWindow
		this.propiedadWindow = propiedadWindow;
		idProp = propiedadWindow.idProp;
		rellenaDatosComponentes();
		
	}
	
	public void rellenaDatosComponentes() {
		
		//Rellenamos la Combobox
		/*for(int i=0; i< lista.length; i++) {//Rellenamos la combobox
			//propiedadWindow.comboBox.addItem(lista[i].getEmail());
		}*/
		//Obtener la propiedad
		propiedad = propiedadDao.obtenerPropiedadPorId(0);
		propiedadWindow.lblTitulo.setText(propiedad.getTipoPropiedad()+" en calle "+propiedad.getDireccion()+" número "+propiedad.getNumero());
		propiedadWindow.textArea.setText(propiedad.getDescripcion());
		propiedadWindow.dimensionField.setText(String.valueOf(propiedad.getTamanio()));
		propiedadWindow.precioField.setText(String.valueOf(propiedad.getPrecio()));
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Marcar como vendida")) {
			CompraWindow.getInstance(idProp);
		} else if (arg0.getActionCommand().equals("Reservar propiedad")) {
			
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
