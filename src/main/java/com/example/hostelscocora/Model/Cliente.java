package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private String nombre;
    private String cedula;
    private Usuario usuario;

    public Cliente(String nombre) { //poner constructor con todos los parámetros
        this.nombre = nombre;
    }

    public Cliente(){
    }

}
