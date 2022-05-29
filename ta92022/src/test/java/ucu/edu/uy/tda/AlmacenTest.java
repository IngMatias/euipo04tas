/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.tda;
import ucu.edu.uy.ta92022.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nnavarro
 */
public class AlmacenTest
{   
    private static Almacen almacen;
    private static Producto producto1;
    private static Producto producto2;

    public AlmacenTest()
    {
    }

    @BeforeAll
    public static void setUpClass()
    {
        almacen = new Almacen("almacen1");
        producto1 = new Producto("1", "producto1");
        producto2 = new Producto("2", "producto2");

    }

    /**
     * Test
     */
    @Test
    public void testAltaProductos()
    {
        assert almacen.getProductos().cantElementos() == 0;
        almacen.insertarProducto(producto1);
        almacen.insertarProducto(producto2);    
        assert almacen.getProductos().cantElementos() == 2;
    }

    @Test
    public void testAgregarStockProductos()
    {   
        producto1.agergarStock(10);
        almacen.insertarProducto(producto1);  
        assert almacen.buscarPorCodigo("1").getStock() == 10;
        almacen.agregarStock("1", 10);
        assert almacen.buscarPorCodigo("1").getStock() == 20;

    }

    @Test
    public void testRestarStockProductos()
    {   
        producto1.agergarStock(10);
        almacen.insertarProducto(producto1);  
        assert almacen.buscarPorCodigo("1").getStock() == 10;
        almacen.restarStock("1", 5);
        assert almacen.buscarPorCodigo("1").getStock() == 5;

    }

    @Test
    public void testEliminarProductos()
    {   
        almacen.insertarProducto(producto1);  
        assert almacen.getProductos().cantElementos() == 1;
        almacen.eliminarProducto("1");
        assert almacen.getProductos().cantElementos() == 0;

    }

 

}
