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
public class Clase {

    private String id;
    private GrupoRegular grupo;
    private ProfesorRegular profesor;
    private Asignatura asignatura;
    private CicloAcademico cicloAcademico;

    // CONSTRUCTORES
    public Clase() {

    }

    public Clase(String id, GrupoRegular grupo, ProfesorRegular profesor, Asignatura asignatura, CicloAcademico cicloAcademico) {
        this.id = id;
        this.grupo = grupo;
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.cicloAcademico = cicloAcademico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GrupoRegular getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoRegular grupo) {
        this.grupo = grupo;
    }

    public ProfesorRegular getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorRegular profesor) {
        this.profesor = profesor;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    @Override
    public String toString() {
        return ("Clase\n" + "--------------------------\n"
                + "ID :                            " + id + "\n"
                + "Grupo:                          " + (grupo != null ? grupo.getNombre() : "Sin asignar") + "\n"
                + "Profesor:                       " + (profesor != null ? profesor.getNombres() + " " + profesor.getApellidos() : "Sin asignar") + "\n"
                + "Asignatura:                     " + (asignatura != null ? asignatura.getNombre() : "Sin asignar") + "\n"
                + "Ciclo Académico:                " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin asignar") + "\n");
    }

}
