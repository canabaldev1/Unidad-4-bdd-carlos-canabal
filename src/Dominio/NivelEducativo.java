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
public class NivelEducativo {

    private String id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private List<Curso> cursos;
    private List<Modalidad> modalidadesDisponibles;

    // CONSTRUCTORES
    public NivelEducativo() {
    }

    public NivelEducativo(String id, String nombre, String descripcion, String tipo, List<Curso> cursos, List<Modalidad> modalidadesDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cursos = cursos;
        this.modalidadesDisponibles = modalidadesDisponibles;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Modalidad> getModalidadesDisponibles() {
        return modalidadesDisponibles;
    }

    public void setModalidadesDisponibles(List<Modalidad> modalidadesDisponibles) {
        this.modalidadesDisponibles = modalidadesDisponibles;
    }

    @Override
    public String toString() {
        return ("Nivel Educativo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Descripción:                  " + descripcion + "\n"
                + "Tipo:                         " + tipo + "\n"
                + "Cantidad de Cursos:           " + cursos.size() + "\n"
                + "Cantidad de Modalidades:      " + modalidadesDisponibles.size() + "\n");
    }

}
