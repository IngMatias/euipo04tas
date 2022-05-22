package UsandoTADs.UT3_TA1_TA2;

public class Producto {

    private String id;
    private String nombre;
    private float precio;
    private int stock;

    public Producto(String id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public int agregarStock(int paraAgregar) {
        this.stock += paraAgregar;
        return this.stock;
    }

    public int reducirStock(int paraRestar) {
        this.stock -= paraRestar;
        if (this.stock < 0) {
            this.stock = 0;
        }
        return this.stock;
    }

    public String toString() {
        return "Id: " + this.id
                + "Nombre: " + this.nombre
                + "Precio: " + this.precio
                + "Stock: " + this.stock;
    }
}
