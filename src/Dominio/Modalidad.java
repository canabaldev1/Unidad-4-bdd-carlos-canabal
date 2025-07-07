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
public class Modalidad {

    private String id;
    private String nombre;
    private String descripcion;
    private NivelEducativo nivelEducativo;

    // CONSTRUCTORES
    public Modalidad() {

    }

    public Modalidad(String id, String nombre, String descripcion, NivelEducativo nivelEducativo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelEducativo = nivelEducativo;
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

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    @Override
    public String toString() {
        return ("Modalidad\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Descripción:                  " + descripcion + "\n"
                + "Nivel Educativo:              " + (nivelEducativo != null ? nivelEducativo.getNombre() : "Sin nivel educativo") + "\n");
    }
}
