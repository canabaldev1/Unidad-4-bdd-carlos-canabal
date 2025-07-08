/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interface;

import Dominio.DesempenoAlumno;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public interface DesempenoDAO {

    void insertar(DesempenoAlumno ciclo) throws SQLException;

    void actualizar(DesempenoAlumno ciclo) throws SQLException;

    void eliminar(String id) throws SQLException;

    DesempenoAlumno buscarPorId(String id) throws SQLException;

    List<DesempenoAlumno> buscarTodos() throws SQLException;

    List<DesempenoAlumno> buscarEspecifico(String alumno_id, String clase_id) throws SQLException;

}
