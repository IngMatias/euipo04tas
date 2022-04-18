/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut3.ta16;

/**
 *
 * @author nnavarro
 */
public class Participante
{
    private Comparable id;
    private String nombre;

    public Participante(Comparable id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
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
    
    
}
