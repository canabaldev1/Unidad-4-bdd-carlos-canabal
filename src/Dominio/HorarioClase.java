/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author lm-carlos
 */
public class HorarioClase {

    private String id;
    private Clase clase;
    private BloqueHorario bloqueHorario;

    // CONSTRUCTORES
    public HorarioClase() {
    }

    public HorarioClase(String id, Clase clase, BloqueHorario bloqueHorario) {
        this.id = id;
        this.clase = clase;
        this.bloqueHorario = bloqueHorario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public BloqueHorario getBloqueHorario() {
        return bloqueHorario;
    }

    public void setBloqueHorario(BloqueHorario bloqueHorario) {
        this.bloqueHorario = bloqueHorario;
    }

    @Override
    public String toString() {
        return ("Horario Clase\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Bloque Horario:               " + bloqueHorario.getId() + "\n"
                + "Clase:                        " + clase.getId() + "\n");
    }

}
