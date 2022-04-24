/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ta1.mavenproject2;

/**
 *
 * @author ingFo
 * @param <T>
 */
public class Pila<T> implements IPila<T>{
    
    private Lista<T> lista = new Lista();
    
    public boolean apilar(T dato) {
        this.lista.insertarAlInicio(new Nodo("", dato));
        return true;
    }
    
    public T desapilar() {
        T toReturn = this.lista.getPrimero().getDato();
        this.lista.eliminar("");
        return toReturn;
    }
    
    public T tope() {
        if (this.esVacia()) {
            return null;
        }
        else {
            return this.lista.getPrimero().getDato();
        }
    }
    
    public boolean esVacia() {
        return this.lista.esVacia();
    }
    
    public void vaciar() {
        this.lista = new Lista();
    }
    
    public boolean estaLlena() {
        return false;
    }
}
