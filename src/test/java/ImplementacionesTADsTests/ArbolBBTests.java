/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ImplementacionesTADsTests;

import ITADs.IArbolBB;
import ITADs.IIndiceABB;
import ImplementacionesTADs.ArbolBB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ingFo
 */
public class ArbolBBTests {

    private IArbolBB<Integer> arbolVacio;
    private IArbolBB<Integer> listaDerecha;
    private IArbolBB<Integer> listaIzquierda;
    private IArbolBB<Integer> flecha;
    private IArbolBB<Integer> balanceado;

    @BeforeEach
    public void setUp() {
        this.arbolVacio = new ArbolBB();
        this.listaDerecha = new ArbolBB();
        this.listaIzquierda = new ArbolBB();
        this.flecha = new ArbolBB();
        this.balanceado = new ArbolBB();

        this.listaDerecha.insertar(1, 6);
        this.listaDerecha.insertar(2, 7);
        this.listaDerecha.insertar(3, 8);
        this.listaDerecha.insertar(4, 9);
        this.listaDerecha.insertar(5, 10);

        this.listaIzquierda.insertar(5, 6);
        this.listaIzquierda.insertar(4, 7);
        this.listaIzquierda.insertar(3, 8);
        this.listaIzquierda.insertar(2, 9);
        this.listaIzquierda.insertar(1, 10);

        this.flecha.insertar(5, 14);
        this.flecha.insertar(4, 13);
        this.flecha.insertar(3, 12);
        this.flecha.insertar(2, 11);
        this.flecha.insertar(1, 10);
        this.flecha.insertar(6, 15);
        this.flecha.insertar(7, 16);
        this.flecha.insertar(8, 17);
        this.flecha.insertar(9, 18);

        this.balanceado.insertar(4, 11);
        this.balanceado.insertar(2, 9);
        this.balanceado.insertar(3, 10);
        this.balanceado.insertar(1, 8);
        this.balanceado.insertar(6, 13);
        this.balanceado.insertar(5, 12);
        this.balanceado.insertar(7, 14);

    }

    @Test
    public void esVacioArbolVacio() {
        assertTrue(this.arbolVacio.esVacio());
    }

    @Test
    public void listaDerechaNoVacio() {
        assertFalse(this.listaDerecha.esVacio());
    }

    @Test
    public void listaIzquierdaNoVacio() {
        assertFalse(this.listaIzquierda.esVacio());
    }

    @Test
    public void flechaNoVacio() {
        assertFalse(this.flecha.esVacio());
    }

    @Test
    public void balanceadoNoVacio() {
        assertFalse(this.balanceado.esVacio());
    }

    @Test
    public void alturaVacia() {
        assertEquals(0, this.arbolVacio.altura());
    }

    @Test
    public void listaDerechaAltura() {
        assertEquals(5, this.listaDerecha.altura());
    }

    @Test
    public void listaIzquierdaAltura() {
        assertEquals(5, this.listaIzquierda.altura());
    }

    @Test
    public void flechaAltura() {
        assertEquals(5, this.flecha.altura());
    }

    @Test
    public void balanceadoAltura() {
        assertEquals(3, this.balanceado.altura());
    }

    @Test
    public void tamanioVacia() {
        assertEquals(0, this.arbolVacio.tamanio());
    }

    @Test
    public void listaDerechaTamanio() {
        assertEquals(5, this.listaDerecha.tamanio());
    }

    @Test
    public void listaIzquierdaTamanio() {
        assertEquals(5, this.listaIzquierda.tamanio());
    }

    @Test
    public void flechaTamanio() {
        assertEquals(9, this.flecha.tamanio());
    }

    @Test
    public void balanceadoTamanio() {
        assertEquals(7, this.balanceado.tamanio());
    }

    @Test
    public void cantidadDeHojasVacia() {
        assertEquals(0, this.arbolVacio.cantidadDeHojas());
    }

    @Test
    public void listaDerechaCantidadDeHojas() {
        assertEquals(1, this.listaDerecha.cantidadDeHojas());
    }

    @Test
    public void listaIzquierdacantidadDeHojas() {
        assertEquals(1, this.listaIzquierda.cantidadDeHojas());
    }

    @Test
    public void flechacantidadDeHojas() {
        assertEquals(2, this.flecha.cantidadDeHojas());
    }

    @Test
    public void balanceadocantidadDeHojas() {
        assertEquals(4, this.balanceado.cantidadDeHojas());
    }

