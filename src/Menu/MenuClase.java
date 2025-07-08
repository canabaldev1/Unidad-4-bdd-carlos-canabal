package Menu;

import DAO.Inplementacion.AsignaturaDAOImp;
import DAO.Inplementacion.CicloAcademicoDAOImp;
import DAO.Inplementacion.ClaseDAOImp;
import Dominio.Asignatura;
import Dominio.CicloAcademico;
import Dominio.Clase;
import Dominio.GrupoRegular;
import Dominio.ProfesorRegular;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lm-carlos
 */
public class MenuClase {

    public static void mostrarMenu() {

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GESTIÓN DE CLASES ===");
            System.out.println("1. Consultar todos las clases");
            System.out.println("2. Consultar clase por ID");
            System.out.println("3. Crear nuevo clase");
            System.out.println("4. Editar clase existente");
            System.out.println("5. Eliminar clase");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            String accion = keyboard.nextLine();

            switch (accion) {
                case "1":
                    consultarTodasClases();
                    break;
                case "2":
                    consultarClasePorId();
                    break;
                case "3":
                    crearClase();
                    break;
                case "4":
                    editarClase();
                    break;
                case "5":
                    eliminarClase();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void consultarTodasClases() {

        ClaseDAOImp claseDao = new ClaseDAOImp();

        try {
            List<Clase> clases = claseDao.buscarTodos();
            if (clases.isEmpty()) {
                System.out.println("\nNo hay clases registradas.");
            } else {
                System.out.println("\n=== LISTADO DE CLASES ===");
                clases.forEach(clase -> {
                    System.out.println(clase.toString());
                    System.out.println("-----------------------------------");
                });
            }
        } catch (Exception e) {
            System.err.println("Error al consultar clases: " + e.getMessage());
        }
    }

    private static void consultarClasePorId() {

        Scanner keyboard = new Scanner(System.in);
        ClaseDAOImp claseDao = new ClaseDAOImp();

        System.out.print("\nIngrese el ID de la clase a consultar: ");
        String id = keyboard.nextLine();

        try {
            Clase clase = claseDao.buscarPorId(id);
            if (clase != null) {
                System.out.println("\n=== DETALLE DE LA CLASE ===");
                System.out.println(clase.toString());
            } else {
                System.out.println("\nNo se encontró una clase con el ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar clase: " + e.getMessage());
        }
    }

    private static void crearClase() {

        Scanner keyboard = new Scanner(System.in);

        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();
        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        ClaseDAOImp claseDao = new ClaseDAOImp();

        System.out.println("\n=== CREAR NUEVA CLASE ===");

        Clase nuevaClase = new Clase();

        System.out.print("ID del clase: ");
        nuevaClase.setId(keyboard.nextLine());

        System.out.print("ID del profesor de la clase: ");
        String profesorId = keyboard.nextLine();
        ProfesorRegular profesor = new ProfesorRegular();
        nuevaClase.setProfesor(profesor);

        System.out.print("ID del grupo de la clase: ");
        String grupoId = keyboard.nextLine();
        GrupoRegular grupo = new GrupoRegular();
        nuevaClase.setGrupo(grupo);

        System.out.print("ID de la asignatura de la clase: ");
        String asignaturaId = keyboard.nextLine();
        Asignatura asignatura;

        try {
            asignatura = asignaturaDao.buscarPorId(asignaturaId);
            if (asignatura != null) {
                nuevaClase.setAsignatura(asignatura);
            } else {
                System.out.println("\nNo se encontró una asignatura con el ID: " + asignaturaId);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar asignatura: " + e.getMessage());
        }

        System.out.print("ID del ciclo académico de la clase: ");
        String cicloId = keyboard.nextLine();
        CicloAcademico ciclo;

        try {
            ciclo = cicloDao.buscarPorId(cicloId);
            if (ciclo != null) {
                nuevaClase.setCicloAcademico(ciclo);
            } else {
                System.out.println("\nNo se encontró un ciclo con el ID: " + cicloId);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar ciclo: " + e.getMessage());
        }

        try {
            claseDao.insertar(nuevaClase);
            System.out.println("\nClase creada exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al crear clase: " + e.getMessage());
        }
    }

    private static void editarClase() {
        Scanner keyboard = new Scanner(System.in);
        ClaseDAOImp claseDao = new ClaseDAOImp();
        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();
        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        System.out.print("\nIngrese el ID de la clase a editar: ");
        String id = keyboard.nextLine();

        try {
            Clase clase = claseDao.buscarPorId(id);
            if (clase == null) {
                System.out.println("\nNo se encontró una clase con el ID: " + id);
                return;
            }

            System.out.println("\n=== EDITANDO CLASE ===");
            System.out.println(clase.toString());

            // Editar ID del profesor
            System.out.print("Nuevo ID del profesor (actual: "
                    + (clase.getProfesor() != null ? clase.getProfesor().getId() : "Ninguno") + "): ");
            String input = keyboard.nextLine();
            if (!input.isEmpty()) {
                ProfesorRegular profesor = new ProfesorRegular();
                profesor.setId(input);
                clase.setProfesor(profesor);
            }

            // Editar ID del grupo
            System.out.print("Nuevo ID del grupo (actual: "
                    + (clase.getGrupo() != null ? clase.getGrupo().getId() : "Ninguno") + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                GrupoRegular grupo = new GrupoRegular();
                grupo.setId(input);
                clase.setGrupo(grupo);
            }

            // Editar asignatura
            System.out.print("Nuevo ID de asignatura (actual: "
                    + (clase.getAsignatura() != null ? clase.getAsignatura().getId() : "Ninguno") + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                try {
                    Asignatura asignatura = asignaturaDao.buscarPorId(input);
                    if (asignatura != null) {
                        clase.setAsignatura(asignatura);
                    } else {
                        System.out.println("No se encontró la asignatura con ID: " + input);
                    }
                } catch (Exception e) {
                    System.err.println("Error al buscar asignatura: " + e.getMessage());
                }
            }

            // Editar ciclo académico
            System.out.print("Nuevo ID de ciclo académico (actual: "
                    + (clase.getCicloAcademico() != null ? clase.getCicloAcademico().getId() : "Ninguno") + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                try {
                    CicloAcademico ciclo = cicloDao.buscarPorId(input);
                    if (ciclo != null) {
                        clase.setCicloAcademico(ciclo);
                    } else {
                        System.out.println("No se encontró el ciclo con ID: " + input);
                    }
                } catch (Exception e) {
                    System.err.println("Error al buscar ciclo: " + e.getMessage());
                }
            }

            claseDao.actualizar(clase);
            System.out.println("\nClase actualizada exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al editar clase: " + e.getMessage());
        }
    }

    private static void eliminarClase() {

        Scanner keyboard = new Scanner(System.in);
        ClaseDAOImp claseDao = new ClaseDAOImp();

        System.out.print("\nIngrese el ID de la clase a eliminar: ");
        String id = keyboard.nextLine();

        try {
            Clase clase = claseDao.buscarPorId(id);
            if (clase == null) {
                System.out.println("\nNo se encontró una clase con el ID: " + id);
                return;
            }

            System.out.println("\nEstá a punto de eliminar la siguiente clase:");
            System.out.println(clase.toString());
            System.out.print("¿Está seguro? (S/N): ");
            String confirmacion = keyboard.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                claseDao.eliminar(id);
                System.out.println("\nClase eliminada exitosamente!");
            } else {
                System.out.println("\nOperación cancelada.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar clase: " + e.getMessage());
        }
    }
}
