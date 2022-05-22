package ITADs;

public interface INodo<T> {

    /**
     * Devuelve el dato del nodo.
     *
     * @return El dato del nodo.
     */
    public T getDato();

    /**
     * Retorna la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Devuelve el siguiente del nodo.
     *
     * @return Siguiente nodo.
     */
    public INodo<T> getSiguiente();

    /**
     * Agrega un siguiente nodo.
     *
     * @param nodo Nodo a ser el nuevo siguiente.
     */
    public void setSiguiente(INodo nodo);

    /**
     * Retorna -1 si this tiene una etiqueta menor, 0 si son iguales, 1 si es
     * mayor.
     *
     * @param etiqueta Etiqueta a ser comparada.
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor.
     */
    public int compareTo(Comparable etiqueta);

    /**
     * Retorna -1 si this tiene una etiqueta menor, 0 si son iguales, 1 si es
     * mayor.
     *
     * @param nodo Nodo cuya etiqueta sera comparada.
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor.
     */
    public int compareTo(INodo<T> nodo);
}
