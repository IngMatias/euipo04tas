/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut3.ta16;

import ucu.edu.uy.tda.ILista;
import ucu.edu.uy.tda.Lista;
import ucu.edu.uy.tda.ListaOrdenada;
import ucu.edu.uy.tda.Nodo;
import ucu.edu.uy.util.ManejadorArchivosGenerico;
import ucu.edu.uy.ut3.ta16.Pelicula;


/**
 *
 * @author nnavarro
 */
public class Productora
{

    public static final String ARCHIVO_PELIS = "peliculas.csv";
    public static final String ARCHIVO_PERSONAS = "personas.csv";
    public static final String ARCHIVO_PERSONAS_EN_PELIS = "pers_participa_peli.csv";
    public Lista<Pelicula> listaPeliculas = new Lista<Pelicula>();

    public void cargarDatos()
    {   
        String[] pelisToAdd = ManejadorArchivosGenerico.leerArchivo(ARCHIVO_PELIS);
        for(int i=0; i<pelisToAdd.length; i++){
            String[] splitted = pelisToAdd[i].split(",");
            if(splitted.length != 6){
                continue;
            }
            try {
            Comparable idPelicula = Integer.parseInt(splitted[0]);
            String nombre = splitted[1];
            int año = Integer.parseInt(splitted[2]);
            int score = Integer.parseInt(splitted[3]);
            String genero = splitted[4];
            String idiomaOriginal = splitted[5];

            Pelicula pelicula = new Pelicula(idPelicula, nombre, año, score, genero, idiomaOriginal);
            Nodo<Pelicula> nodoPelicula = new Nodo<Pelicula>(idPelicula,pelicula);
            this.listaPeliculas.insertarAlInicio(nodoPelicula);
                
            } catch (Exception e) {
                //TODO: handle exception
            }

        }

        Lista<Participante> nombreParticipantes = new Lista<Participante>();
        String[] personasToAdd = ManejadorArchivosGenerico.leerArchivo(ARCHIVO_PERSONAS);
        for(int i=0; i<personasToAdd.length; i++){
            String[] splitted = personasToAdd[i].split(",");
            if(splitted.length != 2){
                continue;
            }
            try {
            Comparable idPersona = Integer.parseInt(splitted[0]);
            String nombre = splitted[1];

            Participante participante = new Participante(idPersona, nombre);
            Nodo<Participante> nodoParticipante = new Nodo<Participante>(idPersona,participante);
            nombreParticipantes.insertarAlInicio(nodoParticipante);
                
            } catch (Exception e) {
                //TODO: handle exception
            }

        }


        String[] persParticipaPelis = ManejadorArchivosGenerico.leerArchivo(ARCHIVO_PERSONAS_EN_PELIS);
        for(int i=0; i<persParticipaPelis.length; i++){
            String[] splitted = persParticipaPelis[i].split(",");
            if(splitted.length != 2){
                continue;
            }
            try {
            Comparable idPersona = Integer.parseInt(splitted[0]);
            Comparable idPelicula = Integer.parseInt(splitted[1]);

            Nodo<Pelicula> nodoPelicula = this.listaPeliculas.buscar(idPelicula);
            Nodo<Participante> nodoParticipante = nombreParticipantes.buscar(idPersona);
            if(nodoPelicula != null && nodoParticipante != null){

                nodoPelicula.getDato().getListaParticipantes().insertarAlInicio(nodoParticipante);
            }
                
            } catch (Exception e) {
                //TODO: handle exception
            }

        }
        
    }

    public Lista<Participante> obtenerParticipantesPelicula(Comparable idPelicula)
    {   

        Nodo<Pelicula> pelicula = this.listaPeliculas.buscar(idPelicula);
        if(pelicula != null){
            return pelicula.getDato().getListaParticipantes();
        }
        return new Lista<Participante>();
        
    }

    public Lista<Pelicula> obtenerPeliculasDelParticipante(Comparable idParticipante)
    {
        
        Lista<Pelicula> toReturn = new Lista<Pelicula>();
        Nodo<Pelicula> pelicula = this.listaPeliculas.getPrimero();
        while (pelicula != null){
            Nodo<Participante> nodoParticipante = pelicula.getDato().getListaParticipantes().buscar(idParticipante);
            if(nodoParticipante != null){
                toReturn.insertarAlInicio(pelicula);
            }
            
            pelicula = pelicula.getSiguiente();
        }
        return toReturn;
    }

    public void AgregarPelicula(Pelicula p){
        Nodo<Pelicula> pelicula = new Nodo<Pelicula>(p.getId(),p);
        this.listaPeliculas.insertarAlInicio(pelicula);
    }

    public Participante getParticipante(Comparable idParticipante){

        Pelicula p = new Pelicula();
        return p.getListaParticipantes().buscar(idParticipante).getDato();
      
    }

    public Pelicula getPelicula(Comparable idPelicula){

        return this.listaPeliculas.buscar(idPelicula).getDato();
      
    }
}
