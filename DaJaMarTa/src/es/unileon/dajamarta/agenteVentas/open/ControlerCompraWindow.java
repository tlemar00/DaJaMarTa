package es.unileon.dajamarta.agenteVentas.open;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import javax.swing.JFrame;

import es.unileon.dajamarta.DAO.ClientesDAO;
import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import modelo.Clientes;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;

public class ControlerCompraWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private CompraWindow compraWindow;
	private ClientesDAO clienteDao;
	private PropiedadesDAO propiedadDao;
	private Empleadobbdd[] lista; //Lista con todos los empleados
	protected int idProp;

	public ControlerCompraWindow(CompraWindow compraWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		this.compraWindow = compraWindow;
		idProp = compraWindow.idProp;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		lista = empleadoDao.obtenerEmpleados();//Rellenamos lista con los empleados
		//Rellenamos la Combobox
		for(int i=0; i< lista.length; i++) {//Rellenamos la combobox
			//adminWindow.comboBox.addItem(lista[i].getEmail());
		}
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand().equals("Registrar compra")) {
			//Crear cliente
			
			clienteDao = new ClientesDAO();
			empleadoDao = new EmpleadobbddDAO();
			propiedadDao = new PropiedadesDAO();
			Clientes c = new Clientes();
			Empleadobbdd e = new Empleadobbdd();
			Propiedades p = new Propiedades();
			
			e = empleadoDao.obtenerEmpleadoPorUser(compraWindow.userField.getText());//Obtenemos el empleado a partir del user obtenido
			p = propiedadDao.obtenerPropiedadPorId(idProp);//ID de la propiedad
			c.setIdCliente(0);
			c.setNombre(compraWindow.nombreField.getText());
			c.setApellido1(compraWindow.apellido1Field.getText());
			c.setApellido2(compraWindow.apellido2Field.getText());
			c.setNifnie(compraWindow.nifField.getText());
			c.setTelefono(compraWindow.movilField.getText());
			clienteDao.crearCliente(c);
			p.setClientes(c);//Cliente que ha comprado
			p.setEmpleadobbdd(e);//Empleado que ha hecho la venta
			propiedadDao.actualizarPropiedad(p);
		}else if(arg0.getActionCommand().equals("Reservar")) {
			propiedadDao = new PropiedadesDAO();
			Propiedades p = new Propiedades();
			p = propiedadDao.obtenerPropiedadPorId(idProp);//ID de la propiedad
			
			p.setReservado(1);
			
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
