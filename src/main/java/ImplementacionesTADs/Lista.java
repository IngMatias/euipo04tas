package ImplementacionesTADs;

import ITADs.IIndice;
import ITADs.INodo;
import ITADs.ILista;

public class Lista<T> implements ILista<T> {

    private INodo<T> primero;

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public int cantElementos() {
        INodo<T> aux = this.primero;
        int cont = 0;
        while (aux != null) {
            cont++;
            aux = aux.getSiguiente();
        }
        return cont;
    }

    @Override
    public IIndice<T> getIndice() {
        return new Indice(this.primero);
    }

    @Override
    public T getDato(int position) {
        if (position < 0) {
            return null;
        }
        INodo<T> aux = this.primero;
        while (aux != null && position > 0) {
            position = position - 1;
            aux = aux.getSiguiente();
        }
        return aux == null ? null : aux.getDato();
    }

    @Override
    public void insertarAlInicio(Comparable etiqueta, T dato) {
        INodo<T> nodo = new Nodo(etiqueta, dato);
        nodo.setSiguiente(this.primero);
        this.primero = nodo;
    }

    @Override
    public void insertarAlFinal(Comparable etiqueta, T dato) {
        INodo<T> nodo = new Nodo(etiqueta, dato);
        if (this.primero == null) {
            this.primero = nodo;
            return;
        }
        INodo<T> aux = this.primero;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nodo);
    }

    @Override
    public void insertarOrdenado(Comparable etiqueta, T dato) {
        INodo<T> nodo = new Nodo(etiqueta, dato);
        INodo<T> aux = this.primero;
        if (this.primero == null || nodo.compareTo(aux) < 0) {
            nodo.setSiguiente(this.primero);
            this.primero = nodo;
            return;
        }
        while (aux.getSiguiente() != null && aux.getSiguiente().compareTo(nodo) < 0) {
            aux = aux.getSiguiente();
        }
        nodo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nodo);
    }

    @Override
    public ILista<T> copiaOrdenada() {
        ILista<T> toReturn = new Lista();
        INodo<T> aux = this.primero;
        while (aux != null) {
            toReturn.insertarOrdenado(aux.getEtiqueta(), aux.getDato());
            aux = aux.getSiguiente();
        }
        return toReturn;
    }

    @Override
    public T buscar(Comparable clave) {
        INodo<T> aux = this.primero;
        while (aux != null) {
            if (aux.compareTo(clave) == 0) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public T eliminar(Comparable clave) {
        INodo<T> aux = this.primero;
        if (aux != null && aux.compareTo(clave) == 0) {
            this.primero = aux.getSiguiente();
            return aux.getDato();
        }
        while (aux != null && aux.getSiguiente() != null) {
            if (aux.getSiguiente().compareTo(clave) == 0) {
                INodo<T> eliminado = aux.getSiguiente();
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                return eliminado.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public String imprimir() {
        return this.imprimir(",");
    }

    @Override
    public String imprimir(String separador) {
        return this.imprimir(separador, "[", "]");
    }

    @Override
    public String imprimir(String separador, String apertura, String cierre) {
        String toReturn = apertura + " ";
        INodo<T> aux = this.primero;
        if (aux != null) {
            toReturn += aux.getDato().toString() + "\n";
            aux = aux.getSiguiente();
        }
        while (aux != null) {
            toReturn += separador + " " + aux.getDato().toString() + "\n";
            aux = aux.getSiguiente();
        }
        toReturn += " " + cierre;
        return toReturn;
    }
}
