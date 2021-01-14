/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.List;
import modelo.Clientes;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author DAVID
 */
public class ClientesDAO {
    SessionFactory sf=null;
    Session session=null;
    Transaction tx =null;
    
    public ClientesDAO(){
        sf=HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }
    
    public void borrar(int id){
        tx = session.beginTransaction();
        session.createQuery("Delete Clientes p WHERE p.idCliente=:param1").setParameter("param1",id).executeUpdate();
        tx.commit();
    }
    
    public void crearCliente(Clientes cliente){
        String consulta2 = "FROM Clientes n";
        Query query2 = session.createQuery(consulta2);
        List<Clientes> clientes = query2.list();
        tx = session.beginTransaction();
        cliente.setIdCliente(clientes.size());
        session.save(cliente);
        tx.commit();
    }
}
