
package ImplementacionesTADsTests;

import ITADs.ICola;
import ImplementacionesTADs.Cola;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColaTests {
    
    private ICola<String> colaVacia;
    private ICola<Integer> primerosCinco;
    
    @BeforeEach
    public void setUp() {
        this.colaVacia = new Cola();
        this.primerosCinco = new Cola();
    }

    @Test
    public void esVaciaColaVacia() {
        assertTrue(this.colaVacia.esVacia());
    }
    
    @Test
    public void noEsVaciaColaNoVacia() {
        this.primerosCinco.encolar(1);
        assertFalse(this.primerosCinco.esVacia());
    }
    
    @Test
    public void encolarYDesencolarCinco() {
        this.primerosCinco.encolar(1);
        this.primerosCinco.encolar(2);
        this.primerosCinco.encolar(3);
        this.primerosCinco.encolar(4);
        this.primerosCinco.encolar(5);
        
        assertEquals(1, this.primerosCinco.desencolar());
        assertEquals(2, this.primerosCinco.desencolar());
        assertEquals(3, this.primerosCinco.desencolar());
        assertEquals(4, this.primerosCinco.desencolar());
        assertEquals(5, this.primerosCinco.desencolar());
        
        assertTrue(this.primerosCinco.esVacia());
        assertEquals(null, this.primerosCinco.desencolar());
    }
}
