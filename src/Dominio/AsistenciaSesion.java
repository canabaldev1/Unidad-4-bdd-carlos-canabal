/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author lm-carlos
 */
public class AsistenciaSesion {

    private String id;
    private Alumno alumno;
    private Sesion sesion;
    private boolean presente;
    private String observaciones;

    // CONSTRUCTORES
    public AsistenciaSesion() {
    }

    public AsistenciaSesion(String id, Alumno alumno, Sesion sesion, boolean presente, String observaciones) {
        this.id = id;
        this.alumno = alumno;
        this.sesion = sesion;
        this.presente = presente;
        this.observaciones = observaciones;
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

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return ("Asistencia a Sesión\n" + "--------------------------\n"
                + "ID:                           " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Sesión:                       " + (sesion != null ? sesion.getId() : "Sin sesión") + "\n"
                + "Presente:                     " + (presente ? "Sí" : "No") + "\n"
                + "Observaciones:                " + observaciones + "\n");
    }

}
