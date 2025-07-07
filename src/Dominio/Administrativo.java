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
public class Administrativo extends Empleado {

    private String areaAdministrativa;

    // CONSTRUCTORES
    public Administrativo() {
        super();
    }

    public Administrativo(String areaAdministrativa, String profesion, String numeroCuentaBancaria, String tipoCuentaBancaria, String bancoAsociado, LocalDate fechaIngreso, String estado, String id, String nombres, String apellidos, LocalDate fechaNacimiento, String contrasena, String direccion, String email, String telefono) {
        super(profesion, numeroCuentaBancaria, tipoCuentaBancaria, bancoAsociado, fechaIngreso, estado, id, nombres, apellidos, fechaNacimiento, contrasena, direccion, email, telefono);
        this.areaAdministrativa = areaAdministrativa;
    }

    public String getAreaAdministrativa() {
        return areaAdministrativa;
    }

    public void setAreaAdministrativa(String areaAdministrativa) {
        this.areaAdministrativa = areaAdministrativa;
    }

    @Override
    public String toString() {
        return ("Administrativo\n" + "--------------------------\n"
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
                + "Área Administrativa:    " + areaAdministrativa + "\n");
    }
}
