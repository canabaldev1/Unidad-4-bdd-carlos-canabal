/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class CicloAcademico {

    private String id;
    private int anio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private int cantidadSemanas;

    // CONSTRUCTORES
    public CicloAcademico() {
    }

    public CicloAcademico(String id, int anio, LocalDate fechaInicio, LocalDate fechaFin, String estado, int cantidadSemanas) {
        this.id = id;
        this.anio = anio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.cantidadSemanas = cantidadSemanas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadSemanas() {
        return cantidadSemanas;
    }

    public void setCantidadSemanas(int cantidadSemanas) {
        this.cantidadSemanas = cantidadSemanas;
    }

    @Override
    public String toString() {
        return ("CicloAcademico\n" + "--------------------------\n"
                + "ID :                            " + id + "\n"
                + "Año:                            " + anio + "\n"
                + "Fecha de Inicio:                " + fechaInicio + "\n"
                + "Fecha de Fin:                   " + fechaFin + "\n"
                + "Estado:                         " + estado + "\n"
                + "Cantidad de Semanas:           " + cantidadSemanas + "\n");
    }

}
