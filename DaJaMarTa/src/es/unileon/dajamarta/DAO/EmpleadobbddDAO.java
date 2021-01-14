/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Empleadobbdd;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author DAVID
 */
public class EmpleadobbddDAO {
    SessionFactory sf=null;
    Session session=null;
    Transaction tx =null;
    
    public EmpleadobbddDAO(){
        sf=HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }
    
    public Empleadobbdd obtenerEmpleadoPorUser(String user){
        Query query = session.createQuery("SELECT t FROM Empleadobbdd t WHERE t.usuarios.idUsuario=:param1");
        query.setParameter("param1",user);
        List res = query.list();
        return (Empleadobbdd) res.get(0);
    }
    
    public void borrar(int id){
        tx = session.beginTransaction();
        session.createQuery("Delete Empleadobbdd p WHERE p.idEmpleado=:param1").setParameter("param1",id).executeUpdate();
        tx.commit();
    }
    
    public void actualizarEmpleado(Empleadobbdd empleado) {
    // Hago la consulta HQL
        String consulta = "FROM Empleadobbdd n WHERE n.idEmpleado=:param1";
        Query query = session.createQuery(consulta);
        query.setParameter("param1",empleado.getIdEmpleado());
        List<Empleadobbdd> empleados = query.list();
        String consulta2 = "FROM Empleadobbdd n";
        Query query2 = session.createQuery(consulta2);
        List<Empleadobbdd> empleados2 = query2.list();
        // Inicio transaccion
        tx = session.beginTransaction();
        //Comprobar existencia
        if(!empleados.isEmpty()){
              //Si existe lo actualizo
              //Establezco el id con el obtenido
              empleado.setIdEmpleado(empleados.get(0).getIdEmpleado());
              //Quito la relacion del objeto de la base
              session.evict(empleados.get(0));
              session.update(empleado);
              }
        else{
            empleado.setIdEmpleado(empleados2.size());
             //Si no existe lo guardo
            session.save(empleado);
        }
        tx.commit();
   }
}
