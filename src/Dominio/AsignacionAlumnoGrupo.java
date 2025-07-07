/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;

/**
 *
 * @author lm-carlos
 */
public class AsignacionAlumnoGrupo {

    private String id;
    private Alumno alumno;
    private Grupo grupo;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;
    private String estado;

    // CONSTRUCTORES
    public AsignacionAlumnoGrupo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
        this.fechaInicioInscripcion = fechaInicioInscripcion;
    }

    public LocalDate getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public AsignacionAlumnoGrupo(String id, Alumno alumno, Grupo grupo, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion, String estado) {
        this.id = id;
        this.alumno = alumno;
        this.grupo = grupo;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return ("Asignación Alumno a Grupo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Grupo:                        " + (grupo != null ? grupo.getNombre() : "Sin grupo") + "\n"
                + "Fecha de Inicio Inscripción:  " + fechaInicioInscripcion + "\n"
                + "Fecha de Fin Inscripción:     " + fechaFinInscripcion + "\n"
                + "Estado:                       " + estado + "\n");
    }
}
