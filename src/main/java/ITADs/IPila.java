package ITADs;

public interface IPila<T> {

    /**
     * Devuelve verdadero si la pila no contiene datos.
     *
     * @return True si la pila esta vacia, falso en caso contrario.
     */
    public boolean esVacia();

    /**
     * De acuerdo al tamaño inicial de la pila, devuelve verdadero si la
     * cantidad de elementos en la pila es la maxima.
     *
     * @return True si la pila esta llena, falso en caso contrario.
     */
    public boolean estaLlena();

    /**
     * Pone un dato de tipo T en el tope de la pila.
     *
     * @param dato Dato a ser apilado en la lista.
     * @return True si es posible apliar el dato, falso en caso contrario.
     */
    public boolean apilar(T dato);

    /**
     * Devuelve el dato del tope de la pila sin quitarlo de la misma.
     *
     * @return Dato del tope.
     */
    public T tope();

    /**
     * Quita del tope de la pila el dato y lo devuelve.
     *
     * @return Dato del tope.
     */
    public T desapilar();

    /**
     * Quita todos los elementos de la pila.
     */
    public void vaciar();

}
