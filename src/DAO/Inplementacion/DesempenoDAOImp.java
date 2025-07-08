package DAO.Inplementacion;

import ConexionBD.ConexionBD;
import DAO.Interface.DesempenoDAO;
import Dominio.Alumno;
import Dominio.Clase;
import Dominio.DesempenoAlumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class DesempenoDAOImp implements DesempenoDAO {

    @Override
    public void insertar(DesempenoAlumno desempeno) throws SQLException {
        String sql = "INSERT INTO desempeñoalumno (id, alumno_id, clase_id, observaciones, "
                + "notaprimertrimestre, notasegundotrimestre, notatercertrimestre, "
                + "notahabilitacion, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, desempeno.getId());
            pstmt.setString(2, desempeno.getAlumno().getId());
            pstmt.setString(3, desempeno.getClase().getId());

            // Manejo de observaciones que podría ser null
            if (desempeno.getObservaciones() != null) {
                pstmt.setString(4, desempeno.getObservaciones());
            } else {
                pstmt.setNull(4, Types.VARCHAR);
            }

            pstmt.setDouble(5, desempeno.getNotaPrimerTrimestre());
            pstmt.setDouble(6, desempeno.getNotaSegundoTrimestre());
            pstmt.setDouble(7, desempeno.getNotaTercerTrimestre());
            pstmt.setDouble(8, desempeno.getNotaHabilitacion());
            pstmt.setString(9, desempeno.getEstado());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(DesempenoAlumno desempeno) throws SQLException {
        String sql = "UPDATE desempeñoalumno SET alumno_id = ?, clase_id = ?, observaciones = ?, "
                + "notaprimertrimestre = ?, notasegundotrimestre = ?, notatercertrimestre = ?, "
                + "notahabilitacion = ?, estado = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Las validaciones ya están en los setters de la clase
            pstmt.setString(1, desempeno.getAlumno().getId());
            pstmt.setString(2, desempeno.getClase().getId());

            // Manejo de observaciones que podría ser null
            if (desempeno.getObservaciones() != null) {
                pstmt.setString(3, desempeno.getObservaciones());
            } else {
                pstmt.setNull(3, Types.VARCHAR);
            }

            pstmt.setDouble(4, desempeno.getNotaPrimerTrimestre());
            pstmt.setDouble(5, desempeno.getNotaSegundoTrimestre());
            pstmt.setDouble(6, desempeno.getNotaTercerTrimestre());
            pstmt.setDouble(7, desempeno.getNotaHabilitacion());
            pstmt.setString(8, desempeno.getEstado());
            pstmt.setString(9, desempeno.getId());

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas == 0) {
                throw new SQLException("No se encontró el desempeño con ID: " + desempeno.getId());
            }
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM desempeñoalumno WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas == 0) {
                throw new SQLException("No se encontró el desempeño con ID: " + id + " para eliminar");
            }
        }
    }

    @Override
    public DesempenoAlumno buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM desempeñoalumno WHERE id = ?";
        DesempenoAlumno desempeno = null;

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    desempeno = mapearDesempenoAlumno(rs);
                }
            }
        }
        return desempeno;
    }

    @Override
    public List<DesempenoAlumno> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM desempeñoalumno";
        List<DesempenoAlumno> desempenos = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                desempenos.add(mapearDesempenoAlumno(rs));
            }
        }
        return desempenos;
    }

    @Override
    public List<DesempenoAlumno> buscarEspecifico(String alumno_id, String clase_id) throws SQLException {

        List<DesempenoAlumno> desempenos = new ArrayList<>();

        // Construir la consulta SQL dinámicamente
        StringBuilder sql = new StringBuilder("SELECT * FROM desempeñoalumno WHERE 1=1");

        // Lista para almacenar los parámetros
        List<String> parametros = new ArrayList<>();

        if (!alumno_id.isEmpty()) {
            sql.append(" AND alumno_id = ?");
            parametros.add(alumno_id);
        }

        if (!clase_id.isEmpty()) {
            sql.append(" AND clase_id = ?");
            parametros.add(clase_id);
        }

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            // Asignar los parámetros al PreparedStatement
            for (int i = 0; i < parametros.size(); i++) {
                stmt.setString(i + 1, parametros.get(i));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    desempenos.add(mapearDesempenoAlumno(rs));
                }
            }
        }
        return desempenos;
    }

    private DesempenoAlumno mapearDesempenoAlumno(ResultSet rs) throws SQLException {

        AlumnoDAOImp alumnoDao = new AlumnoDAOImp();
        ClaseDAOImp claseDao = new ClaseDAOImp();

        DesempenoAlumno desempeno = new DesempenoAlumno();

        desempeno.setId(rs.getString("id"));

        Alumno alumno = alumnoDao.buscarPorId(rs.getString("alumno_id"));
        desempeno.setAlumno(alumno);

        Clase clase = claseDao.buscarPorId(rs.getString("clase_id"));
        desempeno.setClase(clase);

        desempeno.setObservaciones(rs.getString("observaciones"));
        desempeno.setNotaPrimerTrimestre(rs.getDouble("notaprimertrimestre"));
        desempeno.setNotaSegundoTrimestre(rs.getDouble("notasegundotrimestre"));
        desempeno.setNotaTercerTrimestre(rs.getDouble("notatercertrimestre"));
        desempeno.setNotaHabilitacion(rs.getDouble("notahabilitacion"));
        desempeno.setEstado(rs.getString("estado"));

        return desempeno;
    }

}
