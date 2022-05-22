package ImplementacionesTADs;

import ITADs.ILista;
import ITADs.IDiccionario;

public class Diccionario<T> implements IDiccionario<T> {

    private final ILista<T> lista;

    public Diccionario() {
        this.lista = new Lista();
    }

    @Override
    public boolean esVacio() {
        return this.lista.esVacia();
    }
    
    @Override
    public boolean esClave(Comparable clave) {
        return this.lista.buscar(clave) != null;
    }

    @Override
    public boolean agregar(Comparable clave, T valor) {
        if (this.lista.buscar(clave) != null) return false;
        this.lista.insertarAlFinal(clave, valor);
        return true;
    }

    @Override
    public T obtener(Comparable clave) {
        return this.lista.buscar(clave);
    }

    @Override
    public T eliminar(Comparable clave) {
        return this.lista.eliminar(clave);
    }
}
