package ITADs;

public interface IDiccionario<T> {

    /**
     * Retorna si el diccionario es vacio.
     * @return True si el diccionario es vacio, false en caso contrario.
     */
    public boolean esVacio();
    /**
     * Retorna verdadero si la clave pertenece al diccionario.
     *
     * @param clave Clave a ser buscada.
     * @return True en caso de que la clave pertenezca al diccionario, false en
     * caso contrario.
     */
    public boolean esClave(Comparable clave);

    /**
     * Agrega un elemento clave-valor al diccionario.
     *
     * @param clave Clave del nuevo elemento a ser agregado.
     * @param valor Valor del nuevo elemento a ser agregado.
     * @return Se retorna true en caso de exito, false en caso de clave en uso.
     */
    public boolean agregar(Comparable clave, T valor);

    /**
     * Obtiene un valor segun la clave parametro.
     *
     * @param clave Clave a ser buscada.
     * @return Valor de la clave buscada.
     */
    public T obtener(Comparable clave);

    /**
     * Elimina el nodo con la clave parametro.
     * @param clave Clave a ser eliminada.
     * @return Retorna el dato que acompaña a la clave eliminada.
     */
    public T eliminar(Comparable clave);
}
