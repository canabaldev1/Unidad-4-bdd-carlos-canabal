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
public abstract class Empleado extends Usuario {

    protected String profesion;
    protected String numeroCuentaBancaria;
    protected String tipoCuentaBancaria;
    protected String bancoAsociado;
    protected LocalDate fechaIngreso;
    protected String estado;

    // CONSTRUCTORES
    public Empleado() {
        super();
    }

    public Empleado(String profesion, String numeroCuentaBancaria, String tipoCuentaBancaria, String bancoAsociado, LocalDate fechaIngreso, String estado, String id, String nombres, String apellidos, LocalDate fechaNacimiento, String contrasena, String direccion, String email, String telefono) {
        super(id, nombres, apellidos, fechaNacimiento, contrasena, direccion, email, telefono);
        this.profesion = profesion;
        this.numeroCuentaBancaria = numeroCuentaBancaria;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.bancoAsociado = bancoAsociado;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }

    public String getTipoCuentaBancaria() {
        return tipoCuentaBancaria;
    }

    public void setTipoCuentaBancaria(String tipoCuentaBancaria) {
        this.tipoCuentaBancaria = tipoCuentaBancaria;
    }

    public String getBancoAsociado() {
        return bancoAsociado;
    }

    public void setBancoAsociado(String bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return ("Empleado\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombres:                " + nombres + "\n"
                + "Apellidos:              " + apellidos + "\n"
                + "Fecha de Nacimiento:    " + fechaNacimiento + "\n"
                + "Contraseña:             " + contrasena + "\n"
                + "Dirección:              " + direccion + "\n"
                + "Email:                  " + email + "\n"
                + "Teléfono:               " + telefono + "\n"
                + "Profesión:              " + profesion + "\n"
                + "Numero de Cuenta:       " + numeroCuentaBancaria + "\n"
                + "Tipo de Cuenta:         " + tipoCuentaBancaria + "\n"
                + "Banco:                  " + bancoAsociado + "\n"
                + "Fecha de ingreso:       " + fechaIngreso + "\n"
                + "Estado:                 " + estado + "\n");
    }

}
