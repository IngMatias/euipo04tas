package ImplementacionesTADs;

import ITADs.INodo;

public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private final T dato;
    private INodo<T> siguiente;

    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(INodo nodo) {
        this.siguiente = nodo;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    @Override
    public int compareTo(INodo nodo) {
        return this.compareTo(nodo.getEtiqueta());
    }
}
