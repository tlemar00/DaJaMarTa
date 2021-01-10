/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dajamarta;

import javax.swing.JFrame;

import DAO.EmpleadobbddDAO;
import DAO.PropiedadesDAO;
import DAO.UsuariosDAO;
import loginWindow.LoginWindow;
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
    	LoginWindow window = LoginWindow.getInstance();

		window.setVisible(true);
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO code application logic here
        /*UsuariosDAO user = new UsuariosDAO();
        EmpleadobbddDAO emp = new EmpleadobbddDAO();
        PropiedadesDAO prop = new PropiedadesDAO();
        Usuarios u = user.obtenerUsuario("admin");
        if(u!=null){
            System.out.println(u.getContrasenia());
            Empleadobbdd e = emp.obtenerEmpleadoPorUser(u.getIdUsuario());
            System.out.println(e.getCategorias().getNombreCategoria());
            Propiedades[] p = prop.obtenerPropiedades();
            for(int i=0;i<p.length;i++){
                System.out.println(p[i].getUbicacion());
            }
        }*/
    }  
}
