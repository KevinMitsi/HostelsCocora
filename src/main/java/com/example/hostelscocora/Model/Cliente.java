package com.example.hostelscocora.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Cliente implements Serializable {
    private String nombre;
    private String cedula;
    private Usuario usuario;
    private ArrayList<Reserva>listaReservas;

    public Cliente(String nombre, String cedula, Usuario usuario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usuario = usuario;
        this.listaReservas = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getNombre(), cliente.getNombre()) && Objects.equals(getCedula(), cliente.getCedula()) && Objects.equals(getUsuario(), cliente.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getCedula(), getUsuario());
    }

    public static void crearReserva(String nombre, Date fechaIngreso, Date fechaSalida, String idHabitacion){
    }
    public static void editarReserva(Reserva reserva){

    }
    public static void eliminarReserva(Reserva reserva){

    }

}
