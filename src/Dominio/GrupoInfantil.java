/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author lm-carlos
 */
public class GrupoInfantil extends Grupo {

    private ProfesorInfantil profesorEncargado;
    private ProfesorInfantil profesorAsistente;

    // CONSTRUCTORES
    public GrupoInfantil() {
        super();
    }

    public GrupoInfantil(ProfesorInfantil profesorEncargado, ProfesorInfantil profesorAsistente, String id, String nombre, Curso curso, Aula aula, CicloAcademico cicloAcademico) {
        super(id, nombre, curso, aula, cicloAcademico);
        this.profesorEncargado = profesorEncargado;
        this.profesorAsistente = profesorAsistente;
    }

    public ProfesorInfantil getProfesorEncargado() {
        return profesorEncargado;
    }

    public void setProfesorEncargado(ProfesorInfantil profesorEncargado) {
        this.profesorEncargado = profesorEncargado;
    }

    public ProfesorInfantil getProfesorAsistente() {
        return profesorAsistente;
    }

    public void setProfesorAsistente(ProfesorInfantil profesorAsistente) {
        this.profesorAsistente = profesorAsistente;
    }

    @Override
    public String toString() {
        return ("Grupo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Curso:                        " + (curso != null ? curso.getNombre() : "Sin curso") + "\n"
                + "Aula:                         " + (aula != null ? aula.getNombre() : "Sin aula") + "\n"
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin ciclo") + "\n"
                + "Profesor Encargado:           " + (profesorEncargado != null ? profesorEncargado.getNombres() + " " + profesorEncargado.getApellidos() : "Sin profesor encargado") + "\n"
                + "Profesor Asistente:           " + (profesorAsistente != null ? profesorAsistente.getNombres() + " " + profesorAsistente.getApellidos() : "Sin profesor asistente") + "\n");
    }
}
