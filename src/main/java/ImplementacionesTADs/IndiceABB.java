
package ImplementacionesTADs;

import ITADs.IIndiceABB;
import ITADs.INodoABB;

public class IndiceABB<T> implements IIndiceABB<T> {

    private INodoABB<T> actual;
    private INodoABB<T> raiz;
    
    public IndiceABB(INodoABB<T> raiz) {
        this.actual = raiz;
        this.raiz = raiz;
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
    public void setIzquierdo() {
        this.actual = this.actual.getIzquierdo();
    }

    @Override
    public void setDerecho() {
        this.actual = this.actual.getDerecho();
    }
    
    @Override
    public void setRaiz() {
        this.actual = this.raiz;
    }
    
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.actual.compareTo(etiqueta);
    }
}
