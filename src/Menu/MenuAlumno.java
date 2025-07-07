package Menu;

import DAO.Inplementacion.AlumnoDAOImp;
import Dominio.Alumno;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lm-carlos
 */
public class MenuAlumno {

    public static void mostrarMenu() {

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GESTIÓN DE ALUMNOS ===");
            System.out.println("1. Consultar todos los alumnos");
            System.out.println("2. Consultar alumno por ID");
            System.out.println("3. Crear nuevo alumno");
            System.out.println("4. Editar alumno existente");
            System.out.println("5. Eliminar alumno");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            String accion = keyboard.nextLine();

            switch (accion) {
                case "1":
                    consultarTodosAlumnos();
                    break;
                case "2":
                    consultarAlumnoPorId();
                    break;
                case "3":
                    crearAlumno();
                    break;
                case "4":
                    editarAlumno();
                    break;
                case "5":
                    eliminarAlumno();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void consultarTodosAlumnos() {

        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();

        try {
            List<Alumno> alumnos = alumnoDao.buscarTodos();
            if (alumnos.isEmpty()) {
                System.out.println("\nNo hay alumnos registrados.");
            } else {
                System.out.println("\n=== LISTADO DE ALUMNOS ===");
                alumnos.forEach(alumno -> {
                    System.out.println(alumno.toString());
                    System.out.println("-----------------------------------");
                });
            }
        } catch (Exception e) {
            System.err.println("Error al consultar alumnos: " + e.getMessage());
        }
    }

    private static void consultarAlumnoPorId() {

        Scanner keyboard = new Scanner(System.in);
        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();

        System.out.print("\nIngrese el ID del alumno a consultar: ");
        String id = keyboard.nextLine();

        try {
            Alumno alumno = alumnoDao.buscarPorId(id);
            if (alumno != null) {
                System.out.println("\n=== DETALLE DEL ALUMNO ===");
                System.out.println(alumno.toString());
            } else {
                System.out.println("\nNo se encontró un alumno con el ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar alumno: " + e.getMessage());
        }
    }

    private static void crearAlumno() {

        Scanner keyboard = new Scanner(System.in);
        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();

        System.out.println("\n=== CREAR NUEVO ALUMNO===");

        Alumno nuevoAlumno = new Alumno();

        System.out.print("ID del alumno: ");
        nuevoAlumno.setId(keyboard.nextLine());

        System.out.print("Nombres del alumno: ");
        nuevoAlumno.setNombres(keyboard.nextLine());

        System.out.print("Apellidos del alumno: ");
        nuevoAlumno.setApellidos(keyboard.nextLine());

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        nuevoAlumno.setFechaNacimiento(LocalDate.parse(keyboard.nextLine()));

        System.out.print("Contraseña del alumno: ");
        nuevoAlumno.setContrasena(keyboard.nextLine());

        System.out.print("Dirección del alumno: ");
        nuevoAlumno.setDireccion(keyboard.nextLine());

        System.out.print("Email del alumno: ");
        nuevoAlumno.setEmail(keyboard.nextLine());

        System.out.print("Teléfono del alumno: ");
        nuevoAlumno.setTelefono(keyboard.nextLine());

        System.out.print("Nombre del acudiente: ");
        nuevoAlumno.setNombreAcudiente(keyboard.nextLine());

        System.out.print("Apellido del acudiente: ");
        nuevoAlumno.setApellidoAcudiente(keyboard.nextLine());

        System.out.print("Parentesco con el alumno: ");
        nuevoAlumno.setParentesco(keyboard.nextLine());

        try {
            alumnoDao.insertar(nuevoAlumno);
            System.out.println("\nAlumno creado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al crear alumno: " + e.getMessage());
        }
    }

    private static void editarAlumno() {

        Scanner keyboard = new Scanner(System.in);
        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();

        System.out.print("\nIngrese el ID del alumno a editar: ");
        String id = keyboard.nextLine();

        try {
            Alumno alumno = alumnoDao.buscarPorId(id);
            if (alumno == null) {
                System.out.println("\nNo se encontró un alumno con el ID: " + id);
                return;
            }

            System.out.println("\n=== EDITANDO ALUMNO ===");
            System.out.println(alumno.toString());

            String input;

            System.out.print("Nuevos nombres (actual: " + alumno.getNombres() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setNombres(input);
            }

            System.out.print("Nuevos apellidos (actual: " + alumno.getApellidos() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setApellidos(input);
            }

            System.out.print("Nueva fecha de nacimiento (actual: " + alumno.getFechaNacimiento() + ") [YYYY-MM-DD]: ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setFechaNacimiento(LocalDate.parse(input));
            }

            System.out.print("Nueva contraseña (actual: " + alumno.getContrasena() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setContrasena(input);
            }

            System.out.print("Nueva dirección (actual: " + alumno.getDireccion() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setDireccion(input);
            }

            System.out.print("Nuevo email (actual: " + alumno.getEmail() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setEmail(input);
            }

            System.out.print("Nuevo teléfono (actual: " + alumno.getTelefono() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setTelefono(input);
            }

            System.out.print("Nuevo nombre del acudiente (actual: " + alumno.getNombreAcudiente() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setNombreAcudiente(input);
            }

            System.out.print("Nuevo apellido del acudiente (actual: " + alumno.getApellidoAcudiente() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setApellidoAcudiente(input);
            }

            System.out.print("Nuevo parentesco (actual: " + alumno.getParentesco() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                alumno.setParentesco(input);
            }
            alumnoDao.actualizar(alumno);
            System.out.println("\nAlumno actualizado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al editar alumno: " + e.getMessage());
        }
    }

    private static void eliminarAlumno() {

        Scanner keyboard = new Scanner(System.in);
        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();

        System.out.print("\nIngrese el ID del alumno a eliminar: ");
        String id = keyboard.nextLine();

        try {
            Alumno alumno = alumnoDao.buscarPorId(id);
            if (alumno == null) {
                System.out.println("\nNo se encontró un alumno con el ID: " + id);
                return;
            }

            System.out.println("\nEstá a punto de eliminar el siguiente alumno:");
            System.out.println(alumno.toString());
            System.out.print("¿Está seguro? (S/N): ");
            String confirmacion = keyboard.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                alumnoDao.eliminar(id);
                System.out.println("\nAlumno eliminado exitosamente!");
            } else {
                System.out.println("\nOperación cancelada.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar alumno: " + e.getMessage());
        }
    }
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
