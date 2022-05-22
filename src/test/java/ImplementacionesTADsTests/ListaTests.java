package ImplementacionesTADsTests;

import ITADs.ILista;
import ImplementacionesTADs.Lista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaTests {

    private ILista<String> listaVacia;
    private ILista<Integer> primerosCinco;

    @BeforeEach
    public void setUp() {
        this.listaVacia = new Lista();
        this.primerosCinco = new Lista();
    }

    @Test
    public void listaVaciaEsVacia() {
        assertTrue(this.listaVacia.esVacia());
    }

    @Test
    public void insercionAlInicioNoVacia() {
        assertTrue(this.primerosCinco.esVacia());
        this.primerosCinco.insertarAlInicio(1, 1);
        assertFalse(this.primerosCinco.esVacia());
    }

    @Test
    public void insercionAlFinalNoVacia() {
        assertTrue(this.primerosCinco.esVacia());
        this.primerosCinco.insertarAlFinal(1, 1);
        assertFalse(this.primerosCinco.esVacia());
    }

    @Test
    public void insercionOrdenadaNoVacia() {
        assertTrue(this.primerosCinco.esVacia());
        this.primerosCinco.insertarOrdenado(1, 1);
        assertFalse(this.primerosCinco.esVacia());
    }

    @Test
    public void listaVaciaCantidadDeElementos() {
        assertEquals(0, this.listaVacia.cantElementos());
    }

    @Test
    public void insercionAlInicioCantidadDeElementos() {
        this.primerosCinco.insertarAlInicio(1, 1);
        assertEquals(1, this.primerosCinco.cantElementos());

    }

    @Test
    public void insercionAlFinalCantidadDeElementos() {
        this.primerosCinco.insertarAlFinal(1, 1);
        assertEquals(1, this.primerosCinco.cantElementos());
    }

    @Test
    public void insercionOrdenadaCantidadDeElementos() {
        this.primerosCinco.insertarOrdenado(1, 1);
        assertEquals(1, this.primerosCinco.cantElementos());
    }

    @Test
    public void insercionAlInicioCantidadDeElementosCinco() {
        this.primerosCinco.insertarAlInicio(1, 1);
        this.primerosCinco.insertarAlInicio(2, 2);
        this.primerosCinco.insertarAlInicio(3, 3);
        this.primerosCinco.insertarAlInicio(4, 4);
        this.primerosCinco.insertarAlInicio(5, 5);

        assertEquals(5, this.primerosCinco.cantElementos());

        assertEquals(5, this.primerosCinco.getDato(0));
        assertEquals(4, this.primerosCinco.getDato(1));
        assertEquals(3, this.primerosCinco.getDato(2));
        assertEquals(2, this.primerosCinco.getDato(3));
        assertEquals(1, this.primerosCinco.getDato(4));

    }

    @Test
    public void insercionAlFinalCantidadDeElementosCinco() {
        this.primerosCinco.insertarAlFinal(1, 1);
        this.primerosCinco.insertarAlFinal(2, 2);
        this.primerosCinco.insertarAlFinal(3, 3);
        this.primerosCinco.insertarAlFinal(4, 4);
        this.primerosCinco.insertarAlFinal(5, 5);

        assertEquals(5, this.primerosCinco.cantElementos());

        assertEquals(1, this.primerosCinco.getDato(0));
        assertEquals(2, this.primerosCinco.getDato(1));
        assertEquals(3, this.primerosCinco.getDato(2));
        assertEquals(4, this.primerosCinco.getDato(3));
        assertEquals(5, this.primerosCinco.getDato(4));
    }

    @Test
    public void insercionOrdenadaCantidadDeElementosCinco() {
        this.primerosCinco.insertarOrdenado(1, 1);
        this.primerosCinco.insertarOrdenado(4, 4);
        this.primerosCinco.insertarOrdenado(3, 3);
        this.primerosCinco.insertarOrdenado(5, 5);
        this.primerosCinco.insertarOrdenado(2, 2);

        assertEquals(5, this.primerosCinco.cantElementos());

        assertEquals(1, this.primerosCinco.getDato(0));
        assertEquals(2, this.primerosCinco.getDato(1));
        assertEquals(3, this.primerosCinco.getDato(2));
        assertEquals(4, this.primerosCinco.getDato(3));
        assertEquals(5, this.primerosCinco.getDato(4));
    }

    @Test
    public void copiaOrdenadaVacia() {
        assertTrue(this.listaVacia.copiaOrdenada().esVacia());
        assertEquals(0, this.listaVacia.copiaOrdenada().cantElementos());
    }

    @Test
    public void copiaOrdenadaNoVacia() {
        this.primerosCinco.insertarAlFinal(1, 1);
        this.primerosCinco.insertarAlFinal(4, 4);
        this.primerosCinco.insertarAlFinal(3, 3);
        this.primerosCinco.insertarAlFinal(5, 5);
        this.primerosCinco.insertarAlFinal(2, 2);

        ILista<Integer> ordenada = new Lista();
        ordenada.insertarAlFinal(1, 1);
        ordenada.insertarAlFinal(2, 2);
        ordenada.insertarAlFinal(3, 3);
        ordenada.insertarAlFinal(4, 4);
        ordenada.insertarAlFinal(5, 5);

        assertEquals(ordenada.getDato(0), this.primerosCinco.copiaOrdenada().getDato(0));
        assertEquals(ordenada.getDato(1), this.primerosCinco.copiaOrdenada().getDato(1));
        assertEquals(ordenada.getDato(2), this.primerosCinco.copiaOrdenada().getDato(2));
        assertEquals(ordenada.getDato(3), this.primerosCinco.copiaOrdenada().getDato(3));
        assertEquals(ordenada.getDato(4), this.primerosCinco.copiaOrdenada().getDato(4));

        assertEquals(null, this.primerosCinco.getDato(5));
        assertEquals(null, ordenada.getDato(5));
    }

    @Test
    public void busquedaVacia() {
        assertEquals(null, this.listaVacia.buscar(157));
        assertEquals(null, this.listaVacia.buscar(1095));
        assertEquals(null, this.listaVacia.buscar("sdaasd"));
    }

    @Test
    public void busquedaExitosa() {
        this.primerosCinco.insertarAlFinal(1, 6);
        this.primerosCinco.insertarAlFinal(2, 7);
        this.primerosCinco.insertarAlFinal(3, 8);
        this.primerosCinco.insertarAlFinal(4, 9);
        this.primerosCinco.insertarAlFinal(5, 10);

        assertEquals(6, this.primerosCinco.buscar(1));
        assertEquals(7, this.primerosCinco.buscar(2));
        assertEquals(8, this.primerosCinco.buscar(3));
        assertEquals(9, this.primerosCinco.buscar(4));
        assertEquals(10, this.primerosCinco.buscar(5));
    }

    @Test
    public void eliminarNoEncontrado() {
        assertEquals(null, this.listaVacia.eliminar(157));
        assertEquals(null, this.listaVacia.eliminar(1095));
        assertEquals(null, this.listaVacia.eliminar("sdaasd"));
    }

    @Test
    public void eliminarEncontrado() {
        this.primerosCinco.insertarAlFinal(1, 6);
        this.primerosCinco.insertarAlFinal(2, 7);
        this.primerosCinco.insertarAlFinal(3, 8);
        this.primerosCinco.insertarAlFinal(4, 9);
        this.primerosCinco.insertarAlFinal(5, 10);

        assertEquals(6, this.primerosCinco.eliminar(1));
        assertEquals(10, this.primerosCinco.eliminar(5));
        assertEquals(7, this.primerosCinco.eliminar(2));
        assertEquals(8, this.primerosCinco.eliminar(3));
        assertEquals(9, this.primerosCinco.eliminar(4));

        assertTrue(this.primerosCinco.esVacia());
        assertEquals(0, this.primerosCinco.cantElementos());
    }
}
