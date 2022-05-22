package ITADs;

public interface IConjunto<T> {

    /**
     * Metodo encargado de revisar si un nodo, cuya clave es la indicada,
     * pertenece al conjunto.
     *
     * @param etiqueta Clave del nodo a revisar.
     * @return True en caso de encontrarlo, false en caso contrario.
     */
    public boolean pertenece(Comparable etiqueta);

    /**
     * Indica si el conjunto contiene o no elementos.
     *
     * @return True si no tiene elementos, false en caso contrario.
     */
    public boolean esVacio();

    /**
     * Indica si dos conjuntos contienen o no elementos.
     *
     * @param conjunto Conjunto a ser comparado.
     * @return True si tienen los mismos elementos, false en caso contrario.
     */
    public boolean esIgual(IConjunto conjunto);

    /**
     * @return Indice al primer nodo del conjunto.
     */
    public IIndice<T> getIndice();

    /**
     * Agrega un elemento al conjunto.
     *
     * @param etiqueta Etiqueta del nuevo nodo a ser agregado.
     */
    public void insertar(Comparable etiqueta, T dato);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminacion haya sido efectuada con exito,
     * false en caso contrario.
     */
    public T eliminar(Comparable clave);

    /**
     * Retorna la union de dos conjuntos.
     *
     * @param conjunto Conjunto a ser unido.
     * @return Nuevo conjunto resultado.
     */
    public IConjunto union(IConjunto conjunto);

    /**
     * Retorna la interseccion de dos conjuntos.
     *
     * @param conjunto Conjunto a ser intersectado.
     * @return Nuevo conjunto resultado.
     */
    public IConjunto interseccion(IConjunto conjunto);

    /**
     * Retorna la diferencia de dos conjuntos.
     *
     * @param conjunto Conjunto a ser restado.
     * @return Nuevo conjunto resultado.
     */
    public IConjunto diferencia(IConjunto conjunto);

    /**
     * Retorna la diferencia simetrica de dos conjuntos.
     *
     * @param conjunto Conjunto con el cual hacer la diferencia simetrica.
     * @return Nuevo conjunto resultado.
     */
    public IConjunto diferenciaSimetrica(IConjunto conjunto);

    /**
     * Metodo encargado de retornar una representacion del conjunto.
     *
     * @return Conjunto en forma de String.
     */
    public String imprimir();

    /**
     * Metodo encargado de retornar una representacion del conjunto, con el uso
     * de separador.
     *
     * @param separador Separa las claves.
     * @return Conjunto en forma de String.
     */
    public String imprimir(String separador);

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * parametro, con apertura y cierre definidos.
     *
     * @param separador Separa las claves.
     * @param apertura Abre la impresion.
     * @param cierre Cierra la impresion.
     * @return Conjunto en forma de String.
     */
    public String imprimir(String separador, String apertura, String cierre);
}
