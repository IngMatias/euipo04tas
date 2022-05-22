package UsandoTADs.UT3_TA16;

import ITADs.IIndice;
import ITADs.ILista;
import ImplementacionesTADs.Lista;
import UsandoTADs.UT4_TA9.FormatoInvalidoArchivoDeEntrada;
import Utils.ManejadorArchivosGenerico;

public class Productora {

    public static final String ARCHIVO_PELIS = "peliculas.csv";
    public static final String ARCHIVO_PERSONAS = "personas.csv";
    public static final String ARCHIVO_PERSONAS_EN_PELIS = "pers_participa_peli.csv";

    public ILista<Pelicula> peliculas = new Lista();

    public void cargarDatos() throws FormatoInvalidoArchivoDeEntrada, PeliculaNoEncontradaException, PersonaNoEncontradaException {
        String[] peliculas = ManejadorArchivosGenerico.leerArchivo("\\src\\main\\java\\UsandoTADs\\UT3_TA16\\" + ARCHIVO_PELIS);
        for (String pelicula : peliculas) {
            String[] splited = pelicula.split(",");
            if (splited.length != 6) {
                throw new FormatoInvalidoArchivoDeEntrada();
            }
            int id = Integer.parseInt(splited[0]);
            String nombre = splited[1];
            int anio = Integer.parseInt(splited[2]);
            int score = Integer.parseInt(splited[3]);
            String genero = splited[4];
            String idiomaOriginal = splited[5];
            this.peliculas.insertarAlInicio(id, new Pelicula(id, nombre, anio, score, genero, idiomaOriginal));
        }

        String[] personas = ManejadorArchivosGenerico.leerArchivo("\\src\\main\\java\\UsandoTADs\\UT3_TA16\\" + ARCHIVO_PERSONAS);
        ILista<Persona> listaDepersonas = new Lista();
        for (String persona : personas) {
            String[] splited = persona.split(",");
            if (splited.length != 2) {
                throw new FormatoInvalidoArchivoDeEntrada();
            }
            int id = Integer.parseInt(splited[0]);
            String nombre = splited[1];
            listaDepersonas.insertarAlInicio(id, new Persona(id, nombre));
        }

        String[] pers_participa_peli = ManejadorArchivosGenerico.leerArchivo("\\src\\main\\java\\UsandoTADs\\UT3_TA16\\" + ARCHIVO_PERSONAS_EN_PELIS);
        for (String participante : pers_participa_peli) {
            String[] splited = participante.split(",");
            if (splited.length != 2) {
                throw new FormatoInvalidoArchivoDeEntrada();
            }
            int idPersona = Integer.parseInt(splited[0]);
            int idPelicula = Integer.parseInt(splited[1]);
            Persona persona = listaDepersonas.buscar(idPersona);
            Pelicula pelicula = this.peliculas.buscar(idPelicula);
            if (persona == null) {
                throw new PersonaNoEncontradaException();
            }
            if (pelicula == null) {
                throw new PeliculaNoEncontradaException();
            }
            pelicula.agregarParticipante(persona);
        }
    }

    public ILista<Persona> obtenerParticipantesPelicula(Comparable idPelicula) throws PeliculaNoEncontradaException {
        Pelicula aux = this.peliculas.buscar(idPelicula);
        if (aux == null) {
            throw new PeliculaNoEncontradaException();
        }
        return aux.getParticipantes();
    }

    public ILista<Pelicula> obtenerPeliculasDelParticipante(Comparable idParticipante) {
        ILista<Pelicula> toReturn = new Lista();
        IIndice<Pelicula> aux = this.peliculas.getIndice();
        while (aux != null) {
            if (aux.getDato().getParticipantes().buscar(idParticipante) != null) {
                toReturn.insertarAlInicio(aux.getEtiqueta(), aux.getDato());
            }
            aux.setSiguiente();
        }
        return toReturn;
    }
}
