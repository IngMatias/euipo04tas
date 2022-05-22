package ITADs;

public interface INodoABB<T> {

    /**
     * Devuelve el dato del nodo.
     *
     * @return El dato del nodo.
     */
    public T getDato();

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public INodoABB<T> getDerecho();

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @param derecho Hijo derecho del nodo.
     */
    public void setDerecho(INodoABB<T> derecho);

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public INodoABB<T> getIzquierdo();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @param izquierdo Hijo izquierdo del nodo.
     */
    public void setIzquierdo(INodoABB<T> izquierdo);

    /**
     * Retorna la altura del nodo.
     *
     * @return Altura del nodo.
     */
    public int altura();

    /**
     * Retorna una lista que representa el camino mas largo del arbol, la
     * altura.
     *
     * @return Lista con las etiqeutas que marcan la altura.
     */
    public ILista<Comparable> caminoMasLargo();

    /**
     * Retorna el tamanio del nodo.
     *
     * @return Tamanio del nodo.
     */
    public int tamanio();

    /**
     * Retorna la cantidad de hojas debajo de este nodo.
     *
     * @return Cantidad de hojas debajo de este nodo.
     */
    public int cantidadDeHojas();

    /**
     * Retorna el nivel de la etiqueta.
     *
     * @param etiqueta Etiqueta a ser buscada.
     * @return Retorna el nivel al cual pertenece la etiqueta, 0 si la etiqueta
     * no esta en el arbol.
     */
    public int nivelDelNodo(Comparable etiqueta);

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param etiqueta Etiqueta del nodo a insertar.
     * @param dato Dato del nodo a insertar.
     * @return Exito de la operacion.
     */
    public boolean insertar(Comparable etiqueta, T dato);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param etiqueta del nodo a buscar
     * @return Dato encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public T buscar(Comparable etiqueta);

    /**
     * Retorna una representacion por niveles del arbol.
     *
     * @return Representacion por niveles del arbol.
     */
    public String imprimirPorNiveles();

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String imprimirPreOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el inorden separado por guiones.
     */
    public String imprimirInOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el postorden separado por guiones.
     */
    public String imprimirPostOrden();

    /**
     * Retorna una lista con el inOrden del arbol.
     *
     * @param lista Lista con el inOrden del arbol.
     */
    public void listaInOrden(ILista<T> lista);

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
