/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author lm-carlos
 */
public class Matricula {

    private String id;
    private LocalDateTime fechaMatricula;
    private String estado;
    private LocalDateTime fechaPago;
    private int valorMatricula;
    private int valorMensualidad;
    private String observaciones;
    private Alumno alumno;
    private CicloAcademico cicloAcademico;
    private Curso curso;
    private Beca beca;

    // CONSTRUCTORES
    public Matricula() {
    }

    public Matricula(String id, LocalDateTime fechaMatricula, String estado, LocalDateTime fechaPago, int valorMatricula, int valorMensualidad, String observaciones, Alumno alumno, CicloAcademico cicloAcademico, Curso curso, Beca beca) {
        this.id = id;
        this.fechaMatricula = fechaMatricula;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.valorMatricula = valorMatricula;
        this.valorMensualidad = valorMensualidad;
        this.observaciones = observaciones;
        this.alumno = alumno;
        this.cicloAcademico = cicloAcademico;
        this.curso = curso;
        this.beca = beca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDateTime fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(int valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public int getValorMensualidad() {
        return valorMensualidad;
    }

    public void setValorMensualidad(int valorMensualidad) {
        this.valorMensualidad = valorMensualidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Beca getBeca() {
        return beca;
    }

    public void setBeca(Beca beca) {
        this.beca = beca;
    }

    @Override
    public String toString() {
        return ("Matrícula\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Fecha de Matrícula:           " + fechaMatricula + "\n"
                + "Estado:                       " + estado + "\n"
                + "Fecha de Pago:                " + (fechaPago != null ? fechaPago : "Pago no realizado.") + "\n"
                + "Valor de Matrícula:           " + valorMatricula + "\n"
                + "Valor de Mensualidad:         " + valorMensualidad + "\n"
                + "Observaciones:                " + observaciones + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getAnio() : "Sin ciclo") + "\n"
                + "Curso:                        " + (curso != null ? curso.getNombre() : "Sin curso") + "\n"
                + "Beca:                         " + (beca != null ? beca.getNombre() : "Sin beca") + "\n");
    }

}
