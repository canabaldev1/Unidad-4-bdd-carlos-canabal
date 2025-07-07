package DAO.Inplementacion;

/**
 *
 * @author lm-carlos
 */
import ConexionBD.ConexionBD;
import DAO.Interface.AlumnoDAO;
import Dominio.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImp implements AlumnoDAO {

    private static final String TABLA_USUARIO = "usuario";
    private static final String TABLA_ALUMNO = "alumno";

    @Override
    public void insertar(Alumno alumno) throws SQLException {
        // Primero insertar en Usuario
        String sqlUsuario = "INSERT INTO usuario (id, nombres, apellidos, fechanacimiento, "
                + "contrasena, direccion, email, telefono) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Luego insertar en Alumno
        String sqlAlumno = "INSERT INTO alumno (userid, nombreacudiente, apellidoacudiente, parentesco) "
                + "VALUES (?, ?, ?, ?)";

        Connection conn = null;
        try {
            conn = ConexionBD.getConnection();
            conn.setAutoCommit(false); // Iniciar transacción

            // Insertar en Usuario
            try (PreparedStatement pstmtUsuario = conn.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, alumno.getId());
                pstmtUsuario.setString(2, alumno.getNombres());
                pstmtUsuario.setString(3, alumno.getApellidos());
                pstmtUsuario.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                pstmtUsuario.setString(5, alumno.getContrasena());
                pstmtUsuario.setString(6, alumno.getDireccion());
                pstmtUsuario.setString(7, alumno.getEmail());
                pstmtUsuario.setString(8, alumno.getTelefono());
                pstmtUsuario.executeUpdate();
            }

            // Insertar en Alumno
            try (PreparedStatement pstmtAlumno = conn.prepareStatement(sqlAlumno)) {
                pstmtAlumno.setString(1, alumno.getId());
                pstmtAlumno.setString(2, alumno.getNombreAcudiente());
                pstmtAlumno.setString(3, alumno.getApellidoAcudiente());
                pstmtAlumno.setString(4, alumno.getParentesco());
                pstmtAlumno.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                ConexionBD.cerrar(conn);
            }
        }
    }

    @Override
    public void actualizar(Alumno alumno) throws SQLException {
        // Consulta para actualizar la tabla Usuario (datos comunes)
        String sqlUsuario = "UPDATE usuario SET nombres = ?, apellidos = ?, fechanacimiento = ?, "
                + "contrasena = ?, direccion = ?, email = ?, telefono = ? "
                + "WHERE id = ?";

        // Consulta para actualizar la tabla Alumno (datos específicos)
        String sqlAlumno = "UPDATE alumno SET nombreacudiente = ?, apellidoacudiente = ?, parentesco = ? "
                + "WHERE userid = ?";

        Connection conn = null;
        try {
            conn = ConexionBD.getConnection();
            conn.setAutoCommit(false); // Iniciar transacción

            // 1. Actualizar datos en tabla Usuario
            try (PreparedStatement pstmtUsuario = conn.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, alumno.getNombres());
                pstmtUsuario.setString(2, alumno.getApellidos());
                pstmtUsuario.setDate(3, Date.valueOf(alumno.getFechaNacimiento()));
                pstmtUsuario.setString(4, alumno.getContrasena());
                pstmtUsuario.setString(5, alumno.getDireccion());
                pstmtUsuario.setString(6, alumno.getEmail());
                pstmtUsuario.setString(7, alumno.getTelefono());
                pstmtUsuario.setString(8, alumno.getId());

                pstmtUsuario.executeUpdate();
            }

            // 2. Actualizar datos en tabla Alumno
            try (PreparedStatement pstmtAlumno = conn.prepareStatement(sqlAlumno)) {
                pstmtAlumno.setString(1, alumno.getNombreAcudiente());
                pstmtAlumno.setString(2, alumno.getApellidoAcudiente());
                pstmtAlumno.setString(3, alumno.getParentesco());
                pstmtAlumno.setString(4, alumno.getId());

                pstmtAlumno.executeUpdate();
            }

            conn.commit(); // Confirmar ambas actualizaciones
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // Revertir en caso de error
            }
            throw new SQLException("Error al actualizar alumno: " + e.getMessage(), e);
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                ConexionBD.cerrar(conn);
            }
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLA_ALUMNO + " WHERE userid = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Alumno buscarPorId(String id) throws SQLException {
        String sql = "SELECT u.*, a.nombreacudiente, a.apellidoacudiente, a.parentesco "
                + "FROM " + TABLA_USUARIO + " u "
                + "JOIN " + TABLA_ALUMNO + " a ON u.id = a.userid "
                + "WHERE u.id = ?";

        Alumno alumno = null;

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    alumno = mapearAlumno(rs);
                }
            }
        }
        return alumno;
    }

    @Override
    public List<Alumno> buscarTodos() throws SQLException {

        String sql = "SELECT u.*, a.nombreacudiente, a.apellidoacudiente, a.parentesco "
                + "FROM " + TABLA_USUARIO + " u "
                + "JOIN " + TABLA_ALUMNO + " a ON u.id = a.userid "
                + "ORDER BY u.apellidos, u.nombres";

        List<Alumno> alumnos = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                alumnos.add(mapearAlumno(rs));
            }
        }
        return alumnos;
    }

    private Alumno mapearAlumno(ResultSet rs) throws SQLException {
        Alumno alumno = new Alumno();

        // Mapear atributos de Usuario
        alumno.setId(rs.getString("id"));
        alumno.setNombres(rs.getString("nombres"));
        alumno.setApellidos(rs.getString("apellidos"));

        Date fechaNacimiento = rs.getDate("fechanacimiento");
        alumno.setFechaNacimiento(fechaNacimiento != null ? fechaNacimiento.toLocalDate() : null);

        alumno.setContrasena(rs.getString("contrasena"));
        alumno.setDireccion(rs.getString("direccion"));
        alumno.setEmail(rs.getString("email"));
        alumno.setTelefono(rs.getString("telefono"));

        // Mapear atributos específicos de Alumno
        alumno.setNombreAcudiente(rs.getString("nombreacudiente"));
        alumno.setApellidoAcudiente(rs.getString("apellidoacudiente"));
        alumno.setParentesco(rs.getString("parentesco"));

        return alumno;
    }
}
