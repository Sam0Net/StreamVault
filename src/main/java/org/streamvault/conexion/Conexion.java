package org.streamvault.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Servidor local, puerto por defecto 1433.
    // encrypt=true y trustServerCertificate=true evitan problemas con certificados autofirmados de desarrollo.
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=streamvault_db;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "18072003@Es.";

    private static Connection conexion = null;

    public static Connection conectar() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conectado exitosamente a SQL Server en Fedora.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a SQL Server: " + e.getMessage());
        }
        return conexion;
    }

    public static void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexion a SQL Server cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexion: " + e.getMessage());
        }
    }
}