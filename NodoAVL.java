package ImplementacionesTADs;

public class NodoAVL<T> extends NodoABB<T> {
    private int feq;
    private NodoAVL<T> izquierdo;
    private NodoAVL<T> derecho;
    
    public NodoAVL(Comparable etiqueta, T dato) {
        super(etiqueta, dato);
    }
    
    public int factorEquilibrio() {
        int feqIzq = 0;
        int feqDer = 0;
        
        if (this.getIzquierdo() != null) {
            feqIzq = this.izquierdo.factorEquilibrio();
        }
        if (this.getDerecho() != null) {
            feqDer = this.derecho.factorEquilibrio();
        }
        
        this.feq = feqDer - feqIzq;
        return this.feq;
    }
}
