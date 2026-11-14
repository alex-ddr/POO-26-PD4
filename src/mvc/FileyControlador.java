package mvc;

import datos.*;
import java.util.List;

public class FileyControlador {
    private final FileyModelo modelo;
    private final FileyVista vista;

    public FileyControlador(FileyModelo modelo, FileyVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarLecturaYPresentacion() {
        boolean conectado = modelo.verificarConexionBD();
        vista.mostrarEstadoConexion(conectado);

        if (conectado) {
            List<Stand> stands = modelo.obtenerStands();
            vista.mostrarListaStands(stands);

            List<Editorial> editoriales = modelo.obtenerEditoriales();
            vista.mostrarListaEditoriales(editoriales);

            List<Reserva> reservaciones = modelo.obtenerReservaciones();
            vista.mostrarListaReservaciones(reservaciones);
        }
    }
}