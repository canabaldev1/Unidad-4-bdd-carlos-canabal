/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class Alumno extends Usuario {

    private String nombreAcudiente;
    private String apellidoAcudiente;
    private String parentesco;

    // CONSTRUCTORES
    public Alumno() {
        super();

    }

    public Alumno(String nombreAcudiente, String apellidoAcudiente, String parentesco, String id, String nombres, String apellidos, LocalDate fechaNacimiento, String contrasena, String direccion, String email, String telefono) {
        super(id, nombres, apellidos, fechaNacimiento, contrasena, direccion, email, telefono);
        this.nombreAcudiente = nombreAcudiente;
        this.apellidoAcudiente = apellidoAcudiente;
        this.parentesco = parentesco;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getApellidoAcudiente() {
        return apellidoAcudiente;
    }

    public void setApellidoAcudiente(String apellidoAcudiente) {
        this.apellidoAcudiente = apellidoAcudiente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    

    @Override
    public String toString() {
        return ("Alumno\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombres:                " + nombres + "\n"
                + "Apellidos:              " + apellidos + "\n"
                + "Fecha de Nacimiento:    " + fechaNacimiento + "\n"
                + "Contraseña:             " + contrasena + "\n"
                + "Dirección:              " + direccion + "\n"
                + "Email:                  " + email + "\n"
                + "Teléfono:               " + telefono + "\n"
                + "Nombre Acudiente:       " + nombreAcudiente + "\n"
                + "Apellido Acudiente:     " + apellidoAcudiente + "\n"
                + "Parentesco Acudiente:   " + parentesco + "\n");
    }

}
