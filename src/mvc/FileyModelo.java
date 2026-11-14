package mvc;

import bd.ConexionBD;
import bd.FileyDAO;
import datos.*;
import java.util.List;

public class FileyModelo {
    private final FileyDAO dao;

    public FileyModelo(FileyDAO dao) {
        this.dao = dao;
    }

    public boolean verificarConexionBD() {
        return ConexionBD.probarConexion();
    }

    public List<Stand> obtenerStands() {
        return dao.leerStands();
    }

    public List<Editorial> obtenerEditoriales() {
        return dao.leerEditoriales();
    }

    public List<Reserva> obtenerReservaciones() {
        return dao.leerReservaciones();
    }
}