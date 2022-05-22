package ImplementacionesTADsTests;

import ITADs.IPila;
import ImplementacionesTADs.Pila;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PilaTests {

    private IPila<String> pilaVacia;
    private IPila<Integer> primerosCinco;

    @BeforeEach
    public void setUp() {
        this.pilaVacia = new Pila();
        this.primerosCinco = new Pila();
    }

    @Test
    public void pilaVaciaEsVacia() {
        assertTrue(this.pilaVacia.esVacia());
    }
    
    @Test
    public void desapilarVacia() {
        assertNull(this.pilaVacia.desapilar());
    }
    
    @Test
    public void topeVacia() {
        assertNull(this.pilaVacia.tope());
    }
    
    @Test
    public void apilarYDesapilarCinco() {
        this.primerosCinco.apilar(1);
        this.primerosCinco.apilar(2);
        this.primerosCinco.apilar(3);
        this.primerosCinco.apilar(4);
        this.primerosCinco.apilar(5);
        
        assertEquals(5, this.primerosCinco.tope());
        assertEquals(5, this.primerosCinco.desapilar());
        assertEquals(4, this.primerosCinco.tope());
        assertEquals(4, this.primerosCinco.desapilar());
        assertEquals(3, this.primerosCinco.tope());
        assertEquals(3, this.primerosCinco.desapilar());
        assertEquals(2, this.primerosCinco.tope());
        assertEquals(2, this.primerosCinco.desapilar());
        assertEquals(1, this.primerosCinco.tope());
        assertEquals(1, this.primerosCinco.desapilar());
    }
    
    @Test
    public void vaciarCincoYApilarCinco() {
        this.primerosCinco.apilar(1);
        this.primerosCinco.apilar(2);
        this.primerosCinco.apilar(3);
        this.primerosCinco.apilar(4);
        this.primerosCinco.apilar(5);
        
        assertFalse(this.primerosCinco.esVacia());
        this.primerosCinco.vaciar();
        assertTrue(this.primerosCinco.esVacia());

        this.primerosCinco.apilar(1);
        this.primerosCinco.apilar(2);
        this.primerosCinco.apilar(3);
        this.primerosCinco.apilar(4);
        this.primerosCinco.apilar(5);
        
        assertEquals(5, this.primerosCinco.tope());
        assertEquals(5, this.primerosCinco.desapilar());
        assertEquals(4, this.primerosCinco.tope());
        assertEquals(4, this.primerosCinco.desapilar());
        assertEquals(3, this.primerosCinco.tope());
        assertEquals(3, this.primerosCinco.desapilar());
        assertEquals(2, this.primerosCinco.tope());
        assertEquals(2, this.primerosCinco.desapilar());
        assertEquals(1, this.primerosCinco.tope());
        assertEquals(1, this.primerosCinco.desapilar());
        
        assertTrue(this.primerosCinco.esVacia());
    }
}
