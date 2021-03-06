package modelo;
// Generated 14-ene-2021 21:40:33 by Hibernate Tools 4.3.1



/**
 * Propiedades generated by hbm2java
 */
public class Propiedades  implements java.io.Serializable {


     private int idPropiedad;
     private Clientes clientes;
     private Empleadobbdd empleadobbdd;
     private String nombre;
     private float precio;
     private String direccion;
     private String ciudad;
     private String provincia;
     private String numero;
     private String puerta;
     private int piso;
     private String escalera;
     private int vendido;
     private int reservado;
     private String imagen;
     private String descripcion;
     private Float tamanio;
     private String tipoPropiedad;

    public Propiedades() {
    }

	
    public Propiedades(int idPropiedad, Clientes clientes, Empleadobbdd empleadobbdd, String nombre, float precio, String direccion, String ciudad, String provincia, String numero, String puerta, int piso, String escalera, int vendido, int reservado) {
        this.idPropiedad = idPropiedad;
        this.clientes = clientes;
        this.empleadobbdd = empleadobbdd;
        this.nombre = nombre;
        this.precio = precio;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.numero = numero;
        this.puerta = puerta;
        this.piso = piso;
        this.escalera = escalera;
        this.vendido = vendido;
        this.reservado = reservado;
    }
    public Propiedades(int idPropiedad, Clientes clientes, Empleadobbdd empleadobbdd, String nombre, float precio, String direccion, String ciudad, String provincia, String numero, String puerta, int piso, String escalera, int vendido, int reservado, String imagen, String descripcion, Float tamanio, String tipoPropiedad) {
       this.idPropiedad = idPropiedad;
       this.clientes = clientes;
       this.empleadobbdd = empleadobbdd;
       this.nombre = nombre;
       this.precio = precio;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.provincia = provincia;
       this.numero = numero;
       this.puerta = puerta;
       this.piso = piso;
       this.escalera = escalera;
       this.vendido = vendido;
       this.reservado = reservado;
       this.imagen = imagen;
       this.descripcion = descripcion;
       this.tamanio = tamanio;
       this.tipoPropiedad = tipoPropiedad;
    }
   
    public int getIdPropiedad() {
        return this.idPropiedad;
    }
    
    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public Empleadobbdd getEmpleadobbdd() {
        return this.empleadobbdd;
    }
    
    public void setEmpleadobbdd(Empleadobbdd empleadobbdd) {
        this.empleadobbdd = empleadobbdd;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getPuerta() {
        return this.puerta;
    }
    
    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }
    public int getPiso() {
        return this.piso;
    }
    
    public void setPiso(int piso) {
        this.piso = piso;
    }
    public String getEscalera() {
        return this.escalera;
    }
    
    public void setEscalera(String escalera) {
        this.escalera = escalera;
    }
    public int getVendido() {
        return this.vendido;
    }
    
    public void setVendido(int vendido) {
        this.vendido = vendido;
    }
    public int getReservado() {
        return this.reservado;
    }
    
    public void setReservado(int reservado) {
        this.reservado = reservado;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Float getTamanio() {
        return this.tamanio;
    }
    
    public void setTamanio(Float tamanio) {
        this.tamanio = tamanio;
    }
    public String getTipoPropiedad() {
        return this.tipoPropiedad;
    }
    
    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }




}


