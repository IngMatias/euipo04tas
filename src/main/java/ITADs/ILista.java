package ITADs;

public interface ILista<T> {

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return True si tiene elementos, false en caso contrario.
     */
    public boolean esVacia();

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vacia retorna 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Retorna un indice al primer elemento de la lista.
     *
     * @return El indice al primer elemento de la lista.
     */
    public IIndice<T> getIndice();

    /**
     * Retorna el elemento segun indice.
     *
     * @param position Posicion del elemento buscado.
     * @return Elemento que se encuentra en dicha posicion, retorna null si la
     * posicion esta fuera de rango.
     */
    public T getDato(int position);

    /**
     * Metodo encargado de agregar un nodo al inicio de la lista.
     *
     * @param etiqueta Etiqueta del nodo a agregar.
     * @param dato Dato del nodo a agregar.
     */
    public void insertarAlInicio(Comparable etiqueta, T dato);

    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     *
     * @param etiqueta Etiqueta del nodo a agregar.
     * @param dato Dato del nodo a agregar.
     */
    public void insertarAlFinal(Comparable etiqueta, T dato);

    /**
     * Metodo encargado de insertar un nodo de forma ordenada.
     *
     * @param etiqueta Etiqueta del nodo a agregar.
     * @param dato Dato del nodo a agregar.
     */
    public void insertarOrdenado(Comparable etiqueta, T dato);

    /**
     * Se retorna una lista ordenada.
     *
     * @return Lista ordenada.
     */
    public ILista<T> copiaOrdenada();

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a buscar.
     * @return El nodo encontrado, en caso de no encontrarlo retorna null.
     */
    public T buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return Dato eliminado, null si no encuentra la clave.
     */
    public T eliminar(Comparable clave);

    /**
     * Metodo encargado de retornar una representacion de la lista.
     *
     * @return Lista en forma de String.
     */
    public String imprimir();

    /**
     * Metodo encargado de retornar una representacion de la lista, con el uso
     * de un separador especifico.
     *
     * @param separador Separa las claves.
     * @return Lista en forma de String.
     */
    public String imprimir(String separador);

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * parametro, con apertura y cierre definidos.
     *
     * @param separador Separa las claves.
     * @param apertura Abre la impresion.
     * @param cierre Cierra la impresion.
     * @return Lista en forma de String.
     */
    public String imprimir(String separador, String apertura, String cierre);

}
