package mvc;

import datos.*;
import java.util.List;

public class FileyVista {

    public void mostrarEstadoConexion(boolean exito) {
        System.out.println("==================================================");
        if (exito) {
            System.out.println("[CONEXIÓN EXITOSA] Conectado a la Base de Datos en la nube (JDBC).");
        } else {
            System.out.println("[ERROR DE CONEXIÓN] No se pudo conectar a la Base de Datos.");
        }
        System.out.println("==================================================\n");
    }

    public void mostrarListaStands(List<Stand> stands) {
        System.out.println("--- LISTA DE STANDS (Tabla: stands) ---");
        for (Stand s : stands) {
            System.out.println("  * " + s);
        }
        System.out.println();
    }

    public void mostrarListaEditoriales(List<Editorial> editoriales) {
        System.out.println("--- LISTA DE EDITORIALES (Tabla: editoriales) ---");
        for (Editorial e : editoriales) {
            System.out.println("  * " + e);
        }
        System.out.println();
    }

    public void mostrarListaReservaciones(List<Reserva> reservaciones) {
        System.out.println("--- LISTA DE RESERVACIONES (Tabla: reservaciones) ---");
        for (Reserva r : reservaciones) {
            System.out.println("  * " + r);
        }
        System.out.println();
    }
}