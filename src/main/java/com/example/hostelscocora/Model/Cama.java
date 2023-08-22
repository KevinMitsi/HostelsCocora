package com.example.hostelscocora.Model;

import java.io.Serializable;

public class Cama extends Producto implements Serializable {

    public Cama(String id, EstadoProducto estado, TipoProducto tipo) {
        super(id, estado, tipo);
    }

    public Cama() {
    }
}
