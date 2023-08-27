package com.example.hostelscocora.Model;

import java.io.Serializable;

public class Cama extends Producto implements Serializable {
    private String idHabitacionContiene;

    public Cama(String id, TipoProducto tipo, String identificador, String idHabitacionContiene) {
        super(id, tipo, identificador);
        this.idHabitacionContiene=idHabitacionContiene;
       }

    public Cama() {
    }

    public String getIdHabitacionContiene() {
        return idHabitacionContiene;
    }

    public void setIdHabitacionContiene(String idHabitacionContiene) {
        this.idHabitacionContiene = idHabitacionContiene;
    }
}
