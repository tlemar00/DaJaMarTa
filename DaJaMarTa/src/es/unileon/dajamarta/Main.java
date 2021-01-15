/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.dajamarta;

import java.io.IOException;

import javax.swing.JFrame;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import es.unileon.dajamarta.DAO.ClientesDAO;
import es.unileon.dajamarta.DAO.EmpleadobbddDAO;
import es.unileon.dajamarta.DAO.PropiedadesDAO;
import es.unileon.dajamarta.DAO.UsuariosDAO;
import es.unileon.dajamarta.login.LoginWindow;
import modelo.Clientes;
import modelo.Empleadobbdd;
import modelo.Propiedades;
import modelo.Usuarios;


/**
 *
 * @author DAVID
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	LoginWindow.getInstance();
    	/*try {
			CrearExcel.crearEmpleados();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }  
}
