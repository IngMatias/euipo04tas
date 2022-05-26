package ucu.edu.uy.ta92022;


import java.util.ArrayList;
import ucu.edu.uy.tda.IElementoAB;
import ucu.edu.uy.tda.ILista;
import ucu.edu.uy.tda.INodo;
import ucu.edu.uy.tda.Nodo;
import ucu.edu.uy.tda.TArbolBB;
import ucu.edu.uy.tda.TElementoAB;


public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;

    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB();
    }

    public ILista<Producto> getProductos(){
        return this.productos.inOrden();
    }
    
    @Override
    public void insertarProducto(Producto unProducto) {
        this.productos.insertar(new TElementoAB(unProducto.getEtiqueta(), unProducto));
    }

    @Override
    public String imprimirProductos() {
        ILista<Producto> productos = this.productos.inOrden();
        ArrayList<String> toReturn = new ArrayList();
        INodo<Producto> aux = productos.getPrimero();
        while(aux != null) {
            Producto p = aux.getDato();
            toReturn.add(p.getEtiqueta() + p.getNombre() + p.getStock() + p.getPrecio()+ "\n");
            aux = aux.getSiguiente();
        }
        return toReturn.toString();
    }

    @Override
    public String imprimirProductosOrdenados() {
        ILista<Producto> productos = this.productos.inOrden();
        ArrayList<String> toReturn = new ArrayList();
        INodo<Producto> aux = productos.getPrimero();
        while(aux != null) {
            Nodo<Producto> aux2 = new Nodo<Producto>(aux.getDato().getNombre(),aux.getDato());
            Producto p = aux2.getDato();
            toReturn.add(p.getEtiqueta() + p.getNombre() + p.getStock() + p.getPrecio()+ "\n");
            aux = aux.getSiguiente();
        }
        return toReturn.toString();
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        IElementoAB<Producto> buscado = this.productos.buscar(clave);
        if (buscado == null) {
            return false;
        }
        buscado.getDatos().agergarStock(cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        IElementoAB<Producto> p = this.productos.buscar(clave);
        return p == null ? null : p.getDatos();
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        if (this.productos.buscar(clave) != null) {
            this.productos.eliminar(clave);
            return true;
        }
        return false;
    }
    
    public int valorDelStock() {
        ILista<Producto> productos = this.productos.inOrden();
        int total = 0;
        INodo<Producto> aux = productos.getPrimero();
        while(aux != null) {
            total += aux.getDato().getPrecio() * aux.getDato().getStock();
            aux = aux.getSiguiente();
        }
        return total;
    }


   
 
   


  

   

   

   

}
