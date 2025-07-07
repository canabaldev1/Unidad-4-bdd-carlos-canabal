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
public class Sesion {

    private String id;
    private LocalDate fecha;
    private int semana;
    private BloqueHorario bloqueHorario;
    private Aula aula;
    private Clase clase;

    // CONSTRUCTORES
    public Sesion() {
    }

    public Sesion(String id, LocalDate fecha, int semana, BloqueHorario bloqueHorario, Aula aula, Clase clase) {
        this.id = id;
        this.fecha = fecha;
        this.semana = semana;
        this.bloqueHorario = bloqueHorario;
        this.aula = aula;
        this.clase = clase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public BloqueHorario getBloqueHorario() {
        return bloqueHorario;
    }

    public void setBloqueHorario(BloqueHorario bloqueHorario) {
        this.bloqueHorario = bloqueHorario;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return ("Sesión\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Fecha:                        " + fecha + "\n"
                + "Semana:                       " + semana + "\n"
                + "Bloque Horario:               " + (bloqueHorario != null ? bloqueHorario.getId() : "Sin bloque horario") + "\n"
                + "Aula:                         " + (aula != null ? aula.getNombre() : "Sin aula asignada") + "\n"
                + "Clase:                        " + (clase != null ? clase.getId() : "Sin clase asignada") + "\n");
    }

}
