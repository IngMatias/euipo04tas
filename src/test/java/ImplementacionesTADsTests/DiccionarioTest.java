package ImplementacionesTADsTests;

import ITADs.IDiccionario;
import ImplementacionesTADs.Diccionario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiccionarioTest {

    private IDiccionario<String> diccionarioVacio;
    private IDiccionario<Integer> diccionarioCinco;

    @BeforeEach
    public void setUp() {
        this.diccionarioVacio = new Diccionario();
        this.diccionarioCinco = new Diccionario();
    }

    @Test
    public void esVacioDiccionarioVacio() {
        assertTrue(this.diccionarioVacio.esVacio());
    }

    @Test
    public void consultasDiccionarioVacio() {
        assertEquals(null, this.diccionarioVacio.obtener(157));
        assertEquals(null, this.diccionarioVacio.obtener(1095));
        assertEquals(null, this.diccionarioVacio.obtener("sdaasd"));
    }
    
    @Test
    public void agregarCincoYConsultarCinco() {
        this.diccionarioCinco.agregar(1, 6);
        this.diccionarioCinco.agregar(2, 7);
        this.diccionarioCinco.agregar(3, 8);
        this.diccionarioCinco.agregar(4, 9);
        this.diccionarioCinco.agregar(5, 10);
        
        assertEquals(6, this.diccionarioCinco.obtener(1));
        assertEquals(7, this.diccionarioCinco.obtener(2));
        assertEquals(8, this.diccionarioCinco.obtener(3));
        assertEquals(9, this.diccionarioCinco.obtener(4));
        assertEquals(10, this.diccionarioCinco.obtener(5));
    }
    
    @Test
    public void agregarCincoYAgregarCincoMas() {
        this.diccionarioCinco.agregar(1, 6);
        this.diccionarioCinco.agregar(2, 7);
        this.diccionarioCinco.agregar(3, 8);
        this.diccionarioCinco.agregar(4, 9);
        this.diccionarioCinco.agregar(5, 10);
        
        assertEquals(6, this.diccionarioCinco.obtener(1));
        assertEquals(7, this.diccionarioCinco.obtener(2));
        assertEquals(8, this.diccionarioCinco.obtener(3));
        assertEquals(9, this.diccionarioCinco.obtener(4));
        assertEquals(10, this.diccionarioCinco.obtener(5));
        
        assertFalse(this.diccionarioCinco.agregar(1, 11));
        assertFalse(this.diccionarioCinco.agregar(2, 12));
        assertFalse(this.diccionarioCinco.agregar(3, 13));
        assertFalse(this.diccionarioCinco.agregar(4, 14));
        assertFalse(this.diccionarioCinco.agregar(5, 15));
    }
    
    @Test
    public void agregarCincoYEliminarCinco() {
        this.diccionarioCinco.agregar(1, 6);
        this.diccionarioCinco.agregar(2, 7);
        this.diccionarioCinco.agregar(3, 8);
        this.diccionarioCinco.agregar(4, 9);
        this.diccionarioCinco.agregar(5, 10);
        
        assertEquals(8, this.diccionarioCinco.eliminar(3));
        assertEquals(6, this.diccionarioCinco.eliminar(1));
        assertEquals(7, this.diccionarioCinco.eliminar(2));
        assertEquals(10, this.diccionarioCinco.eliminar(5));
        assertEquals(9, this.diccionarioCinco.eliminar(4));
        
        assertTrue(this.diccionarioCinco.esVacio());
    }
}
