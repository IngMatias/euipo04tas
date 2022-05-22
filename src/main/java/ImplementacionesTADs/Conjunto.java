package ImplementacionesTADs;

import ITADs.IIndice;
import ITADs.IConjunto;

public class Conjunto<T> extends Lista<T> implements IConjunto<T> {

    @Override
    public boolean pertenece(Comparable etiqueta) {
        IIndice aux = this.getIndice();
        while (aux.getDato() != null) {
            if (aux.compareTo(etiqueta) == 0) {
                return true;
            }
            aux.setSiguiente();
        }
        return false;
    }

    @Override
    public boolean esVacio() {
        return this.esVacia();
    }

    @Override
    public boolean esIgual(IConjunto conjunto) {
        return this.diferenciaSimetrica(conjunto).esVacio();
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        if (!this.pertenece(etiqueta)) {
            this.insertarAlInicio(etiqueta, dato);
        }
    }

    @Override
    public IConjunto union(IConjunto conjunto) {
        IConjunto<T> toReturn = new Conjunto();
        IIndice<T> aux = this.getIndice();
        while (aux.getDato() != null) {
            toReturn.insertar(aux.getEtiqueta(), aux.getDato());
            aux.setSiguiente();
        }
        aux = conjunto.getIndice();
        while (aux.getDato() != null) {
            toReturn.insertar(aux.getEtiqueta(), aux.getDato());
            aux.setSiguiente();
        }
        return toReturn;
    }

    @Override
    public IConjunto interseccion(IConjunto conjunto) {
        IConjunto<T> toReturn = new Conjunto();
        IIndice<T> aux = this.getIndice();
        while (aux.getDato() != null) {
            if (conjunto.pertenece(aux.getEtiqueta())) {
                toReturn.insertar(aux.getEtiqueta(), aux.getDato());
            }
            aux.setSiguiente();
        }
        return toReturn;
    }

    @Override
    public IConjunto diferencia(IConjunto conjunto) {
        IConjunto<T> toReturn = new Conjunto();
        IIndice<T> aux = this.getIndice();
        while (aux.getDato() != null) {
            if (!conjunto.pertenece(aux.getEtiqueta())) {
                toReturn.insertar(aux.getEtiqueta(), aux.getDato());
            }
            aux.setSiguiente();
        }
        return toReturn;
    }

    @Override
    public IConjunto diferenciaSimetrica(IConjunto conjunto) {
        IConjunto<T> toReturn = new Conjunto();
        IIndice<T> aux = this.getIndice();
        while (aux.getDato() != null) {
            if (!conjunto.pertenece(aux.getEtiqueta())) {
                toReturn.insertar(aux.getEtiqueta(), aux.getDato());
            }
            aux.setSiguiente();
        }
        aux = conjunto.getIndice();
        while (aux.getDato() != null) {
            if (!this.pertenece(aux.getEtiqueta())) {
                toReturn.insertar(aux.getEtiqueta(), aux.getDato());
            }
            aux.setSiguiente();
        }
        return toReturn;
    }

    @Override
    public String imprimir() {
        return this.imprimir(",");
    }

    @Override
    public String imprimir(String separador) {
        return this.imprimir(separador, "{", "}");
    }

    @Override
    public String imprimir(String separador, String apertura, String cierre) {
        return super.imprimir(separador, apertura, cierre);
    }
}
