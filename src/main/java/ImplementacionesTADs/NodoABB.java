package ImplementacionesTADs;

import ITADs.ILista;
import ITADs.ICola;
import ITADs.INodo;
import ITADs.INodoABB;

public class NodoABB<T> implements INodoABB<T> {

    private final Comparable etiqueta;
    private final T dato;
    private INodoABB<T> izquierdo;
    private INodoABB<T> derecho;

    public NodoABB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public INodoABB<T> getDerecho() {
        return derecho;
    }

    @Override
    public void setDerecho(INodoABB<T> derecho) {
        this.derecho = derecho;
    }

    @Override
    public INodoABB<T> getIzquierdo() {
        return izquierdo;
    }

    @Override
    public void setIzquierdo(INodoABB<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    @Override
    public int altura() {
        int alturaIzquierda = 0;
        int alturaDerecha = 0;
        if (this.getIzquierdo() != null) {
            alturaIzquierda = this.getIzquierdo().altura();
        }
        if (this.getDerecho() != null) {
            alturaDerecha = this.getDerecho().altura();
        }
        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    @Override
    public ILista<Comparable> caminoMasLargo() {
        ILista<Comparable> masLargoIzquierdo = new Lista();
        ILista<Comparable> masLargoDerecho = new Lista();
        if (this.izquierdo != null) {
            masLargoIzquierdo = this.izquierdo.caminoMasLargo();
        }
        if (this.derecho != null) {
            masLargoDerecho = this.derecho.caminoMasLargo();
        }
        if (masLargoIzquierdo.cantElementos() < masLargoDerecho.cantElementos()) {
            masLargoDerecho.insertarAlInicio(this.getEtiqueta(), this.getEtiqueta());
            return masLargoDerecho;
        }
        masLargoIzquierdo.insertarAlInicio(this.getEtiqueta(), this.getEtiqueta());
        return masLargoIzquierdo;
    }

    @Override
    public int tamanio() {
        int tamanioIzquierdo = 0;
        int tamanioDerecho = 0;
        if (this.getIzquierdo() != null) {
            tamanioIzquierdo = this.getIzquierdo().tamanio();
        }
        if (this.getDerecho() != null) {
            tamanioDerecho = this.getDerecho().tamanio();
        }
        return 1 + tamanioIzquierdo + tamanioDerecho;
    }

    @Override
    public int cantidadDeHojas() {
        int cantidadIzquierda = 0;
        int cantidadDerecha = 0;
        if (this.getIzquierdo() == null && this.getDerecho() == null) {
            return 1;
        }
        if (this.getIzquierdo() != null) {
            cantidadIzquierda = this.getIzquierdo().cantidadDeHojas();
        }
        if (this.getDerecho() != null) {
            cantidadDerecha = this.getDerecho().cantidadDeHojas();
        }
        return cantidadIzquierda + cantidadDerecha;
    }

    @Override
    public int nivelDelNodo(Comparable etiqueta) {
        int resultado = 0;
        if (this.compareTo(etiqueta) == 0) {
            return 1;
        }
        if (this.compareTo(etiqueta) < 0) {
            if (this.getDerecho() != null) {
                resultado = this.getDerecho().nivelDelNodo(etiqueta);
            } else {
                return -1;
            }
        }
        if (0 < this.compareTo(etiqueta)) {
            if (this.getIzquierdo() != null) {
                resultado = this.getIzquierdo().nivelDelNodo(etiqueta);
            } else {
                return -1;
            }
        }
        if (resultado < 0) return -1;
        return resultado + 1;
    }

    @Override
    public boolean insertar(Comparable etiqueta, T dato) {
        if (this.getEtiqueta().compareTo(etiqueta) < 0) {
            if (this.getDerecho() != null) {
                return this.getDerecho().insertar(etiqueta, dato);
            } else {
                this.setDerecho(new NodoABB(etiqueta, dato));
                return true;
            }
        }
        if (0 < this.getEtiqueta().compareTo(etiqueta)) {
            if (this.getIzquierdo() != null) {
                return this.getIzquierdo().insertar(etiqueta, dato);
            } else {
                this.setIzquierdo(new NodoABB(etiqueta, dato));
                return true;
            }
        }
        return false;
    }

    @Override
    public T buscar(Comparable etiqueta) {
        if (this.getEtiqueta().compareTo(etiqueta) == 0) {
            return this.getDato();
        }
        if (0 < this.getEtiqueta().compareTo(etiqueta) && this.getIzquierdo() != null) {
            return this.getIzquierdo().buscar(etiqueta);
        }
        if (this.getEtiqueta().compareTo(etiqueta) < 0 && this.getDerecho() != null) {
            return this.getDerecho().buscar(etiqueta);
        }
        return null;
    }

    /*
    // precondicion this.getIzquierdo() != null
    public INodoABB<T> eliminarMenor() {
        INodoABB aux = this;
        while (aux.getIzquierdo().getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        INodoABB toReturn = aux.getIzquierdo();
        aux.setIzquierdo(toReturn.getDerecho());
        return toReturn;
    }

    // precondicion: this.getDerecho() != null
    public INodoABB<T> eliminarMayor() {
        INodoABB aux = this;
        while (aux.getDerecho().getDerecho() != null) {
            aux = aux.getDerecho();
        }
        INodoABB toReturn = aux.getDerecho();
        aux.setDerecho(toReturn.getIzquierdo());
        return toReturn;
    }

    // precondicion: el nodo a eliminar no puede ser el this
    public T eliminar(Comparable etiqueta) {
        if (0 < this.etiqueta.compareTo(etiqueta) && this.izquierdo != null) {
            if (this.izquierdo.getEtiqueta().compareTo(etiqueta) == 0) {
                INodoABB<T> toReturn = this.izquierdo;
                if (toReturn.getDerecho() == null) {
                    this.izquierdo = this.izquierdo.getIzquierdo();
                } else {
                    INodoABB reemplazante = toReturn.eliminarMayor();
                    reemplazante.setIzquierdo(toReturn.getIzquierdo());
                    reemplazante.setDerecho(toReturn.getDerecho());
                    this.izquierdo = reemplazante;
                }
                return toReturn.getDato();
            }
            //return this.izquierdo.eliminar(etiqueta);
            return null
        }

        if (this.etiqueta.compareTo(etiqueta) < 0 && this.derecho != null) {
            if (this.derecho.getEtiqueta().compareTo(etiqueta) == 0) {
                INodoABB<T> toReturn = this.derecho;
                if (toReturn.getIzquierdo() == null) {
                    this.derecho = this.derecho.getDerecho();
                } else {
                    INodoABB reemplazante = toReturn.eliminarMenor();
                    reemplazante.setIzquierdo(toReturn.getIzquierdo());
                    reemplazante.setDerecho(toReturn.getDerecho());
                    this.derecho = reemplazante;
                }
                return toReturn.getDato();
            }
            return this.derecho.eliminar(etiqueta);
        }

        return null;
    }
     */
    @Override
    public String imprimirPorNiveles() {
        String toReturn = "";
        ICola<INodoABB> colaAuxImpresion = new Cola();
        ICola<INodoABB> colaAuxProximos = new Cola();
        colaAuxImpresion.encolar(this);
        while (!colaAuxImpresion.esVacia()) {
            while (!colaAuxImpresion.esVacia()) {
                INodoABB aux = colaAuxImpresion.desencolar();
                if (aux == null) {
                    toReturn += "     ";
                } else {
                    String etiquetaActual = aux.getEtiqueta() + "";
                    toReturn += etiquetaActual + " ".repeat(5 - etiquetaActual.length());
                }
                if (aux != null && aux.getIzquierdo() != null) {
                    colaAuxProximos.encolar(aux.getIzquierdo());
                } else {
                    colaAuxProximos.encolar(null);
                }
                if (aux != null && aux.getDerecho() != null) {
                    colaAuxProximos.encolar(aux.getDerecho());
                } else {
                    colaAuxProximos.encolar(null);
                }
            }
            toReturn += "\n";
            ICola<INodoABB> temp = colaAuxImpresion;
            colaAuxImpresion = colaAuxProximos;
            colaAuxProximos = temp;
        }
        return toReturn;
    }

    @Override
    public String imprimirPreOrden() {
        String toReturn = "";
        toReturn += this.etiqueta;
        if (this.izquierdo != null) {
            toReturn += this.izquierdo.imprimirPreOrden();
        }
        if (this.derecho != null) {
            toReturn += this.derecho.imprimirPreOrden();
        }
        return toReturn;
    }

    @Override
    public String imprimirInOrden() {
        String toReturn = "";
        if (this.izquierdo != null) {
            toReturn += this.izquierdo.imprimirInOrden();
        }
        toReturn += this.etiqueta;
        if (this.derecho != null) {
            toReturn += this.derecho.imprimirInOrden();
        }
        return toReturn;
    }

    @Override
    public String imprimirPostOrden() {
        String toReturn = "";
        if (this.izquierdo != null) {
            toReturn += this.izquierdo.imprimirPostOrden();
        }
        if (this.derecho != null) {
            toReturn += this.derecho.imprimirPostOrden();
        }
        toReturn += this.etiqueta;
        return toReturn;
    }

    @Override
    public void listaInOrden(ILista<T> lista) {
        if (this.izquierdo != null) {
            this.izquierdo.listaInOrden(lista);
        }
        lista.insertarAlFinal(this.getEtiqueta(), this.getDato());
        if (this.derecho != null) {
            this.derecho.listaInOrden(lista);
        }
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.getEtiqueta().compareTo(etiqueta);
    }

    @Override
    public int compareTo(INodo<T> nodo) {
        return this.compareTo(nodo.getEtiqueta());
    }
    
    
}
