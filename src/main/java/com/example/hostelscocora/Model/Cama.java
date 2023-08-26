package com.example.hostelscocora.Model;

import java.io.Serializable;

public class Cama extends Producto implements Serializable {

    public Cama(String id, TipoProducto tipo) {
        super(id, tipo);
    }

    public Cama() {
    }

}
