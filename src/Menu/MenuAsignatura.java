package Menu;

import DAO.Inplementacion.AsignaturaDAOImp;
import Dominio.Asignatura;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lm-carlos
 */
public class MenuAsignatura {

    public static void mostrarMenu() {

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GESTIÓN DE ASIGNATURA ===");
            System.out.println("1. Consultar todas las asignaturas");
            System.out.println("2. Consultar asignatura por ID");
            System.out.println("3. Crear nueva asignatura");
            System.out.println("4. Editar asignatura existente");
            System.out.println("5. Eliminar asignatura");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            String accion = keyboard.nextLine();

            switch (accion) {
                case "1":
                    consultarTodasAsignaturas();
                    break;
                case "2":
                    consultarAsignaturaPorId();
                    break;
                case "3":
                    crearAsignatura();
                    break;
                case "4":
                    editarAsignatura();
                    break;
                case "5":
                    eliminarAsignatura();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void consultarTodasAsignaturas() {

        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();

        try {
            List<Asignatura> asignaturas = asignaturaDao.buscarTodos();
            if (asignaturas.isEmpty()) {
                System.out.println("\nNo hay asignaturas registrados.");
            } else {
                System.out.println("\n=== LISTADO DE ASIGNATURA ===");
                asignaturas.forEach(asignatura -> {
                    System.out.println(asignatura.toString());
                    System.out.println("-----------------------------------");
                });
            }
        } catch (Exception e) {
            System.err.println("Error al consultar asignaturas: " + e.getMessage());
        }
    }

    private static void consultarAsignaturaPorId() {

        Scanner keyboard = new Scanner(System.in);
        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();

        System.out.print("\nIngrese el ID del asignatura a consultar: ");
        String id = keyboard.nextLine();

        try {
            Asignatura asignatura = asignaturaDao.buscarPorId(id);
            if (asignatura != null) {
                System.out.println("\n=== DETALLE DEL ALUMNO ===");
                System.out.println(asignatura.toString());
            } else {
                System.out.println("\nNo se encontró un asignatura con el ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar asignatura: " + e.getMessage());
        }
    }

    private static void crearAsignatura() {

        Scanner keyboard = new Scanner(System.in);

        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();

        System.out.println("\n=== CREAR NUEVO ALUMNO===");

        Asignatura nuevaAsignatura = new Asignatura();

        System.out.print("ID del asignatura: ");
        nuevaAsignatura.setId(keyboard.nextLine());

        System.out.print("Nombre de la asignatura: ");
        nuevaAsignatura.setNombre(keyboard.nextLine());

        System.out.print("Descripción de la asignatura: ");
        nuevaAsignatura.setDescripcion(keyboard.nextLine());

        System.out.print("Prioridad de la asignatura (BAJA, MEDIA, ALTA): ");
        nuevaAsignatura.setPrioridad(keyboard.nextLine());

        try {
            asignaturaDao.insertar(nuevaAsignatura);
            System.out.println("\nAsignatura creado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al crear asignatura: " + e.getMessage());
        }
    }

    private static void editarAsignatura() {

        Scanner keyboard = new Scanner(System.in);
        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();

        System.out.print("\nIngrese el ID del asignatura a editar: ");
        String id = keyboard.nextLine();

        try {
            Asignatura asignatura = asignaturaDao.buscarPorId(id);
            if (asignatura == null) {
                System.out.println("\nNo se encontró un asignatura con el ID: " + id);
                return;
            }

            System.out.println("\n=== EDITANDO ALUMNO ===");
            System.out.println(asignatura.toString());

            String input;

            System.out.print("Nuevo nombre (actual: " + asignatura.getNombre() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                asignatura.setNombre(input);
            }

            System.out.print("Nueva descripción (actual: " + asignatura.getDescripcion() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                asignatura.setDescripcion(input);
            }

            System.out.print("Nueva prioridad (ALTA, MEDIA, BAJA) (actual: " + asignatura.getPrioridad() + ") [YYYY-MM-DD]: ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                asignatura.setPrioridad(input);
            }

            asignaturaDao.actualizar(asignatura);
            System.out.println("\nAsignatura actualizado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al editar asignatura: " + e.getMessage());
        }
    }

    private static void eliminarAsignatura() {

        Scanner keyboard = new Scanner(System.in);
        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();

        System.out.print("\nIngrese el ID del asignatura a eliminar: ");
        String id = keyboard.nextLine();

        try {
            Asignatura asignatura = asignaturaDao.buscarPorId(id);
            if (asignatura == null) {
                System.out.println("\nNo se encontró un asignatura con el ID: " + id);
                return;
            }

            System.out.println("\nEstá a punto de eliminar el siguiente asignatura:");
            System.out.println(asignatura.toString());
            System.out.print("¿Está seguro? (S/N): ");
            String confirmacion = keyboard.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                asignaturaDao.eliminar(id);
                System.out.println("\nAsignatura eliminado exitosamente!");
            } else {
                System.out.println("\nOperación cancelada.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar asignatura: " + e.getMessage());
        }
    }

}
