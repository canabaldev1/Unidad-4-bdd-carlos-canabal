package Menu;

import DAO.Inplementacion.AlumnoDAOImp;
import DAO.Inplementacion.ClaseDAOImp;
import DAO.Inplementacion.DesempenoDAOImp;
import Dominio.Alumno;
import Dominio.Clase;
import Dominio.DesempenoAlumno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lm-carlos
 */
public class MenuDesempeno {

    public static void mostrarMenu() {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GESTIÓN DE DESEMPEÑO DE ALUMNOS ===");
            System.out.println("1. Consultar todos los registros de desempeño");
            System.out.println("2. Consultar desempeño por ID");
            System.out.println("3. Buscar desempeño específico (por alumno y/o clase)");
            System.out.println("4. Crear nuevo registro de desempeño");
            System.out.println("5. Editar registro de desempeño");
            System.out.println("6. Eliminar registro de desempeño");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            String accion = keyboard.nextLine();

            switch (accion) {
                case "1":
                    consultarTodosDesempenos();
                    break;
                case "2":
                    consultarDesempenoPorId();
                    break;
                case "3":
                    buscarDesempenoEspecifico();
                    break;
                case "4":
                    crearDesempeno();
                    break;
                case "5":
                    editarDesempeno();
                    break;
                case "6":
                    eliminarDesempeno();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void consultarTodosDesempenos() {
        DesempenoDAOImp desempenoDao = new DesempenoDAOImp();

        try {
            List<DesempenoAlumno> desempenos = desempenoDao.buscarTodos();
            if (desempenos.isEmpty()) {
                System.out.println("\nNo hay registros de desempeño.");
            } else {
                System.out.println("\n=== LISTADO DE DESEMPEÑOS ===");
                desempenos.forEach(desempeno -> {
                    System.out.println(desempeno.toString());
                    System.out.println("-----------------------------------");
                });
            }
        } catch (Exception e) {
            System.err.println("Error al consultar desempeños: " + e.getMessage());
        }
    }

    private static void consultarDesempenoPorId() {
        Scanner keyboard = new Scanner(System.in);
        DesempenoDAOImp desempenoDao = new DesempenoDAOImp();

        System.out.print("\nIngrese el ID del desempeño a consultar: ");
        String id = keyboard.nextLine();

        try {
            DesempenoAlumno desempeno = desempenoDao.buscarPorId(id);
            if (desempeno != null) {
                System.out.println("\n=== DETALLE DEL DESEMPEÑO ===");
                System.out.println(desempeno.toString());
            } else {
                System.out.println("\nNo se encontró un desempeño con el ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar desempeño: " + e.getMessage());
        }
    }

    private static void buscarDesempenoEspecifico() {
        Scanner keyboard = new Scanner(System.in);
        DesempenoDAOImp desempenoDao = new DesempenoDAOImp();

        System.out.println("\n=== BUSCAR DESEMPEÑO ESPECÍFICO ===");
        System.out.println("(Deje en blanco los campos que no desee filtrar)");
        
        System.out.print("ID del alumno: ");
        String alumnoId = keyboard.nextLine();
        
        System.out.print("ID de la clase: ");
        String claseId = keyboard.nextLine();

        try {
            List<DesempenoAlumno> desempenos = desempenoDao.buscarEspecifico(alumnoId, claseId);
            if (desempenos.isEmpty()) {
                System.out.println("\nNo se encontraron registros con los criterios especificados.");
            } else {
                System.out.println("\n=== RESULTADOS DE LA BÚSQUEDA ===");
                desempenos.forEach(desempeno -> {
                    System.out.println(desempeno.toString());
                    System.out.println("-----------------------------------");
                });
            }
        } catch (Exception e) {
            System.err.println("Error al buscar desempeños: " + e.getMessage());
        }
    }

    private static void crearDesempeno() {
        Scanner keyboard = new Scanner(System.in);
        DesempenoDAOImp desempenoDao = new DesempenoDAOImp();
        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();
        ClaseDAOImp claseDao = new ClaseDAOImp();

        System.out.println("\n=== CREAR NUEVO REGISTRO DE DESEMPEÑO ===");

        DesempenoAlumno nuevoDesempeno = new DesempenoAlumno();

        System.out.print("ID del registro: ");
        nuevoDesempeno.setId(keyboard.nextLine());

        // Alumno
        System.out.print("ID del alumno: ");
        String alumnoId = keyboard.nextLine();
        try {
            Alumno alumno = alumnoDao.buscarPorId(alumnoId);
            if (alumno != null) {
                nuevoDesempeno.setAlumno(alumno);
            } else {
                System.out.println("\nNo se encontró un alumno con el ID: " + alumnoId);
                return;
            }
        } catch (Exception e) {
            System.err.println("Error al buscar alumno: " + e.getMessage());
            return;
        }

        // Clase
        System.out.print("ID de la clase: ");
        String claseId = keyboard.nextLine();
        try {
            Clase clase = claseDao.buscarPorId(claseId);
            if (clase != null) {
                nuevoDesempeno.setClase(clase);
            } else {
                System.out.println("\nNo se encontró una clase con el ID: " + claseId);
                return;
            }
        } catch (Exception e) {
            System.err.println("Error al buscar clase: " + e.getMessage());
            return;
        }

        System.out.print("Observaciones (opcional): ");
        String observaciones = keyboard.nextLine();
        if (!observaciones.isEmpty()) {
            nuevoDesempeno.setObservaciones(observaciones);
        }

        System.out.print("Nota primer trimestre: ");
        nuevoDesempeno.setNotaPrimerTrimestre(Double.parseDouble(keyboard.nextLine()));

        System.out.print("Nota segundo trimestre: ");
        nuevoDesempeno.setNotaSegundoTrimestre(Double.parseDouble(keyboard.nextLine()));

        System.out.print("Nota tercer trimestre: ");
        nuevoDesempeno.setNotaTercerTrimestre(Double.parseDouble(keyboard.nextLine()));

        System.out.print("Nota habilitación: ");
        nuevoDesempeno.setNotaHabilitacion(Double.parseDouble(keyboard.nextLine()));

        System.out.print("Estado: ");
        nuevoDesempeno.setEstado(keyboard.nextLine());

        try {
            desempenoDao.insertar(nuevoDesempeno);
            System.out.println("\nRegistro de desempeño creado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al crear registro de desempeño: " + e.getMessage());
        }
    }

    private static void editarDesempeno() {
        Scanner keyboard = new Scanner(System.in);
        DesempenoDAOImp desempenoDao = new DesempenoDAOImp();
        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();
        ClaseDAOImp claseDao = new ClaseDAOImp();

        System.out.print("\nIngrese el ID del desempeño a editar: ");
        String id = keyboard.nextLine();

        try {
            DesempenoAlumno desempeno = desempenoDao.buscarPorId(id);
            if (desempeno == null) {
                System.out.println("\nNo se encontró un desempeño con el ID: " + id);
                return;
            }

            System.out.println("\n=== EDITANDO DESEMPEÑO ===");
            System.out.println(desempeno.toString());

            // Editar alumno
            System.out.print("Nuevo ID del alumno (actual: " + desempeno.getAlumno().getId() + "): ");
            String input = keyboard.nextLine();
            if (!input.isEmpty()) {
                try {
                    Alumno alumno = alumnoDao.buscarPorId(input);
                    if (alumno != null) {
                        desempeno.setAlumno(alumno);
                    } else {
                        System.out.println("No se encontró el alumno con ID: " + input);
                    }
                } catch (Exception e) {
                    System.err.println("Error al buscar alumno: " + e.getMessage());
                }
            }

            // Editar clase
            System.out.print("Nuevo ID de la clase (actual: " + desempeno.getClase().getId() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                try {
                    Clase clase = claseDao.buscarPorId(input);
                    if (clase != null) {
                        desempeno.setClase(clase);
                    } else {
                        System.out.println("No se encontró la clase con ID: " + input);
                    }
                } catch (Exception e) {
                    System.err.println("Error al buscar clase: " + e.getMessage());
                }
            }

            // Editar observaciones
            System.out.print("Nuevas observaciones (actual: " + 
                    (desempeno.getObservaciones() != null ? desempeno.getObservaciones() : "Ninguna") + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                desempeno.setObservaciones(input);
            }

            // Editar notas
            System.out.print("Nueva nota primer trimestre (actual: " + desempeno.getNotaPrimerTrimestre() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                desempeno.setNotaPrimerTrimestre(Double.parseDouble(input));
            }

            System.out.print("Nueva nota segundo trimestre (actual: " + desempeno.getNotaSegundoTrimestre() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                desempeno.setNotaSegundoTrimestre(Double.parseDouble(input));
            }

            System.out.print("Nueva nota tercer trimestre (actual: " + desempeno.getNotaTercerTrimestre() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                desempeno.setNotaTercerTrimestre(Double.parseDouble(input));
            }

            System.out.print("Nueva nota habilitación (actual: " + desempeno.getNotaHabilitacion() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                desempeno.setNotaHabilitacion(Double.parseDouble(input));
            }

            System.out.print("Nuevo estado (actual: " + desempeno.getEstado() + "): ");
            input = keyboard.nextLine();
            if (!input.isEmpty()) {
                desempeno.setEstado(input);
            }

            desempenoDao.actualizar(desempeno);
            System.out.println("\nDesempeño actualizado exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al editar desempeño: " + e.getMessage());
        }
    }

    private static void eliminarDesempeno() {
        Scanner keyboard = new Scanner(System.in);
        DesempenoDAOImp desempenoDao = new DesempenoDAOImp();

        System.out.print("\nIngrese el ID del desempeño a eliminar: ");
        String id = keyboard.nextLine();

        try {
            DesempenoAlumno desempeno = desempenoDao.buscarPorId(id);
            if (desempeno == null) {
                System.out.println("\nNo se encontró un desempeño con el ID: " + id);
                return;
            }

            System.out.println("\nEstá a punto de eliminar el siguiente registro de desempeño:");
            System.out.println(desempeno.toString());
            System.out.print("¿Está seguro? (S/N): ");
            String confirmacion = keyboard.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                desempenoDao.eliminar(id);
                System.out.println("\nRegistro de desempeño eliminado exitosamente!");
            } else {
                System.out.println("\nOperación cancelada.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar desempeño: " + e.getMessage());
        }
    }
}