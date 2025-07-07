package ConexionBD;

/**
 *
 * @author lm-carlos
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConexionBD {
    // Configuración de la conexión
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_escolar";
    private static final String USER = "carlos_canabal";
    private static final String PASSWORD = "Carlos123";
    
    // Configuración adicional recomendada
    private static final Properties PROPS = new Properties();
    
    static {
        try {
            // Registrar el driver (opcional en JDBC 4.0+ pero recomendado)
            Class.forName("org.postgresql.Driver");
            
            // Configuración adicional para mejor rendimiento
            PROPS.setProperty("user", USER);
            PROPS.setProperty("password", PASSWORD);
            PROPS.setProperty("ssl", "false");
            PROPS.setProperty("preparedStatementCacheQueries", "256");
            PROPS.setProperty("preparedStatementCacheSizeMiB", "5");
            PROPS.setProperty("applicationName", "GestionEscolarApp");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error al registrar el driver PostgreSQL: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
     * Obtiene una conexión a la base de datos
     * @return Connection objeto de conexión
     * @throws SQLException si ocurre un error al conectar
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, PROPS);
    }
    
    /**
     * Cierra una conexión de manera segura
     * @param conn La conexión a cerrar
     */
    public static void cerrar(Connection conn) {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
    
    /**
     * Cierra varios recursos de JDBC
     * @param recursos Los recursos a cerrar (Connection, Statement, ResultSet)
     */
    public static void cerrar(AutoCloseable... recursos) {
        for (AutoCloseable recurso : recursos) {
            if (recurso != null) {
                try {
                    recurso.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar recurso: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Inicia una transacción
     * @param conn La conexión donde iniciar la transacción
     * @throws SQLException si ocurre un error
     */
    public static void iniciarTransaccion(Connection conn) throws SQLException {
        conn.setAutoCommit(false);
    }
    
    /**
     * Confirma una transacción
     * @param conn La conexión donde confirmar
     */
    public static void confirmarTransaccion(Connection conn) {
        try {
            if (conn != null && !conn.getAutoCommit()) {
                conn.commit();
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.err.println("Error al confirmar transacción: " + e.getMessage());
        }
    }
    
    /**
     * Revierte una transacción
     * @param conn La conexión donde revertir
     */
    public static void revertirTransaccion(Connection conn) {
        try {
            if (conn != null && !conn.getAutoCommit()) {
                conn.rollback();
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.err.println("Error al revertir transacción: " + e.getMessage());
        }
    }
}