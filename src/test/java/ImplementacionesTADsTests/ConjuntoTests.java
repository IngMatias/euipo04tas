
package ImplementacionesTADsTests;

import ITADs.IConjunto;
import ImplementacionesTADs.Conjunto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoTests {
    
    private IConjunto<Integer> conjuntoVacio;
    private IConjunto<Integer> conjuntoCinco;
            
    @BeforeEach
    public void setUp() {
        this.conjuntoVacio = new Conjunto();
        this.conjuntoCinco = new Conjunto();
        
        this.conjuntoCinco.insertar(1, 6);
        this.conjuntoCinco.insertar(2, 7);
        this.conjuntoCinco.insertar(3, 8);
        this.conjuntoCinco.insertar(4, 9);
        this.conjuntoCinco.insertar(5, 10);
    }

    @Test
    public void esVacioConjuntoVacio() {
        assertTrue(this.conjuntoVacio.esVacio());
    }
    
    @Test
    public void noEsVacioConjuntoNoVacio() {
        assertFalse(this.conjuntoCinco.esVacio());
    }
    
    @Test
    public void perteneceConjuntoVacio() {
        assertFalse(this.conjuntoVacio.pertenece(5));
    }
    
    @Test
    public void pertenecenCinco() {
        assertTrue(this.conjuntoCinco.pertenece(1));
        assertTrue(this.conjuntoCinco.pertenece(2));
        assertTrue(this.conjuntoCinco.pertenece(3));
        assertTrue(this.conjuntoCinco.pertenece(4));
        assertTrue(this.conjuntoCinco.pertenece(5));
        
        assertFalse(this.conjuntoCinco.pertenece(6));
    }
    
    @Test
    public void igualdadDeVacios() {
        IConjunto<Integer> otroVacio = new Conjunto();
        assertTrue(otroVacio.esIgual(this.conjuntoVacio));
    }
    
}
