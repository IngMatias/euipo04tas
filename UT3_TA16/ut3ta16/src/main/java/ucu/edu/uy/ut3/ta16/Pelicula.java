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
public class Pelicula
{

    private Comparable id;
    private String nombre;
    private int anio;
    private int score;
    private String genero;
    private String idiomaOriginal;
    private Lista<Participante> listaParticipantes = new Lista<Participante>();

    public Pelicula()
    {
    }

    public Pelicula(Comparable id, String nombre, int anio, int score, String genero, String idiomaOriginal)
    {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.score = score;
        this.genero = genero;
        this.idiomaOriginal = idiomaOriginal;
    }

    

    public Comparable getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getAnio()
    {
        return anio;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public String getIdiomaOriginal()
    {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal)
    {
        this.idiomaOriginal = idiomaOriginal;
    }

    public void addParticipante(Participante p){

        Nodo<Participante> nodoParticipante = new Nodo<Participante>(p.getId(),p);
        this.listaParticipantes.insertarAlInicio(nodoParticipante);
    }

    public Participante getParticipante(Comparable idParticipante){

        return this.listaParticipantes.buscar(idParticipante).getDato();
    }

    public Lista<Participante> getListaParticipantes()
    {
        return this.listaParticipantes;
    }

    

}
