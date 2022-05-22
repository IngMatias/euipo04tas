package UsandoTADs.UT3_TA16;

import ITADs.ILista;
import ImplementacionesTADs.Lista;

public class Pelicula {

    private int id;
    private String nombre;
    private int anio;
    private int score;
    private String genero;
    private String idiomaOriginal;
    private ILista<Persona> participantes;

    public Pelicula() {
    }

    public Pelicula(int id, String nombre, int anio, int score, String genero, String idiomaOriginal) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.score = score;
        this.genero = genero;
        this.idiomaOriginal = idiomaOriginal;

        this.participantes = new Lista();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public ILista<Persona> getParticipantes() {
        return this.participantes;
    }

    public void agregarParticipante(Persona agregar) {
        this.participantes.insertarAlInicio(agregar.getId(), agregar);
    }

    public boolean participa(Persona consulta) {
        return this.participantes.buscar(consulta.getId()) != null;
    }

}
