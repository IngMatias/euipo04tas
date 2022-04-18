/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut3.ta16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ucu.edu.uy.tda.Lista;

/**
 *
 * @author nnavarro
 */
public class ProductoraTest
{
    
    public ProductoraTest()
    {
    }
    
    @BeforeAll
    public static void setUpClass()
    {
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    }
    
    @BeforeEach
    public void setUp()
    {
    }
    
    @AfterEach
    public void tearDown()
    {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void obtenerParticipantesPeliculaTest()
    {
        Productora productora = new Productora();
        Participante participante = new Participante(12, "Juan");
        Pelicula pelicula = new Pelicula(1278, "John Wick", 2013, 10, "disparos", "inglés");
        pelicula.addParticipante(participante);
        productora.AgregarPelicula(pelicula);
        Lista<Participante> participantesPeli = productora.obtenerParticipantesPelicula(1278);
        assertEquals("12", participantesPeli.imprimir());
    }
    
    @Test
    public void obtenerPeliculasDelParticipanteTest()
    {
        Productora productora = new Productora();
        Participante participante = new Participante(12, "Juan");
        Pelicula pelicula = new Pelicula(1278, "John Wick", 2013, 10, "disparos", "inglés");
        pelicula.addParticipante(participante);
        productora.AgregarPelicula(pelicula);
        Lista<Pelicula> peliculas = productora.obtenerPeliculasDelParticipante(12);
        assertEquals("1278", peliculas.imprimir());
    }
}
