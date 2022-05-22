package ITADs;

public interface ICola<T> {

    /**
     * Retorna verdadero si la cola esta vacia.
     *
     * @return True si la cola esta vacia, flase en caso contrario.
     */
    public boolean esVacia();

    /**
     * Agrega un elemento a la cola.
     *
     * @param nuevo Nuevo elemento de la cola.
     */
    public void encolar(T nuevo);

    /**
     * Retorna el proximo elemento de la cola.
     *
     * @return Proximo elemento de la cola.
     */
    public T desencolar();
}
