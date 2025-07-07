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
public abstract class Grupo {

    protected String id;
    protected String nombre;
    protected Curso curso;
    protected Aula aula;
    protected CicloAcademico cicloAcademico;

    // CONSTRUCTORES
    public Grupo() {
    }

    public Grupo(String id, String nombre, Curso curso, Aula aula, CicloAcademico cicloAcademico) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.aula = aula;
        this.cicloAcademico = cicloAcademico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    @Override
    public String toString() {
        return ("Grupo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Curso:                        " + (curso != null ? curso.getNombre() : "Sin curso") + "\n"
                + "Aula:                         " + (aula != null ? aula.getNombre() : "Sin aula") + "\n"
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin ciclo") + "\n");
    }

}
