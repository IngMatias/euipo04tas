/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ta1.mavenproject2;

/**
 *
 * @author ingFo
 */
public class Compilador {
    public boolean controlCorchetes(String lista) {
        
        IPila<Character> aux = new Pila();
        
        for (int i=0; i<lista.length(); i++) {
            
            char letra = lista.charAt(i);
            
            if(esDeApertura(letra)) {
                
                aux.apilar(letra);
            } else {
                if (aux.esVacia()) return false;
                aux.desapilar();
            }
        }
        
        return aux.esVacia();
    }
    
    private boolean esDeApertura(char letra) {
        return '{' == letra;
    }
}
