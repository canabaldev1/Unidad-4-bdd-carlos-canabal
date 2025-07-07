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
public class AsignacionAlumnoServicio {

    private String id;
    private Alumno alumno;
    private ServicioComplementario servicioComplementario;
    private LocalDate fechaInicioAsignacion;
    private LocalDate fechaFinAsignacion;
    private String estado;

    //CONSTRUCTORES
    public AsignacionAlumnoServicio() {
    }

    public AsignacionAlumnoServicio(String id, Alumno alumno, ServicioComplementario servicioComplementario, LocalDate fechaInicioAsignacion, LocalDate fechaFinAsignacion, String estado) {
        this.id = id;
        this.alumno = alumno;
        this.servicioComplementario = servicioComplementario;
        this.fechaInicioAsignacion = fechaInicioAsignacion;
        this.fechaFinAsignacion = fechaFinAsignacion;
        this.estado = estado;
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

    public ServicioComplementario getServicioComplementario() {
        return servicioComplementario;
    }

    public void setServicioComplementario(ServicioComplementario servicioComplementario) {
        this.servicioComplementario = servicioComplementario;
    }

    public LocalDate getFechaInicioAsignacion() {
        return fechaInicioAsignacion;
    }

    public void setFechaInicioAsignacion(LocalDate fechaInicioAsignacion) {
        this.fechaInicioAsignacion = fechaInicioAsignacion;
    }

    public LocalDate getFechaFinAsignacion() {
        return fechaFinAsignacion;
    }

    public void setFechaFinAsignacion(LocalDate fechaFinAsignacion) {
        this.fechaFinAsignacion = fechaFinAsignacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return ("Asignación Alumno a Servicio Complementario\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Servicio Complementario:      " + (servicioComplementario != null ? servicioComplementario.getNombre() : "Sin servicio complementario") + "\n"
                + "Fecha de Inicio Inscripción:  " + fechaInicioAsignacion + "\n"
                + "Fecha de Fin Inscripción:     " + fechaFinAsignacion + "\n"
                + "Estado:                       " + estado + "\n");
    }
}
