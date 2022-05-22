package ImplementacionesTADs;

import ITADs.IIndice;
import ITADs.ILista;
import ITADs.IPila;

public class Pila<T> implements IPila<T> {

    private ILista<T> lista;

    public Pila() {
        this.lista = new Lista();
    }

    @Override
    public boolean esVacia() {
        return this.lista.esVacia();
    }

    @Override
    public boolean estaLlena() {
        return false;
    }

    @Override
    public boolean apilar(T dato) {
        this.lista.insertarAlInicio("", dato);
        return true;
    }

    @Override
    public T tope() {
        IIndice<T> aux = this.lista.getIndice();
        return aux == null ? null : aux.getDato();
    }

    @Override
    public T desapilar() {
        IIndice<T> toReturn = this.lista.getIndice();
        if (toReturn == null) {
            return null;
        }
        this.lista.eliminar("");
        return toReturn.getDato();
    }

    @Override
    public void vaciar() {
        this.lista = new Lista();
    }

}
