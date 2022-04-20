/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ta1.mavenproject2.Compilador;

/**
 *
 * @author ingFo
 */
public class NewEmptyJUnitTest {
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void empty() {
        Compilador compi = new Compilador();
        assertTrue(compi.controlCorchetes(""));
    }
    
    @Test
    public void simpleTest() {
        Compilador compi = new Compilador();
        assertTrue(compi.controlCorchetes("{}"));
    }
    
    @Test
    public void complexTest() {
        Compilador compi = new Compilador();
        assertTrue(compi.controlCorchetes("{{}{}}{}"));
    }
    
    @Test
    public void example1() {
        Compilador compi = new Compilador();
        assertTrue(compi.controlCorchetes("{}{{}}"));
    }
    
    @Test
    public void example2() {
        Compilador compi = new Compilador();
        assertFalse(compi.controlCorchetes("{{}{{}"));
    }
    
    @Test
    public void example3() {
        Compilador compi = new Compilador();
        assertFalse(compi.controlCorchetes("}}{}"));
    }
}
