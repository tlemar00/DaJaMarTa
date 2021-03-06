package modelo;
// Generated 14-ene-2021 21:40:33 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

/**
 * Categorias generated by hbm2java
 */
public class Categorias  implements java.io.Serializable {


     private int idCategoria;
     private String nombreCategoria;
     private Set empleadobbdds = new HashSet(0);

    public Categorias() {
    }

	
    public Categorias(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }
    public Categorias(int idCategoria, String nombreCategoria, Set empleadobbdds) {
       this.idCategoria = idCategoria;
       this.nombreCategoria = nombreCategoria;
       this.empleadobbdds = empleadobbdds;
    }
   
    public int getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getNombreCategoria() {
        return this.nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public Set getEmpleadobbdds() {
        return this.empleadobbdds;
    }
    
    public void setEmpleadobbdds(Set empleadobbdds) {
        this.empleadobbdds = empleadobbdds;
    }




}


