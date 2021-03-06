package model;
// Generated 24/05/2019 03:33:36 PM by Hibernate Tools 4.3.1


import dao.categoriaDao;
import dao.categoriaDaoImplement;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private int idProducto;
     private Categoria categoria;
     private String nombre;
     private String nombreCategoria;
     private String descripcion;
     private Double precio;
     private Integer stock;
     private String image;
     @Min(0)
     @Max(90)
     private Integer descuento;
     private Set<Detalle> detalles = new HashSet<Detalle>(0);

    public Producto() {
        categoria = new Categoria();
    }

	
    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Producto(int idProducto, Categoria categoria, String nombre, String descripcion, Double precio, Integer stock, String image, Integer descuento, Set<Detalle> detalles) {
       this.idProducto = idProducto;
       this.categoria = categoria;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.precio = precio;
       this.stock = stock;
       this.image = image;
       this.descuento = descuento;
       this.detalles = detalles;
    }
   
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Integer getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }
    public Set<Detalle> getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(Set<Detalle> detalles) {
        this.detalles = detalles;
    }

    /**
     * @return the nombreCategoria
     */
    public String getNombreCategoria() {
        categoriaDao dao = new categoriaDaoImplement();
        nombreCategoria = dao.select(categoria);
        return nombreCategoria;
    }

    /**
     * @param nombreCategoria the nombreCategoria to set
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }




}


