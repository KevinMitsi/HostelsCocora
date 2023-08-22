package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado implements Serializable {

    private String nombre;
    private String cedula;
    private Usuario usuario;
    private ArrayList<Planilla>listaPlanillas=new ArrayList<>();

    public Empleado(String nombre, String cedula, Usuario usuario, ArrayList<Planilla> listaPlanillas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usuario = usuario;
        this.listaPlanillas = listaPlanillas;
    }

    public Empleado() {
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

    public ArrayList<Planilla> getListaPlanillas() {
        return listaPlanillas;
    }

    public void setListaPlanillas(ArrayList<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", usuario=" + usuario +
                ", listaPlanillas=" + listaPlanillas +
                '}';
    }
}
