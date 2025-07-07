/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class BloqueHorario {

    private String id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    // CONSTRUCTORES
    public BloqueHorario() {
    }

    public BloqueHorario(String id, String dia, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return ("BloqueHorario\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Día:                    " + dia + "\n"
                + "Hora de Inicio:         " + horaInicio + "\n"
                + "Hora de Fin:            " + horaFin + "\n");
    }
}
