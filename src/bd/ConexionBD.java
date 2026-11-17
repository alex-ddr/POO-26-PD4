package bd;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Ya tenía la conexión en otra clase, pero aquí va un commit para validar los puntos de la sesión del 17/11

public class ConexionBD {

    public static Connection obtenerConexion() throws SQLException {
        try (FileInputStream fis = new FileInputStream(".env")) {
            Properties props = new Properties();
            props.load(fis);

            String connString = props.getProperty("DATABASE_URL").replace("\"", "").trim();
            return DriverManager.getConnection(connString);
        } catch (Exception e) {
            throw new SQLException("Error leyendo .env o conectando a Neon: " + e.getMessage());
        }
    }

    public static boolean probarConexion() {
        try (Connection conn = obtenerConexion()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return false;
        }
    }
}