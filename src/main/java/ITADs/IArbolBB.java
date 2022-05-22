package ITADs;

public interface IArbolBB<T> {
    /**
     * Retorna un indice a la raiz del arbol.
     *
     * @return El indice a la raiz del arbol.
     */
    public IIndiceABB<T> getIndice();
    
    /**
     * Retorna verdadero en caso de que el arbol sea vacio, falso en caso
     * contrario.
     *
     * @return True en caso de que el arbol sea vacio, false en caso contrario.
     */
    public boolean esVacio();

    /**
     * Retorna la aluta del arbol.
     *
     * @return Altura del arbol, se sigue el siguiente criterio: si el arbol es
     * vacio, su altura es 0.
     */
    public int altura();

    /**
     * Retorna las etiquetas que forman el camino mas largo del arbol.
     *
     * @return Etiquetas que forman el camino mas largo del arbol, se sigue el
     * siguiente criterio: se ordenan desde la raiz a la hoja.
     */
    public ILista<Comparable> caminoMasLargo();

    /**
     * Retorna la cantidad de nodos del arbol.
     *
     * @return Cantidad de nodos del arbol.
     */
    public int tamanio();

    /**
     * Retorna la cantidad de hojas del arbol.
     *
     * @return Cantidad de hojas del arbol.
     */
    public int cantidadDeHojas();

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada no se inserta.
     *
     * @param etiqueta Etiqueta del nuevo Nodo del arbol.
     * @param dato Dato del nuevo Nodo del arbol.
     * @return Exito de la operacián.
     */
    public boolean insertar(Comparable etiqueta, T dato);

    /**
     * Retorna el nivel del arbol en que se encuentra una etiqueta.
     *
     * @param etiqueta Etiqueta a ser buscada
     * @return Nivel en el que se encuentra el nodo, 0 indica que el nodo no ha
     * sido encontrado.
     */
    public int nivelDelNodo(Comparable etiqueta);

    /**
     * Busca un elemento dentro del árbol.
     *
     * @param etiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado, en caso de no encontrarlo retorna nulo.
     */
    public T buscar(Comparable etiqueta);

    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param etiqueta Etiqueta del nodo a ser eliminado.
     * @return Dato del nodo eliminado.
     */
    public T eliminar(Comparable etiqueta);

    /**
     * Imprime el arbol por niveles.
     *
     * @return Representacion del arbol por niveles.
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
     * Retorna las etiquetas segun un recorrido inOrden del arbol.
     *
     * @param lista Lista que guardara el inOrden del arbol.
     * @return Lista que guardara el inOrden del arbol.
     */
    public ILista<T> listaInOrden(ILista<T> lista);
}
