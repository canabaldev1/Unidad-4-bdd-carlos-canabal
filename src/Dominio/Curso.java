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
public class Curso {

    private String id;
    private String nombre;
    private NivelEducativo nivelEducativo;
    private Modalidad modalidad;

    // CONSTRUCTORES
    public Curso() {
    }

    public Curso(String id, String nombre, NivelEducativo nivelEducativo, Modalidad modalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nivelEducativo = nivelEducativo;
        this.modalidad = modalidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public String toString() {
        return ("Curso\n" + "--------------------------\n"
                + "ID :                      " + id + "\n"
                + "Nombre:                   " + nombre + "\n"
                + "Nivel Educativo:          " + (nivelEducativo != null ? nivelEducativo.getNombre() : "Sin asignar") + "\n"
                + "Modalidad:                " + (modalidad != null ? modalidad.getNombre() : "Sin asignar") + "\n");
    }

}
