/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.dajamarta;
import es.unileon.dajamarta.DAO.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import modelo.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author DAVID
 */
public class CrearExcel {
    public static void crearEmpleados() throws InvalidFormatException, IOException {
        File excel = new File("Empleados.xlsx");      
        Row row;
        Empleadobbdd[] empleados;
        EmpleadobbddDAO eDAO = new EmpleadobbddDAO();
        try{
            InputStream file = new FileInputStream(excel);
            // leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            //obtener la hoja que se va leer
            XSSFSheet sheet;
            sheet = worbook.getSheetAt(0);
            Iterator<Row> rowIterator;
            rowIterator = sheet.iterator();
            row = rowIterator.next();
            row.getCell(0).setCellValue("IdEmpleado");
            row.getCell(1).setCellValue("Nombre");
            row.getCell(2).setCellValue("Apellido 1");
            row.getCell(3).setCellValue("Apellido 2");
            row.getCell(4).setCellValue("NIFNIE");
            row.getCell(5).setCellValue("Email");
            row.getCell(6).setCellValue("IdUsuario");
            row.getCell(7).setCellValue("IdCategoria");
            empleados = eDAO.obtenerEmpleados();
            for(int i = 0; i < empleados.length; i ++){
                row = rowIterator.next();
                row.getCell(0).setCellValue(empleados[i].getIdEmpleado());
                row.getCell(1).setCellValue(empleados[i].getNombre());
                row.getCell(2).setCellValue(empleados[i].getApellido1());
                row.getCell(3).setCellValue(empleados[i].getApellido2());
                row.getCell(4).setCellValue(empleados[i].getNifnie());
                row.getCell(5).setCellValue(empleados[i].getEmail());
                row.getCell(6).setCellValue(empleados[i].getUsuarios().getIdUsuario());
                row.getCell(7).setCellValue(empleados[i].getCategorias().getNombreCategoria());
            }
            HibernateUtil.shutdown();
            file.close();
        }
        catch (IOException e) {
            e.getMessage();
	}
    }
    public static void crearPropiedades() throws InvalidFormatException, IOException {
        File excel = new File("Propiedades.xlsx");
        Row row;
        Propiedades[] propiedades;
        PropiedadesDAO pDAO = new PropiedadesDAO();
        try{
            InputStream file = new FileInputStream(excel);
            // leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            //obtener la hoja que se va leer
            XSSFSheet sheet;
            sheet = worbook.getSheetAt(0);
            Iterator<Row> rowIterator;
            rowIterator = sheet.iterator();
            row = rowIterator.next();
            row.getCell(0).setCellValue("IdPropiedad");
            row.getCell(1).setCellValue("Nombre");
            row.getCell(2).setCellValue("Precio");
            row.getCell(3).setCellValue("Direccion");
            row.getCell(4).setCellValue("Ciudad");
            row.getCell(5).setCellValue("Provincia");
            row.getCell(6).setCellValue("Numero");
            row.getCell(7).setCellValue("Puerta");
            row.getCell(8).setCellValue("Piso");
            row.getCell(9).setCellValue("Escalera");
            row.getCell(10).setCellValue("Vendido");
            row.getCell(11).setCellValue("Reservado");
            row.getCell(12).setCellValue("Imagen");
            row.getCell(13).setCellValue("Descripcion");
            row.getCell(14).setCellValue("Tamaño");
            row.getCell(15).setCellValue("TipoPropiedad");
            row.getCell(16).setCellValue("IdTrabajador");
            row.getCell(17).setCellValue("IdCliente");
            propiedades = pDAO.obtenerPropiedades();
            for(int i = 0; i < propiedades.length; i ++){
                row = rowIterator.next();
                row.getCell(0).setCellValue(propiedades[i].getIdPropiedad());
                row.getCell(1).setCellValue(propiedades[i].getNombre());
                row.getCell(2).setCellValue(propiedades[i].getPrecio());
                row.getCell(3).setCellValue(propiedades[i].getDireccion());
                row.getCell(4).setCellValue(propiedades[i].getCiudad());
                row.getCell(5).setCellValue(propiedades[i].getProvincia());
                row.getCell(6).setCellValue(propiedades[i].getNumero());
                row.getCell(7).setCellValue(propiedades[i].getPuerta());
                row.getCell(8).setCellValue(propiedades[i].getPiso());
                row.getCell(9).setCellValue(propiedades[i].getEscalera());
                row.getCell(10).setCellValue(propiedades[i].getVendido());
                row.getCell(11).setCellValue(propiedades[i].getReservado());
                row.getCell(12).setCellValue(propiedades[i].getImagen());
                row.getCell(13).setCellValue(propiedades[i].getDescripcion());
                row.getCell(14).setCellValue(propiedades[i].getTamanio());
                row.getCell(15).setCellValue(propiedades[i].getTipoPropiedad());
                row.getCell(16).setCellValue(propiedades[i].getEmpleadobbdd().getIdEmpleado());
                row.getCell(17).setCellValue(propiedades[i].getClientes().getIdCliente());
            }
            HibernateUtil.shutdown();
            file.close();
        }
        
        catch (IOException e) {
            e.getMessage();
	}
    }
}