    @Test
    public void listaDerechaUnicoRecorrido() {
        IIndiceABB<Integer> aux = this.listaDerecha.getIndice();
        assertEquals(6, aux.getDato());
        aux.setDerecho();
        assertEquals(7, aux.getDato());
        aux.setDerecho();
        assertEquals(8, aux.getDato());
        aux.setDerecho();
        assertEquals(9, aux.getDato());
        aux.setDerecho();
        assertEquals(10, aux.getDato());
        aux.setDerecho();
        assertEquals(null, aux.getDato());
    }

    @Test
    public void listaIzquierdaUnicoRecorrido() {
        IIndiceABB<Integer> aux = this.listaIzquierda.getIndice();
        assertEquals(6, aux.getDato());
        aux.setIzquierdo();
        assertEquals(7, aux.getDato());
        aux.setIzquierdo();
        assertEquals(8, aux.getDato());
        aux.setIzquierdo();
        assertEquals(9, aux.getDato());
        aux.setIzquierdo();
        assertEquals(10, aux.getDato());
        aux.setIzquierdo();
        assertEquals(null, aux.getDato());
    }
    
    @Test
    public void flechaAmbosRecorridos() {
        IIndiceABB<Integer> aux = this.flecha.getIndice();
        assertEquals(14, aux.getDato());
        aux.setIzquierdo();
        assertEquals(13, aux.getDato());
        aux.setIzquierdo();
        assertEquals(12, aux.getDato());
        aux.setIzquierdo();
        assertEquals(11, aux.getDato());
        aux.setIzquierdo();
        assertEquals(10, aux.getDato());
        aux.setIzquierdo();
        assertEquals(null, aux.getDato());
        
        aux.setRaiz();
        
        assertEquals(14, aux.getDato());
        aux.setDerecho();
        assertEquals(15, aux.getDato());
        aux.setDerecho();
        assertEquals(16, aux.getDato());
        aux.setDerecho();
        assertEquals(17, aux.getDato());
        aux.setDerecho();
        assertEquals(18, aux.getDato());
        aux.setDerecho();
        assertEquals(null, aux.getDato());
    }
    
    @Test
    public void balanceadoTodosLosRecorridos() {
        IIndiceABB<Integer> aux = this.balanceado.getIndice();

        assertEquals(11, aux.getDato());
        aux.setDerecho();
        assertEquals(13, aux.getDato());
        aux.setDerecho();
        assertEquals(14, aux.getDato());
        aux.setRaiz();

        assertEquals(11, aux.getDato());
        aux.setDerecho();
        assertEquals(13, aux.getDato());
        aux.setIzquierdo();
        assertEquals(12, aux.getDato());
        aux.setRaiz();

        assertEquals(11, aux.getDato());
        aux.setIzquierdo();
        assertEquals(9, aux.getDato());
        aux.setIzquierdo();
        assertEquals(8, aux.getDato());
        aux.setRaiz();

        assertEquals(11, aux.getDato());
        aux.setIzquierdo();
        assertEquals(9, aux.getDato());
        aux.setDerecho();
        assertEquals(10, aux.getDato());
        aux.setRaiz();
    }
    
    @Test
    public void balanceadoNivelesDeTodosLosNodos() {
        assertEquals(1, this.balanceado.nivelDelNodo(4));
        
        assertEquals(2, this.balanceado.nivelDelNodo(2));
        assertEquals(2, this.balanceado.nivelDelNodo(6));

        assertEquals(3, this.balanceado.nivelDelNodo(1));
        assertEquals(3, this.balanceado.nivelDelNodo(3));
        assertEquals(3, this.balanceado.nivelDelNodo(5));
        assertEquals(3, this.balanceado.nivelDelNodo(7));
        
        assertEquals(-1, this.balanceado.nivelDelNodo(10));
    }
    @Test
    public void balanceadoBusquedaDeTodosLosNodos() {
        assertEquals(11, this.balanceado.buscar(4));
        
        assertEquals(9, this.balanceado.buscar(2));
        assertEquals(13, this.balanceado.buscar(6));
        
        assertEquals(8, this.balanceado.buscar(1));
        assertEquals(10, this.balanceado.buscar(3));
        assertEquals(12, this.balanceado.buscar(5));
        assertEquals(14, this.balanceado.buscar(7));
        
        assertEquals(null, this.balanceado.buscar(15));
    }
}
