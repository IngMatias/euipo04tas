/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ta1.mavenproject2;

import java.util.*;


/**
 *
 * @author ingFo
 */
public class Compilador {
    public boolean controlCorchetes(String lista) {
        
        Stack<Character> aux = new Stack();
        
        for (int i=0; i<lista.length(); i++) {
            
            char letra = lista.charAt(i);
            
            if(esDeApertura(letra)) {
                
                aux.push(letra);
            } else {
                if (aux.isEmpty()) return false;
                aux.pop();
            }
        }
        
        return aux.isEmpty();
    }
    
    private boolean esDeApertura(char letra) {
        return '{' == letra;
    }
}
