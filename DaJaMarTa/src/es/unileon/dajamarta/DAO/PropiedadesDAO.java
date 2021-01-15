/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.dajamarta.DAO;

import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import javax.imageio.spi.ServiceRegistry;

import modelo.Clientes;
import modelo.HibernateUtil;
import org.hibernate.Query;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import modelo.Propiedades;
 import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author DAVID
 */
public class PropiedadesDAO {
    SessionFactory sf=null;
    Session session=null;
    Transaction tx =null;
    
    public PropiedadesDAO(){
        sf=HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }
    
    public void crearPropiedad(Propiedades propiedad){
    	
        String consulta2 = "FROM Clientes n";
        Query query2 = session.createQuery(consulta2);
        List<Clientes> clientes = query2.list();
        tx = session.beginTransaction();
        propiedad.setIdPropiedad(clientes.size());
        session.save(propiedad);
        tx.commit();
    }

    public Propiedades[] obtenerPropiedadesNoVendidas(int id){
        Query query = session.createQuery("SELECT p FROM Propiedades p WHERE p.vendido=:param1");
        query.setParameter("param1",id);
        List res = query.list();
        Propiedades[] miarray = new Propiedades[res.size()];
        return miarray = (Propiedades[]) res.toArray(miarray);
    }
    
    public Propiedades obtenerPropiedadPorId(int id){
        Query query = session.createQuery("SELECT t FROM Propiedades t WHERE t.idPropiedad=:param1");
        query.setParameter("param1",id);
        List res = query.list();
        return (Propiedades) res.get(0);
    }
    
    public Propiedades[] obtenerPropiedades(){
        Query query = session.createQuery("SELECT p FROM Propiedades p");
        List res = query.list();
        Propiedades[] miarray = new Propiedades[res.size()];
        return miarray = (Propiedades[]) res.toArray(miarray);
    }
    
    public void borrar(int id){
        tx = session.beginTransaction();
        session.createQuery("Delete Propiedades p WHERE p.idPropiedad=:param1").setParameter("param1",id).executeUpdate();
        tx.commit();
    } 
    
    public void actualizarPropiedad(Propiedades propiedad) {
    // Hago la consulta HQL
        String consulta = "FROM Propiedades n WHERE n.idPropiedad=:param1";
        Query query = session.createQuery(consulta);
        query.setParameter("param1",propiedad.getIdPropiedad());
        List<Propiedades> propiedades = query.list();
        String consulta2 = "FROM Propiedades n";
        Query query2 = session.createQuery(consulta2);
        List<Propiedades> propiedades2 = query2.list();
        // Inicio transaccion
        tx = session.beginTransaction();
        //Comprobar existencia
        if(!propiedades.isEmpty()){
              //Si existe lo actualizo
              //Establezco el id con el obtenido
              propiedad.setIdPropiedad(propiedades.get(0).getIdPropiedad());
              //Quito la relacion del objeto de la base
              session.evict(propiedades.get(0));
              session.update(propiedad);
              }
        else{
            propiedad.setIdPropiedad(propiedades2.size());
             //Si no existe lo guardo
            session.save(propiedad);
        }
        tx.commit();
   }
}
