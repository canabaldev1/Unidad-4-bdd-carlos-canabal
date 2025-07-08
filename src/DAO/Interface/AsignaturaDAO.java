/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interface;

import Dominio.Asignatura;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public interface AsignaturaDAO {

    void insertar(Asignatura asignatura) throws SQLException;

    void actualizar(Asignatura asignatura) throws SQLException;

    void eliminar(String id) throws SQLException;

    Asignatura buscarPorId(String id) throws SQLException;

    List<Asignatura> buscarTodos() throws SQLException;

}
