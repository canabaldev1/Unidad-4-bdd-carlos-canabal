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
public class ProfesorRegular extends Profesor {

    private GrupoRegular grupo;

    // CONSTRUCTORES
    public ProfesorRegular() {
        super();
    }

    public ProfesorRegular(GrupoRegular grupo, String titulacionAcademica, String profesion, String numeroCuentaBancaria, String tipoCuentaBancaria, String bancoAsociado, LocalDate fechaIngreso, String estado, String id, String nombres, String apellidos, LocalDate fechaNacimiento, String contrasena, String direccion, String email, String telefono) {
        super(titulacionAcademica, profesion, numeroCuentaBancaria, tipoCuentaBancaria, bancoAsociado, fechaIngreso, estado, id, nombres, apellidos, fechaNacimiento, contrasena, direccion, email, telefono);
        this.grupo = grupo;
    }

    public GrupoRegular getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoRegular grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return ("Profesor Regular\n" + "--------------------------\n"
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
                + "Titulación Académica:   " + titulacionAcademica + "\n"
                + "Grupo Regular:          " + (grupo != null ? grupo.getNombre() : "Sin grupo") + "\n");
    }

}
