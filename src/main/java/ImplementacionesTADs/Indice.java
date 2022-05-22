package ImplementacionesTADs;

import ITADs.IIndice;
import ITADs.INodo;

public class Indice<T> implements IIndice<T> {

    private final INodo<T> primero;
    private INodo<T> actual;

    public Indice(INodo<T> primero) {
        this.primero = primero;
        this.actual = primero;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.actual.getEtiqueta();
    }

    @Override
    public T getDato() {
        return this.actual == null ? null : this.actual.getDato();
    }

    @Override
    public void setSiguiente() {
        this.actual = this.actual.getSiguiente();
    }

    @Override
    public void setPrimero() {
        this.actual = this.primero;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.actual.compareTo(etiqueta);
    }

}
