/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.dajamarta.DAO;

import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Query;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.HibernateUtil;
import modelo.Usuarios;
/**
 *
 * @author DAVID
 */
public class UsuariosDAO {
    SessionFactory sf=null;
    Session session=null;
    Transaction tx =null;
    int cont=0;
    
    public UsuariosDAO(){
        sf=HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }
    
    public Usuarios obtenerUsuario(String user){
        Query query = session.createQuery("SELECT u FROM Usuarios u WHERE u.idUsuario=:param1");
        query.setParameter("param1",user);
        List res = query.list();
        if(res.isEmpty()) return null;
        else return (Usuarios) res.get(0);
    }
    
    public void borrar(int id){
        tx = session.beginTransaction();
        session.createQuery("Delete Usuarios p WHERE p.idUsuario=:param1").setParameter("param1",id).executeUpdate();
        tx.commit();
    }
    
    public void actualizarUsuario(Usuarios usuario) {
    // Hago la consulta HQL
        String consulta = "FROM Usuarios n WHERE n.idUsuario=:param1";
        Query query = session.createQuery(consulta);
        query.setParameter("param1",usuario.getIdUsuario());
        List<Usuarios> usuarios = query.list();
        // Inicio transaccion
        tx = session.beginTransaction();
        //Comprobar existencia
        if(!usuarios.isEmpty()){
              //Si existe lo actualizo
              //Establezco el id con el obtenido
              usuario.setIdUsuario(usuarios.get(0).getIdUsuario());
              //Quito la relacion del objeto de la base
              session.evict(usuarios.get(0));
              session.update(usuario);
              }
        else{
            //Si no existe lo guardo
            session.save(usuario);
        }
        tx.commit();
   }
}
