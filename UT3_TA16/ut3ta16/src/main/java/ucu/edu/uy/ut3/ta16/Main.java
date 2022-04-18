/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut3.ta16;

import ucu.edu.uy.tda.Lista;
import ucu.edu.uy.tda.Nodo;

/**
 *
 * @author nnavarro
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {  
        Productora productora = new Productora();
        productora.cargarDatos();

        
        Nodo<Pelicula> nodoAuxPelicula = productora.listaPeliculas.getPrimero();
        while(nodoAuxPelicula != null){
            System.out.println(nodoAuxPelicula.getDato().getNombre() + ": "+ nodoAuxPelicula.getDato().getListaParticipantes().getPrimero().getDato().getNombre()); 
            System.out.println("");
            nodoAuxPelicula = nodoAuxPelicula.getSiguiente();
        }
        
        /*
        Participante participante = new Participante(12, "Juan");
        Pelicula pelicula = new Pelicula(1278, "John Wick", 2013, 10, "disparos", "inglés");
        pelicula.addParticipante(participante);
        productora.AgregarPelicula(pelicula);
        Lista<Pelicula> peliculas = productora.obtenerPeliculasDelParticipante(12);
        Lista<Participante> participantesPeli = productora.obtenerParticipantesPelicula(1278);

        
        
       System.out.println("Peliculas del participante: " + peliculas.imprimir());
       System.out.println("");
       System.out.println("Peliculas del participante: " + participantesPeli.imprimir());
         */
    }

}
