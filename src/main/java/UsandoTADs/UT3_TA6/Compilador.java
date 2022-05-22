package UsandoTADs.UT3_TA6;

import ITADs.IPila;
import ImplementacionesTADs.Pila;

public class Compilador {

    public boolean controlCorchetes(String entrada) {
        IPila<Character> aux = new Pila();
        for (int i = 0; i < entrada.length(); i++) {
            char letra = entrada.charAt(i);
            if (this.esDeApertura(letra)) {
                aux.apilar(letra);
            } else {
                if (aux.esVacia()) {
                    return false;
                }
                aux.desapilar();
            }
        }
        return aux.esVacia();
    }

    private boolean esDeApertura(char parentesis) {
        return parentesis == '{';
    }
}
