package es.unileon.dajamarta.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import es.unileon.dajamarta.PDF;
import es.unileon.dajamarta.DAO.CategoriasDAO;
import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.admin.AdminWindow;
import es.unileon.dajamarta.agenteProp.AgentePropWindow;
import es.unileon.dajamarta.agenteVentas.AgenteVentasWindow;
import modelo.Categorias;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;
import es.unileon.dajamarta.PDF;

public class ControlerAdminWindow implements ActionListener, KeyListener{
	private EmpleadobbddDAO empleadoDao;
	private UsuariosDAO usuarioDao;
	private AdminWindow adminWindow;
	private CategoriasDAO categoriaDao;
	private Empleadobbdd[] lista; //Lista con todos los empleados
	private NuevoUsuarioWindow nuevoUsuarioWindow;

	public ControlerAdminWindow(AdminWindow adminWindow)  {
		empleadoDao = new EmpleadobbddDAO();
		usuarioDao = new UsuariosDAO();
		categoriaDao = new CategoriasDAO();
		this.adminWindow = adminWindow;
		rellenaDatosComponentes();
	}
	
	public void rellenaDatosComponentes() {
		lista = empleadoDao.obtenerEmpleados();//Rellenamos lista con los empleados
		//Rellenamos la Combobox
		for(int i=0; i< lista.length; i++) {//Rellenamos la combobox
			adminWindow.comboBox.addItem(lista[i].getEmail());
		}
		adminWindow.comboBox_1.addItem("Administrador");
		adminWindow.comboBox_1.addItem("Propiedades");
		adminWindow.comboBox_1.addItem("Ventas");
	}
	
	//Recogemos los eventos que ocurren en la ventana
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos el objeto usuario según el nombre introducido
		//Usuarios u = usuarioDao.obtenerUsuario(adminWindow.userText.getText().toString());
		//No estamos recogiendo en ningun sitio lo de login y tal
		int categoria = 0;
		if(arg0.getActionCommand().equals("Buscar")) {
			adminWindow.campoNombre.setText(lista[adminWindow.comboBox.getSelectedIndex()].getNombre());
			adminWindow.campoApellido.setText(lista[adminWindow.comboBox.getSelectedIndex()].getApellido1());
			adminWindow.campoApellido2.setText(lista[adminWindow.comboBox.getSelectedIndex()].getApellido2());
			adminWindow.campoEmail.setText(lista[adminWindow.comboBox.getSelectedIndex()].getEmail());
			adminWindow.campoNif.setText(lista[adminWindow.comboBox.getSelectedIndex()].getNifnie());
			categoria = lista[adminWindow.comboBox.getSelectedIndex()].getCategorias().getIdCategoria();//Guardamos el id de categoria
			adminWindow.comboBox_1.setSelectedIndex(categoria-1);
			
		}else if(arg0.getActionCommand().equals("Editar")) {
			System.out.println("Boton editar");
			Empleadobbdd empleadoEditado = lista[adminWindow.comboBox.getSelectedIndex()];
			Categorias cat = categoriaDao.obtenerCategoriaId(adminWindow.comboBox.getSelectedIndex()+1);
			
			//Creamos objeto con los nuevos datos
			empleadoEditado.setNombre(adminWindow.campoNombre.getText());
			empleadoEditado.setApellido1(adminWindow.campoApellido.getText());
			empleadoEditado.setApellido2(adminWindow.campoApellido2.getText());
			empleadoEditado.setEmail(adminWindow.campoEmail.getText());
			empleadoEditado.setNifnie(adminWindow.campoNif.getText());
			empleadoEditado.setCategorias(cat);
			//Lo enviamos a la bbdd
			empleadoDao.actualizarEmpleado(empleadoEditado);
		}else if(arg0.getActionCommand().equals("Crear nuevo empleado")) {
			NuevoUsuarioWindow.getInstance();
		}else if(arg0.getActionCommand().equals("Eliminar")) {
			Empleadobbdd empleadoAEliminar = lista[adminWindow.comboBox.getSelectedIndex()];
			Usuarios usuarioAEliminar = empleadoAEliminar.getUsuarios();
			usuarioDao.borrar(usuarioAEliminar.getIdUsuario());
			empleadoDao.borrar(empleadoAEliminar.getIdEmpleado());
			
		}else if(arg0.getActionCommand().equals("Ayuda")) {
			JOptionPane.showMessageDialog(null, "En esta pagina podras: \n "
					+ "\n Consultar Usuarios: \n 1) Elija un usuario \n 2) Se rellenaran los campos con los datos del usuario seleccionado \n"
					+ "\n Modificar Usuarios: \n 1) Elija un usuario \n 2) Modifica el campo. \n 3) Pulsa en el boton de 'Modificar'\n "
					+ "\n Eliminar Usuarios: \n 1) Elija un usuario \n 2) Pulse en el boton de 'Eliminar'\n "
					+ "\n Agregar Usuarios: \n 1) Ir a opciones \n 2) Seleccionar 'Crear Nuevo Empleado' \n 3) Rellenar todos los campos \n 4) Pulsar en el boton 'Crear empleado'", null, JOptionPane.INFORMATION_MESSAGE);
		
		}else if(arg0.getActionCommand().equals("Descargar PDF empleados")) {
			try {
				PDF.crearEmpleados();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
