/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interface;

import Dominio.Clase;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public interface ClaseDAO {

    void insertar(Clase ciclo) throws SQLException;

    void actualizar(Clase ciclo) throws SQLException;

    void eliminar(String id) throws SQLException;

    Clase buscarPorId(String id) throws SQLException;

    List<Clase> buscarTodos() throws SQLException;
}
