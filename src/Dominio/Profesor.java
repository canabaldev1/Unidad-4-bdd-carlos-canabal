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
public abstract class Profesor extends Empleado {

    protected String titulacionAcademica;

    //CONSTRUCTORES
    public Profesor() {
        super();
    }

    public Profesor(String titulacionAcademica, String profesion, String numeroCuentaBancaria, String tipoCuentaBancaria, String bancoAsociado, LocalDate fechaIngreso, String estado, String id, String nombres, String apellidos, LocalDate fechaNacimiento, String contrasena, String direccion, String email, String telefono) {
        super(profesion, numeroCuentaBancaria, tipoCuentaBancaria, bancoAsociado, fechaIngreso, estado, id, nombres, apellidos, fechaNacimiento, contrasena, direccion, email, telefono);
        this.titulacionAcademica = titulacionAcademica;
    }

    public String getTitulacionAcademica() {
        return titulacionAcademica;
    }

    public void setTitulacionAcademica(String titulacionAcademica) {
        this.titulacionAcademica = titulacionAcademica;
    }

    @Override
    public String toString() {
        return ("Profesor\n" + "--------------------------\n"
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
                + "Estado:                 " + estado + "\n"
                + "Titulación Académica:   " + titulacionAcademica + "\n");
    }
}
