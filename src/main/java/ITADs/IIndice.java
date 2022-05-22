package ITADs;

public interface IIndice<T> {

    public Comparable getEtiqueta();

    public T getDato();

    public void setSiguiente();

    public void setPrimero();

    public int compareTo(Comparable etiqueta);
}
