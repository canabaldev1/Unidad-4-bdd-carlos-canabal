package DAO.Interface;

/**
 *
 * @author lm-carlos
 */
import Dominio.CicloAcademico;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface CicloAcademicoDAO {

    void insertar(CicloAcademico ciclo) throws SQLException;

    void actualizar(CicloAcademico ciclo) throws SQLException;

    void eliminar(String id) throws SQLException;

    CicloAcademico buscarPorId(String id) throws SQLException;

    List<CicloAcademico> buscarTodos() throws SQLException;
}
