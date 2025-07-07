/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unidad_4_bdd_carlos_canabal;

import Consultas.ConsultasRequeridas;
import DAO.Inplementacion.CicloAcademicoDAOImp;
import Menu.MenuAlumno;
import Menu.MenuCicloAcademico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

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

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ciclo Académico");
            System.out.println("2. Alumno");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = keyboard.nextLine();

            switch (opcion) {
                case "1":
                    MenuCicloAcademico.mostrarMenu();
                    break;
                case "2":
                    MenuAlumno.mostrarMenu();
                    break;
                case "3":
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }

    }
}
