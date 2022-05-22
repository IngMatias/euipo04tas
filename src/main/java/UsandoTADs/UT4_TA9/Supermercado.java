package UsandoTADs.UT4_TA9;

import ITADs.IArbolBB;
import Utils.ManejadorArchivosGenerico;
import ImplementacionesTADs.ArbolBB;

public class Supermercado {

    private final IArbolBB<Producto> arbol;

    public Supermercado() {
        this.arbol = new ArbolBB();
    }

    public void agregarProducto(Producto nuevoProducto) {
        this.arbol.insertar(nuevoProducto.getId(), nuevoProducto);
    }

    public void agregarStock(int stockAAgregar, Comparable id) throws ProductoNoEncontradoException {
        Producto aux = this.arbol.buscar(id);
        if (aux == null) {
            throw new ProductoNoEncontradoException();
        }
        aux.agregarStock(stockAAgregar);
    }

    public float reducirStock(int stockAReducir, Comparable id) throws ProductoNoEncontradoException {
        Producto aux = this.arbol.buscar(id);
        if (aux == null) {
            throw new ProductoNoEncontradoException();
        }
        int viejoStock = aux.getStock();
        int nuevoStock = aux.reducirStock(stockAReducir);
        float precio = aux.getPrecio();
        return (viejoStock - nuevoStock) * precio;
    }

    public int getStock(Comparable id) throws ProductoNoEncontradoException {
        Producto aux = this.arbol.buscar(id);
        if (aux == null) {
            throw new ProductoNoEncontradoException();
        }
        return aux.getStock();
    }

    public float eliminarProducto(Comparable id) throws ProductoNoEncontradoException {
        Producto aux = this.arbol.buscar(id);
        if (aux == null) {
            throw new ProductoNoEncontradoException();
        }
        Producto eliminado = aux;
        this.arbol.eliminar(id);
        return eliminado.getPrecio() * eliminado.getStock();
    }

    public String listar() {
        return this.arbol.imprimirInOrden();
    }

    public float actualizarAltas() throws ProductoNoEncontradoException, FormatoInvalidoArchivoDeEntrada {
        float total = 0;
        String[] paraActualizar = ManejadorArchivosGenerico.leerArchivo("\\src\\main\\java\\UsandoTADs\\UT3_TA1_TA2_2\\altas.txt");
        for (String producto : paraActualizar) {
            String[] splited = producto.split(",");
            if (splited.length != 4) {
                throw new FormatoInvalidoArchivoDeEntrada();
            }
            String id = splited[0];
            String nombre = splited[1];
            float precio = Float.parseFloat(splited[2]);
            int agregarStock = Integer.parseInt(splited[3]);
            if (this.arbol.buscar(id) == null) {
                this.agregarProducto(new Producto(id, nombre, precio));
            }
            this.agregarStock(agregarStock, id);
            total += precio * agregarStock;
        }
        return total;
    }

    public float actualizarEliminaciones() throws ProductoNoEncontradoException, FormatoInvalidoArchivoDeEntrada {
        float total = 0;
        String[] paraActualizar = ManejadorArchivosGenerico.leerArchivo("\\src\\main\\java\\UsandoTADs\\UT3_TA1_TA2_2\\eliminaciones.txt");
        for (String producto : paraActualizar) {
            String[] splited = producto.split(",");
            if (splited.length != 1) {
                throw new FormatoInvalidoArchivoDeEntrada();
            }
            String id = splited[0];
            total += this.eliminarProducto(id);
        }
        return total;
    }

    public float actualizarVentas() throws ProductoNoEncontradoException, FormatoInvalidoArchivoDeEntrada {
        float total = 0;
        String[] paraActualizar = ManejadorArchivosGenerico.leerArchivo("\\src\\main\\java\\UsandoTADs\\UT3_TA1_TA2_2\\ventas.txt");
        for (String producto : paraActualizar) {
            String[] splited = producto.split(",");
            if (splited.length != 2) {
                throw new FormatoInvalidoArchivoDeEntrada();
            }
            String id = splited[0];
            int aVender = Integer.parseInt(splited[1]);
            total += this.reducirStock(aVender, id);
        }
        return total;
    }
}
