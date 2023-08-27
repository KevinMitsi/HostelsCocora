package com.example.hostelscocora.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Empleado implements Serializable {
    private String nombre;
    private String cedula;
    private Usuario usuario;
    private ArrayList<Planilla>listaPlanillas;

    public Empleado(String nombre, String cedula, Usuario usuario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usuario = usuario;
        this.listaPlanillas =new ArrayList<>();
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado empleado)) return false;
        return Objects.equals(getNombre(), empleado.getNombre()) && Objects.equals(getCedula(), empleado.getCedula()) && Objects.equals(getUsuario(), empleado.getUsuario());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getCedula(), getUsuario());
    }

    public static void crearPlanilla(String id, String tipo){

    }

    public static void editarPlanilla(Planilla planilla){

    }

    public static void eliminarPlanilla(Planilla planilla){

    }


}
