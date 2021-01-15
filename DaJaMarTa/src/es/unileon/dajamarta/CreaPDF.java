/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dajamarta;

import DAO.EmpleadobbddDAO;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import modelo.*;
/**
 *
 * @author DAVID
 */
public class CreaPDF {
    static void crearEmpleados() throws FileNotFoundException{
        PdfWriter writer = new PdfWriter("Empleados.pdf");
        PdfDocument pdfDoc = new PdfDocument(writer);
        Empleadobbdd[] empleados;
        EmpleadobbddDAO eDAO = new EmpleadobbddDAO();
        try (Document doc = new Document(pdfDoc, PageSize.LETTER)) {
            Table tabla1 = new Table(1);
            tabla1.setWidth(500);
            Cell cell1 = new Cell();
            cell1.setBorder(new SolidBorder(1));
            cell1.setWidth(250);
            cell1.setTextAlignment(TextAlignment.CENTER);
            empleados = eDAO.obtenerEmpleados();
            for (Empleadobbdd empleado : empleados) {
                cell1.add(new Paragraph("Id del Empleado: " + empleado.getIdEmpleado()));
                cell1.add(new Paragraph("Nombre: " + empleado.getNombre()));
                cell1.add(new Paragraph("Apellidos: " + empleado.getApellido1() + " " + empleado.getApellido2()));
                cell1.add(new Paragraph("Documento de Identidad: " + empleado.getNifnie()));
                cell1.add(new Paragraph("Nombre de usuario para BBDD: " + empleado.getUsuarios().getIdUsuario()));
                cell1.add(new Paragraph("Categoria de empleado: " + empleado.getCategorias().getNombreCategoria()));
                tabla1.addCell(cell1);
                cell1 = new Cell();
            }
             doc.add(tabla1);
             HibernateUtil.shutdown();
        }
    }
}
