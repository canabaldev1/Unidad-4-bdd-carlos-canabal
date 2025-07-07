/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class GrupoRegular extends Grupo {

    private ProfesorRegular profesorEncargado;

    // CONSTRUCTORES
    public GrupoRegular() {
        super();
    }

    public GrupoRegular(ProfesorRegular profesorEncargado, String id, String nombre, Curso curso, Aula aula, CicloAcademico cicloAcademico) {
        super(id, nombre, curso, aula, cicloAcademico);
        this.profesorEncargado = profesorEncargado;
    }

    public ProfesorRegular getProfesorEncargado() {
        return profesorEncargado;
    }

    public void setProfesorEncargado(ProfesorRegular profesorEncargado) {
        this.profesorEncargado = profesorEncargado;
    }

    @Override
    public String toString() {
        return ("Grupo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Curso:                        " + (curso != null ? curso.getNombre() : "Sin curso") + "\n"
                + "Aula:                         " + (aula != null ? aula.getNombre() : "Sin aula") + "\n"
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin ciclo") + "\n"
                + "Profesor Encargado:           " + (profesorEncargado != null ? profesorEncargado.getNombres() + " " + profesorEncargado.getApellidos() : "Sin profesor encargado") + "\n");
    }
}
