/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author lm-carlos
 */
public class DesempenoAlumno {

    private String id;
    private Alumno alumno;
    private Clase clase;
    private String observaciones;
    private double notaPrimerTrimestre;
    private double notaSegundoTrimestre;
    private double notaTercerTrimestre;
    private double notaHabilitacion;
    private String estado;

    //CONSTRUCTORES
    public DesempenoAlumno() {
    }

    public DesempenoAlumno(String id, Alumno alumno, Clase clase, String observaciones, double notaPrimerTrimestre, double notaSegundoTrimestre, double notaTercerTrimestre, double notaHabilitacion, String estado) {
        this.id = id;
        this.alumno = alumno;
        this.clase = clase;
        this.observaciones = observaciones;
        this.notaPrimerTrimestre = notaPrimerTrimestre;
        this.notaSegundoTrimestre = notaSegundoTrimestre;
        this.notaTercerTrimestre = notaTercerTrimestre;
        this.notaHabilitacion = notaHabilitacion;
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

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getNotaPrimerTrimestre() {
        return notaPrimerTrimestre;
    }

    public void setNotaPrimerTrimestre(double notaPrimerTrimestre) {
        this.notaPrimerTrimestre = notaPrimerTrimestre;
    }

    public double getNotaSegundoTrimestre() {
        return notaSegundoTrimestre;
    }

    public void setNotaSegundoTrimestre(double notaSegundoTrimestre) {
        this.notaSegundoTrimestre = notaSegundoTrimestre;
    }

    public double getNotaTercerTrimestre() {
        return notaTercerTrimestre;
    }

    public void setNotaTercerTrimestre(double notaTercerTrimestre) {
        this.notaTercerTrimestre = notaTercerTrimestre;
    }

    public double getNotaHabilitacion() {
        return notaHabilitacion;
    }

    public void setNotaHabilitacion(double notaHabilitacion) {
        this.notaHabilitacion = notaHabilitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return ("DesempeñoAlumno\n" + "--------------------------\n"
                + "ID:                           " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Clase:                        " + (clase != null ? clase.getId() : "Sin clase") + "\n"
                + "Observaciones:                " + observaciones + "\n"
                + "Nota Primer Trimestre:        " + notaPrimerTrimestre + "\n"
                + "Nota Segundo Trimestre:       " + notaSegundoTrimestre + "\n"
                + "Nota Tercer Trimestre:        " + notaTercerTrimestre + "\n"
                + "Nota de Habilitación:         " + notaHabilitacion + "\n"
                + "Estado:                       " + estado + "\n");
    }

}
