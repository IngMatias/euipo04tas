/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.tda;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nnavarro
 */
public class ConjuntoTest
{

    private static Conjunto<String> c1;
    private static Conjunto<String> c2;

    public ConjuntoTest()
    {
    }

    @BeforeAll
    public static void setUpClass()
    {
        c1 = new Conjunto();
        c2 = new Conjunto();
        Nodo<String> n1 = new Nodo("A", "A");
        Nodo<String> n2 = new Nodo("B", "B");
        Nodo<String> n3 = new Nodo("C", "C");
        Nodo<String> n4 = new Nodo("D", "D");
        Nodo<String> n5 = new Nodo("E", "E");
        c1.insertar(n1);
        c1.insertar(n2);
        c1.insertar(n3);
        c2.insertar(n2);
        c2.insertar(n4);
        c2.insertar(n5);
    }

    /**
     * Test of diferenciaSimetrica method, of class Conjunto.
     */
    @Test
    public void testDiferenciaSimetrica()
    {
        setUpClass();
        System.out.println("diferenciaSimetrica");
        IConjunto expResult = null;
        IConjunto result = c1.diferenciaSimetrica(c2);
        assertNull(result.buscar("B"));
    }

    @Test
    public void testDiferenciaSimetricaNull()
    {
        setUpClass();
        System.out.println("diferenciaSimetrica");
        IConjunto expResult = c1;
        IConjunto result = c1.diferenciaSimetrica(null);
        assert c1 == result;
    }

}
