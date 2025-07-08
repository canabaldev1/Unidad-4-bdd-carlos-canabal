package Menu;

import DAO.Inplementacion.CicloAcademicoDAOImp;
import Dominio.CicloAcademico;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lm-carlos
 */
public class MenuCicloAcademico {

    public static void mostrarMenu() {

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GESTIÓN DE CICLOS ACADÉMICOS ===");
            System.out.println("1. Consultar todos los ciclos");
            System.out.println("2. Consultar ciclo por ID");
            System.out.println("3. Crear nuevo ciclo");
            System.out.println("4. Editar ciclo existente");
            System.out.println("5. Eliminar ciclo");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            String accion = keyboard.nextLine();

            switch (accion) {
                case "1":
                    consultarTodosCiclos();
                    break;
                case "2":
                    consultarCicloPorId();
                    break;
                case "3":
                    crearCiclo();
                    break;
                case "4":
                    editarCiclo();
                    break;
                case "5":
                    eliminarCiclo();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void consultarTodosCiclos() {

        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        try {
            List<CicloAcademico> ciclos = cicloDao.buscarTodos();
            if (ciclos.isEmpty()) {
                System.out.println("\nNo hay ciclos académicos registrados.");
            } else {
                System.out.println("\n=== LISTADO DE CICLOS ACADÉMICOS ===");
                ciclos.forEach(ciclo -> {
                    System.out.println(ciclo.toString());
                    System.out.println("-----------------------------------");
                });
            }
        } catch (Exception e) {
            System.err.println("Error al consultar ciclos: " + e.getMessage());
        }
    }

    private static void consultarCicloPorId() {

        Scanner keyboard = new Scanner(System.in);
        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        System.out.print("\nIngrese el ID del ciclo a consultar: ");
        String id = keyboard.nextLine();

        try {
            CicloAcademico ciclo = cicloDao.buscarPorId(id);
            if (ciclo != null) {
                System.out.println("\n=== DETALLE DEL CICLO ===");
                System.out.println(ciclo.toString());
            } else {
                System.out.println("\nNo se encontró un ciclo con el ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar ciclo: " + e.getMessage());
        }
    }

    private static void crearCiclo() {

        Scanner keyboard = new Scanner(System.in);
        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        System.out.println("\n=== CREAR NUEVO CICLO ACADÉMICO ===");

        CicloAcademico nuevoCiclo = new CicloAcademico();

        System.out.print("ID del ciclo: ");
        nuevoCiclo.setId(keyboard.nextLine());

        System.out.print("Año: ");
        nuevoCiclo.setAnio(Integer.parseInt(keyboard.nextLine()));

        System.out.print("Fecha de inicio (YYYY-MM-DD): ");
        try {
            nuevoCiclo.setFechaInicio(LocalDate.parse(keyboard.nextLine()));

        } catch (Exception e) {
            nuevoCiclo.setFechaInicio(LocalDate.parse("1990-01-01"));
        }

        System.out.print("Fecha de fin (YYYY-MM-DD): ");
        nuevoCiclo.setFechaFin(LocalDate.parse(keyboard.nextLine()));

        System.out.print("Estado (ACTIVO/INACTIVO): ");
        nuevoCiclo.setEstado(keyboard.nextLine());

        System.out.print("Cantidad de semanas: ");
        nuevoCiclo.setCantidadSemanas(Integer.parseInt(keyboard.nextLine()));

        try {
            cicloDao.insertar(nuevoCiclo);
            System.out.println("\nCiclo académico creado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al crear ciclo: " + e.getMessage());
        }
    }

    private static void editarCiclo() {

        Scanner keyboard = new Scanner(System.in);
        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        System.out.print("\nIngrese el ID del ciclo a editar: ");
        String id = keyboard.nextLine();

        try {
            CicloAcademico ciclo = cicloDao.buscarPorId(id);
            if (ciclo == null) {
                System.out.println("\nNo se encontró un ciclo con el ID: " + id);
                return;
            }

            System.out.println("\n=== EDITANDO CICLO ===");
            System.out.println(ciclo.toString());

            System.out.print("Nuevo año (actual: " + ciclo.getAnio() + "): ");
            String input = keyboard.nextLine();
            if (!input.isEmpty()) {
                ciclo.setAnio(Integer.parseInt(input));
            }

            System.out.print("Nueva fecha de inicio (YYYY-MM-DD) (actual: "
                    + ciclo.getFechaInicio() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                ciclo.setFechaInicio(LocalDate.parse(input));
            }

            System.out.print("Nueva fecha de fin (YYYY-MM-DD) (actual: "
                    + ciclo.getFechaFin() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                ciclo.setFechaFin(LocalDate.parse(input));
            }

            System.out.print("Estado (ACTIVO/INACTIVO) (actual: "
                    + ciclo.getEstado() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                ciclo.setEstado(input);
            }

            System.out.print("Cantidad de semanas (actual: "
                    + ciclo.getCantidadSemanas() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                ciclo.setCantidadSemanas(Integer.parseInt(input));
            }

            cicloDao.actualizar(ciclo);
            System.out.println("\nCiclo académico actualizado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al editar ciclo: " + e.getMessage());
        }
    }

    private static void eliminarCiclo() {

        Scanner keyboard = new Scanner(System.in);
        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        System.out.print("\nIngrese el ID del ciclo a eliminar: ");
        String id = keyboard.nextLine();

        try {
            CicloAcademico ciclo = cicloDao.buscarPorId(id);
            if (ciclo == null) {
                System.out.println("\nNo se encontró un ciclo con el ID: " + id);
                return;
            }

            System.out.println("\nEstá a punto de eliminar el siguiente ciclo:");
            System.out.println(ciclo.toString());
            System.out.print("¿Está seguro? (S/N): ");
            String confirmacion = keyboard.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                cicloDao.eliminar(id);
                System.out.println("\nCiclo académico eliminado exitosamente!");
            } else {
                System.out.println("\nOperación cancelada.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar ciclo: " + e.getMessage());
        }
    }
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
