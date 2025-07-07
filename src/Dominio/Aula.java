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
public class Aula {

    private String id;
    private String nombre;
    private int capacidad;
    private String ubicacion;

    // CONSTRUCTORES
    public Aula() {
    }

    public Aula(String id, String nombre, int capacidad, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return ("Aula\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombre:                 " + nombre + "\n"
                + "Capacidad:              " + capacidad + "\n"
                + "Ubicación:              " + ubicacion + "\n");
    }

}
