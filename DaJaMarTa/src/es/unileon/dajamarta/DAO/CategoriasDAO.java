package es.unileon.dajamarta.DAO;

import java.util.List;
import modelo.Categorias;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DAVID
 */
public class CategoriasDAO {
    SessionFactory sf=null;
    Session session=null;
    Transaction tx =null;
    public CategoriasDAO(){
        sf=HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }
    public Categorias obtenerCategoriaId(int id){
        Query query = session.createQuery("SELECT c FROM Categorias c WHERE c.idCategoria=:param1");
        query.setParameter("param1",id);
        List lista = query.list();
        return (Categorias) lista.get(0);
    }
}