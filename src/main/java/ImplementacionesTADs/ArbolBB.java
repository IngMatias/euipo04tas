package ImplementacionesTADs;

import ITADs.ILista;
import ITADs.INodoABB;
import ITADs.IIndiceABB;
import ITADs.IArbolBB;

public class ArbolBB<T> implements IArbolBB<T> {

    private INodoABB<T> raiz;

    @Override
    public IIndiceABB<T> getIndice() {
        return new IndiceABB(this.raiz);
    }
    
    @Override
    public boolean esVacio() {
        return this.raiz == null;
    }

    @Override
    public int altura() {
        return this.raiz == null ? 0 : this.raiz.altura();
    }

    @Override
    public ILista<Comparable> caminoMasLargo() {
        return this.raiz.caminoMasLargo();
    }

    @Override
    public int tamanio() {
        return this.raiz == null ? 0 : this.raiz.tamanio();
    }

    @Override
    public int cantidadDeHojas() {
        return this.raiz == null ? 0 : this.raiz.cantidadDeHojas();
    }

    @Override
    public boolean insertar(Comparable etiqueta, T dato) {
        if (this.raiz == null) {
            INodoABB nuevo = new NodoABB(etiqueta, dato);
            this.raiz = nuevo;
            return true;
        }
        return this.raiz.insertar(etiqueta, dato);
    }

    @Override
    public int nivelDelNodo(Comparable etiqueta) {
        return this.raiz == null ? 0 : this.raiz.nivelDelNodo(etiqueta);
    }

    @Override
    public T buscar(Comparable etiqueta) {
        return this.raiz == null ? null : this.raiz.buscar(etiqueta);
    }

    @Override
    public T eliminar(Comparable etiqueta) {
        return null;
    }

    @Override
    public String imprimirPorNiveles() {
        return this.raiz == null ? "" : this.raiz.imprimirPorNiveles();
    }

    @Override
    public String imprimirPreOrden() {
        return this.raiz == null ? "" : this.raiz.imprimirPreOrden();
    }

    @Override
    public String imprimirInOrden() {
        return this.raiz == null ? "" : this.raiz.imprimirInOrden();
    }

    @Override
    public String imprimirPostOrden() {
        return this.raiz == null ? "" : this.raiz.imprimirPostOrden();
    }

    @Override
    public ILista<T> listaInOrden(ILista<T> lista) {
        ILista<T> toReturn = new Lista();
        if (this.raiz != null) {
            this.raiz.listaInOrden(toReturn);
        }
        return toReturn;
    }
}
