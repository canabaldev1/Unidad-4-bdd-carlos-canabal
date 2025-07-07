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
public class Asignatura {

    private String id;
    private String nombre;
    private String descripcion;
    private String prioridad;

    // CONSTRUCTORES
    public Asignatura() {

    }

    public Asignatura(String id, String nombre, String descripcion, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return ("Asignatura\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombre:                 " + nombre + "\n"
                + "Descripción:            " + descripcion + "\n"
                + "Prioridad:              " + prioridad + "\n");
    }

}
