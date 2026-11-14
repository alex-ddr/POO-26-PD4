package datos;

public class Editorial {
    private int id;
    private String nombre;
    private String correoContacto;

    public Editorial(int id, String nombre, String correoContacto) {
        this.id = id;
        this.nombre = nombre;
        this.correoContacto = correoContacto;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreoContacto() { return correoContacto; }

    @Override
    public String toString() {
        return String.format("Editorial ID: %d | Nombre: %s | Correo: %s", id, nombre, correoContacto);
    }
}