/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unidad_4_bdd_carlos_canabal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lm-carlos
 */
public class Unidad_4_bdd_carlos_canabal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String url = "jdbc:postgresql://localhost:5432/gestion_escolar";
        String user = "carlos_canabal";
        String password = "Carlos123";

        try {
            // Registrar el driver (opcional en versiones recientes)
            Class.forName("org.postgresql.Driver");

            // Establecer conexión
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a PostgreSQL!");

            // Ejemplo de consulta
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT version()");

            if (rs.next()) {
                System.out.println("Versión de PostgreSQL: " + rs.getString(1));
            }

            // Cerrar recursos
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
