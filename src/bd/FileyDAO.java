package bd;

import datos.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Ya tenía la conexión en otra clase, pero aquí va un commit para validar los puntos de la sesión del 17/11

public class FileyDAO {

    public List<Stand> leerStands() {
        List<Stand> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, metros_cuadrados, precio_metro_cuadrado, estado FROM stands ORDER BY id";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Stand s = new Stand(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("metros_cuadrados"),
                    rs.getDouble("precio_metro_cuadrado"),
                    EstadoStand.valueOf(rs.getString("estado"))
                );
                lista.add(s);
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo tabla stands: " + e.getMessage());
        }
        return lista;
    }

    public List<Editorial> leerEditoriales() {
        List<Editorial> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, correo_contacto FROM editoriales ORDER BY id";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Editorial ed = new Editorial(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo_contacto")
                );
                lista.add(ed);
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo tabla editoriales: " + e.getMessage());
        }
        return lista;
    }

    public List<Reserva> leerReservaciones() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT r.id, r.fecha_reserva, r.costo_total_acordado, r.monto_pagado, r.descuento_pronto_pago, " +
                     "s.id AS s_id, s.nombre AS s_nombre, s.metros_cuadrados, s.precio_metro_cuadrado, s.estado, " +
                     "e.id AS e_id, e.nombre AS e_nombre, e.correo_contacto " +
                     "FROM reservaciones r " +
                     "INNER JOIN stands s ON r.stand_id = s.id " +
                     "INNER JOIN editoriales e ON r.editorial_id = e.id " +
                     "ORDER BY r.id";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Stand stand = new Stand(
                    rs.getInt("s_id"),
                    rs.getString("s_nombre"),
                    rs.getDouble("metros_cuadrados"),
                    rs.getDouble("precio_metro_cuadrado"),
                    EstadoStand.valueOf(rs.getString("estado"))
                );

                Editorial editorial = new Editorial(
                    rs.getInt("e_id"),
                    rs.getString("e_nombre"),
                    rs.getString("correo_contacto")
                );

                Reserva reserva = new Reserva(
                    rs.getInt("id"),
                    stand,
                    editorial,
                    rs.getDate("fecha_reserva").toLocalDate(),
                    rs.getDouble("costo_total_acordado"),
                    rs.getDouble("monto_pagado"),
                    rs.getBoolean("descuento_pronto_pago")
                );
                lista.add(reserva);
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo tabla reservaciones: " + e.getMessage());
        }
        return lista;
    }
}