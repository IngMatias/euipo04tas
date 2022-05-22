
package ITADs;

public interface IIndiceABB<T> {
    
    public Comparable getEtiqueta();

    public T getDato();

    public void setIzquierdo();
    
    public void setDerecho();

    public void setRaiz();

    public int compareTo(Comparable etiqueta);
}
