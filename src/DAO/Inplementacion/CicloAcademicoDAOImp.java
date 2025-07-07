package DAO.Inplementacion;

/**
 *
 * @author lm-carlos
 */
import ConexionBD.ConexionBD;
import DAO.Interface.CicloAcademicoDAO;
import Dominio.CicloAcademico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CicloAcademicoDAOImp implements CicloAcademicoDAO {

    @Override
    public void insertar(CicloAcademico ciclo) throws SQLException {
        String sql = "INSERT INTO cicloacademico (id, año, fechainicio, fechafin, estado, cantidadsemanas) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ciclo.getId());
            pstmt.setInt(2, ciclo.getAnio());
            pstmt.setDate(3, Date.valueOf(ciclo.getFechaInicio()));
            pstmt.setDate(4, Date.valueOf(ciclo.getFechaFin()));
            pstmt.setString(5, ciclo.getEstado());
            pstmt.setInt(6, ciclo.getCantidadSemanas());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(CicloAcademico ciclo) throws SQLException {
        String sql = "UPDATE cicloacademico SET año = ?, fechainicio = ?, fechafin = ?, "
                + "estado = ?, cantidadsemanas = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ciclo.getAnio());
            pstmt.setDate(2, Date.valueOf(ciclo.getFechaInicio()));
            pstmt.setDate(3, Date.valueOf(ciclo.getFechaFin()));
            pstmt.setString(4, ciclo.getEstado());
            pstmt.setInt(5, ciclo.getCantidadSemanas());
            pstmt.setString(6, ciclo.getId());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM cicloacademico WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public CicloAcademico buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM cicloacademico WHERE id = ?";
        CicloAcademico ciclo = null;

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ciclo = mapearCicloAcademico(rs);
                }
            }
        }
        return ciclo;
    }

    @Override
    public List<CicloAcademico> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM cicloacademico ORDER BY año DESC, fechainicio DESC";
        List<CicloAcademico> ciclos = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ciclos.add(mapearCicloAcademico(rs));
            }
        }
        return ciclos;
    }

    private CicloAcademico mapearCicloAcademico(ResultSet rs) throws SQLException {
        CicloAcademico ciclo = new CicloAcademico();
        ciclo.setId(rs.getString("id"));
        ciclo.setAnio(rs.getInt("año"));

        // Manejo seguro de fechas
        Date fechaInicio = rs.getDate("fechainicio");
        ciclo.setFechaInicio(fechaInicio != null ? fechaInicio.toLocalDate() : null);

        Date fechaFin = rs.getDate("fechafin");
        ciclo.setFechaFin(fechaFin != null ? fechaFin.toLocalDate() : null);

        ciclo.setEstado(rs.getString("estado"));
        ciclo.setCantidadSemanas(rs.getInt("cantidadsemanas"));
        return ciclo;
    }
}
