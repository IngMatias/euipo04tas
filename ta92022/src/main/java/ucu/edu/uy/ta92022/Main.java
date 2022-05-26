package ucu.edu.uy.ta92022;

import ucu.edu.uy.tda.TArbolBB;
import ucu.edu.uy.tda.TElementoAB;
import ucu.edu.uy.util.ManejadorArchivosGenerico;
import ucu.edu.uy.tda.INodo;
import ucu.edu.uy.tda.Nodo;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        IAlmacen almacen = new Almacen("Almacen de Matias");
        
        // cargar los productos desde el archivo "altasprueba.txt"
        String[] altasPruebas = ManejadorArchivosGenerico.leerArchivo("altasPrueba.txt");
        
        int total = 0;

        for (int i = 0; i < altasPruebas.length; i++) {
            String[] detalleDeProducto = altasPruebas[i].split(",");
            if (detalleDeProducto.length == 4) {
                String codigo = detalleDeProducto[0];
                String nombre = detalleDeProducto[1];
                int precio = Integer.parseInt(detalleDeProducto[2]);
                int agregado = Integer.parseInt(detalleDeProducto[3]);

                Producto agregar = almacen.buscarPorCodigo(codigo);

                if (agregar == null) {
                    agregar = new Producto(codigo, nombre);
                    agregar.setPrecio(precio);
                    agregar.agergarStock(agregado);
                } else {
                    agregar.agergarStock(agregado);
                    agregar.setPrecio(precio);
                }

                almacen.insertarProducto(agregar);

                total += precio * agregado;
            }
        }
       
        System.out.println("El monto total agregado es:" + total);

        // listar los productos ordenados por codigo, junto con su cantidad existente
        System.out.println(almacen.imprimirProductos());

        //emitir el valor del stock
        System.out.println(almacen.valorDelStock());

        // simular las ventas a partir del archivo "ventaspruebas.txt"
        String[] ventasPrueba = ManejadorArchivosGenerico.leerArchivo("ventasPrueba.txt");

        total = 0;

        for (int i = 0; i < ventasPrueba.length; i++) {
            String[] detalleDeProducto = ventasPrueba[i].split(",");
            if (detalleDeProducto.length == 2) {
                String codigo = detalleDeProducto[0];
                int quitado = Integer.parseInt(detalleDeProducto[1]);

                Producto producto = almacen.buscarPorCodigo(codigo);
                if (producto != null) {
                    int primero = producto.getStock();
                    int restado = producto.restarStock(quitado);
                    if (restado > 0) {
                        total += (primero - restado) * producto.getPrecio();
                    }
                }
            }
        }
        System.out.println("El monto total vendido es:" + total);
        System.out.println(almacen.imprimirProductos());
        System.out.println(almacen.valorDelStock());

        // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
        String[] elimPrueba = ManejadorArchivosGenerico.leerArchivo("elimPrueba.txt");

        int stockAnterior = almacen.valorDelStock();

        for (int i = 0; i < elimPrueba.length; i++) {
            almacen.eliminarProducto(elimPrueba[i]);
        }
        
        int stockPosterior = almacen.valorDelStock();
        
        System.out.println("El monto total eliminado es:" + (stockAnterior - stockPosterior));
        System.out.println(almacen.valorDelStock());

        // listar los productos ordenados por codigo, junto con su cantidad existente
        

        
        //Ej 2
        String[] altas = ManejadorArchivosGenerico.leerArchivo("altas.txt");
        for(int i=0; i<altas.length; i++){
            String[] splitted = altas[i].split(",");
            if(splitted.length != 4){
                continue;
            }
            try {
            String codigo = splitted[0];
            String descripcion = splitted[1];
            int precio = Integer.parseInt(splitted[2]);
            int cantidad = Integer.parseInt(splitted[3]);

            Producto agregar = almacen.buscarPorCodigo(codigo);

            if (agregar == null) {
                agregar = new Producto(codigo, descripcion);
                agregar.setPrecio(precio);
                agregar.agergarStock(cantidad);
            } else {
                agregar.agergarStock(cantidad);
                agregar.setPrecio(precio);
            }

            almacen.insertarProducto(agregar);
                
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        //Primero cargo el archivo "altas.txt" aunque la letra no lo pida porque sino no se elimina nada
        System.out.println(almacen.imprimirProductos());

        String[] elim = ManejadorArchivosGenerico.leerArchivo("elim.txt");

        int stockAnterior2 = almacen.valorDelStock();
        try {
            for (int i = 0; i < elim.length; i++) {
                almacen.eliminarProducto(elim[i]);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        

        System.out.println(almacen.imprimirProductos());
        
        int stockPosterior2 = almacen.valorDelStock();
        
        System.out.println("El monto total eliminado es:" + (stockAnterior2 - stockPosterior2));
        System.out.println(almacen.valorDelStock());


        String[] Lineas_salida = new String[almacen.getProductos().cantElementos()]; //Hago el array del tamaño de la cantidad de elementos de la lista de equipos
            int contador = 0;
            Nodo<Producto> nodoProducto = almacen.getProductos().getPrimero();
            while(nodoProducto != null){
                String productoData = nodoProducto.getDato().getNombre() + "," + nodoProducto.getDato().getPrecio();
                Lineas_salida[contador] = productoData;
                contador += 1;
                nodoProducto = nodoProducto.getSiguiente();
                
            }
            ManejadorArchivosGenerico archivo = new ManejadorArchivosGenerico();
            ManejadorArchivosGenerico.escribirArchivo("productos.txt",Lineas_salida);

    }
}
