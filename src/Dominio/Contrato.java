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
public class Contrato {

    private String id;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int valorSalario;
    private String estado;
    private String observaciones;
    private String cargo;
    private Empleado empleado;
    private CicloAcademico cicloAcademico;

    // CONSTRUCTORES
    public Contrato() {
        this.observaciones = "";
    }

    public Contrato(String id, String tipo, LocalDate fechaInicio, LocalDate fechaFin, int valorSalario, String estado, String observaciones, String cargo, Empleado empleado, CicloAcademico cicloAcademico) {
        this.id = id;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorSalario = valorSalario;
        this.estado = estado;
        this.observaciones = observaciones;
        this.cargo = cargo;
        this.empleado = empleado;
        this.cicloAcademico = cicloAcademico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(int valorSalario) {
        this.valorSalario = valorSalario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    @Override
    public String toString() {
        return ("Contrato\n" + "--------------------------\n"
                + "ID:                       " + id + "\n"
                + "Tipo:                     " + tipo + "\n"
                + "Fecha de Inicio:          " + fechaInicio + "\n"
                + "Fecha de Fin:             " + fechaFin + "\n"
                + "Valor del Salario:        " + valorSalario + "\n"
                + "Estado:                   " + estado + "\n"
                + "Observaciones:            " + observaciones + "\n"
                + "Cargo:                    " + cargo + "\n"
                + "Empleado:                 " + (empleado != null ? empleado.getNombres() + " " + empleado.getApellidos() : "Sin asignar") + "\n"
                + "Ciclo Académico:          " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin asignar") + "\n");
    }

}
