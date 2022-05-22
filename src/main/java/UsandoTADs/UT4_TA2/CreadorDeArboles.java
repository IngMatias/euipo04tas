package UsandoTADs.UT4_TA2;

import ITADs.IArbolBB;
import ImplementacionesTADs.ArbolBB;
import Utils.ManejadorArchivosGenerico;
import java.util.ArrayList;

public class CreadorDeArboles {

    private final IArbolBB arbol = new ArbolBB();

    public IArbolBB cargadorDeAltas() {
        String[] etiquetas = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\UsandoTADs\\UT4_TA2\\claves1.txt");
        for (String etiqueta : etiquetas) {
            this.arbol.insertar(Integer.parseInt(etiqueta), null);
        }
        return arbol;
    }

    public ArrayList<String> buscador() {
        ArrayList<String> resultado = new ArrayList();
        String[] etiquetas = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\UsandoTADs\\UT4_TA2\\claves2.txt");
        for (String etiqueta : etiquetas) {
            if (arbol.buscar(etiqueta) != null) {
                resultado.add(etiqueta + " encontrada");
            } else {
                resultado.add(etiqueta + " no encontrada");
            }
        }
        ManejadorArchivosGenerico.escribirArchivo("src\\main\\java\\UsandoTADs\\UT4_TA2\\claves2_salida.txt", resultado.toArray(new String[0]));
        return resultado;
    }
}
