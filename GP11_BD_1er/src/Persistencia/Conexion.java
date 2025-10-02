package Persistencia;

import java.sql.*;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

/* @author Grupo 11 */
public class Conexion {

    // atributo(s)
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "gp11_bd_1er";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    // constructor(es)
    private Conexion() {
    }

    // método(s)
    public static Connection getConexion() {
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos.");
            }
        }
        return connection;
    }

    // getter(s) & setter(s)
}
