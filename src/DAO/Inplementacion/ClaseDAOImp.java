package DAO.Inplementacion;

import ConexionBD.ConexionBD;
import DAO.Interface.ClaseDAO;
import Dominio.Asignatura;
import Dominio.CicloAcademico;
import Dominio.Clase;
import Dominio.GrupoRegular;
import Dominio.ProfesorRegular;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ClaseDAOImp implements ClaseDAO {

    @Override
    public void insertar(Clase clase) throws SQLException {
        String sql = "INSERT INTO clase (id, profesorregular_id, gruporegular_id, asignatura_id, cicloacademico_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, clase.getId());
            pstmt.setString(2, clase.getProfesor().getId());
            pstmt.setString(3, clase.getGrupo().getId());
            pstmt.setString(4, clase.getAsignatura().getId());
            pstmt.setString(5, clase.getCicloAcademico().getId());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Clase clase) throws SQLException {

        String sql = "UPDATE clase SET profesorregular_id = ? , gruporegular_id = ? "
                + ", asignatura_id = ? , cicloacademico_id = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, clase.getProfesor().getId());
            pstmt.setString(2, clase.getGrupo().getId());
            pstmt.setString(3, clase.getAsignatura().getId());
            pstmt.setString(4, clase.getCicloAcademico().getId());
            pstmt.setString(5, clase.getId());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM clase WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Clase buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM clase WHERE id = ?";
        Clase clase = null;

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    clase = mapearClase(rs);
                }
            }
        }
        return clase;
    }

    @Override
    public List<Clase> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM clase";
        List<Clase> clases = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clases.add(mapearClase(rs));
            }
        }
        return clases;
    }

    private Clase mapearClase(ResultSet rs) throws SQLException {

        AsignaturaDAOImp asignaturaDao = new AsignaturaDAOImp();
        CicloAcademicoDAOImp cicloDao = new CicloAcademicoDAOImp();

        Clase clase = new Clase();

        clase.setId(rs.getString("id"));

        clase.setProfesor(new ProfesorRegular());

        clase.setGrupo(new GrupoRegular());

        String asignaturaId = rs.getString("asignatura_id");
        if (asignaturaId != null && !rs.wasNull()) {
            Asignatura asignatura = asignaturaDao.buscarPorId(asignaturaId);
            clase.setAsignatura(asignatura);
        }

        String cicloId = rs.getString("cicloacademico_id");
        if (cicloId != null && !rs.wasNull()) {
            CicloAcademico ciclo = cicloDao.buscarPorId(cicloId);
            clase.setCicloAcademico(ciclo);
        }

        return clase;
    }

}
