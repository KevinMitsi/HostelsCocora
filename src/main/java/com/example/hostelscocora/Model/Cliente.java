package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private String nombre;
    private String cedula;
    private Usuario usuario;
    private ArrayList<Reserva>listaReservas=new ArrayList<Reserva>();

    public Cliente(String nombre, String cedula, Usuario usuario, ArrayList<Reserva> listaReservas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usuario = usuario;
        this.listaReservas = listaReservas;
    }

    public Cliente(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", usuario=" + usuario +
                ", listaReservas=" + listaReservas +
                '}';
    }
}
