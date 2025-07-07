package DAO.Interface;

/**
 *
 * @author lm-carlos
 */
import Dominio.Alumno;
import java.sql.SQLException;
import java.util.List;

public interface AlumnoDAO {

    void insertar(Alumno alumno) throws SQLException;

    void actualizar(Alumno alumno) throws SQLException;

    void eliminar(String id) throws SQLException;

    Alumno buscarPorId(String id) throws SQLException;

    List<Alumno> buscarTodos() throws SQLException;

}
