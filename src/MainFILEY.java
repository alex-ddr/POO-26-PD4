import bd.FileyDAO;
import mvc.FileyControlador;
import mvc.FileyModelo;
import mvc.FileyVista;

public class MainFILEY {
    public static void main(String[] args) {
        // 1. Instanciar capa de Base de Datos (DAO)
        FileyDAO dao = new FileyDAO();

        // 2. Instanciar las capas del patrón MVC
        FileyModelo modelo = new FileyModelo(dao);
        FileyVista vista = new FileyVista();
        FileyControlador controlador = new FileyControlador(modelo, vista);

        // 3. Probar conexión y presentar las listas de cada tabla
        controlador.iniciarLecturaYPresentacion();
    }
}