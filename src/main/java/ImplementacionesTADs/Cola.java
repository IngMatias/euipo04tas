package ImplementacionesTADs;

import ITADs.IIndice;
import ITADs.ILista;
import ITADs.ICola;

public class Cola<T> implements ICola<T> {

    private final ILista<T> lista;

    public Cola() {
        this.lista = new Lista();
    }

    @Override
    public boolean esVacia() {
        return this.lista.esVacia();
    }

    @Override
    public void encolar(T nuevo) {
        this.lista.insertarAlFinal(0, nuevo);
    }

    @Override
    public T desencolar() {
        if (this.esVacia()) return null;
        IIndice<T> aux = this.lista.getIndice();
        this.lista.eliminar(aux.getEtiqueta());
        return aux.getDato();
    }

}
