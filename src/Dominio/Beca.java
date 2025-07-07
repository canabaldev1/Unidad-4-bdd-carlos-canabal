/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author lm-carlos
 */
public class Beca {

    private String id;
    private String nombre;
    private String descripcion;
    private double valorDescuento;
    private String observaciones;
    private String otorgadaPor;
    private String estado;
    private Matricula matricula;

    // CONSTRUCTORES
    public Beca() {
    }

    public Beca(String id, String nombre, String descripcion, double valorDescuento, String observaciones, String otorgadaPor, String estado, Matricula matricula) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorDescuento = valorDescuento;
        this.observaciones = observaciones;
        this.otorgadaPor = otorgadaPor;
        this.estado = estado;
        this.matricula = matricula;
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

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOtorgadaPor() {
        return otorgadaPor;
    }

    public void setOtorgadaPor(String otorgadaPor) {
        this.otorgadaPor = otorgadaPor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return ("Beca\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombre:                 " + nombre + "\n"
                + "Descripción:            " + descripcion + "\n"
                + "Valor Descuento:        " + valorDescuento + "\n"
                + "Observaciones:          " + observaciones + "\n"
                + "Otorgada Por:           " + otorgadaPor + "\n"
                + "Estado:                 " + estado + "\n"
                + "Matrícula Asociada:     " + (matricula != null ? matricula.getId() : "Ninguna") + "\n");
    }

}
