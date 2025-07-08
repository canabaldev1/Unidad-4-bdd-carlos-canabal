package DAO.Inplementacion;

import ConexionBD.ConexionBD;
import DAO.Interface.AsignaturaDAO;
import Dominio.Asignatura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AsignaturaDAOImp implements AsignaturaDAO {

    private static final String TABLA = "asignatura";

    @Override
    public void insertar(Asignatura asignatura) throws SQLException {
        String sql = "INSERT INTO " + TABLA + " (id, nombre, descripcion, prioridad) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, asignatura.getId());
            pstmt.setString(2, asignatura.getNombre());
            pstmt.setString(3, asignatura.getDescripcion());
            pstmt.setString(4, asignatura.getPrioridad());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Asignatura asignatura) throws SQLException {
        String sql = "UPDATE " + TABLA + " SET nombre = ?, descripcion = ?, prioridad = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, asignatura.getNombre());
            pstmt.setString(2, asignatura.getDescripcion());
            pstmt.setString(3, asignatura.getPrioridad());
            pstmt.setString(4, asignatura.getId());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLA + " WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Asignatura buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLA + " WHERE id = ?";
        Asignatura asignatura = null;

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    asignatura = mapearAsignatura(rs);
                }
            }
        }
        return asignatura;
    }

    @Override
    public List<Asignatura> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM " + TABLA + " ORDER BY nombre";
        List<Asignatura> asignaturas = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                asignaturas.add(mapearAsignatura(rs));
            }
        }
        return asignaturas;
    }

    private Asignatura mapearAsignatura(ResultSet rs) throws SQLException {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(rs.getString("id"));
        asignatura.setNombre(rs.getString("nombre"));
        asignatura.setDescripcion(rs.getString("descripcion"));
        asignatura.setPrioridad(rs.getString("prioridad"));
        return asignatura;
    }

}
