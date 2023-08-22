package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Hostal implements Serializable {
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion>listaHabitaciones=new ArrayList<>();
    private ArrayList<Empleado>listaEmpleados=new ArrayList<>();
    private ArrayList<Usuario>listaUsuarios=new ArrayList<>();
    private ArrayList<Cliente>listaClientes=new ArrayList<>();
    private ArrayList<Cama>listaCamas=new ArrayList<>();
    private ArrayList<Reserva>listaReservas=new ArrayList<>();

    public Hostal(String nombre, String direccion, ArrayList<Habitacion> listaHabitaciones, ArrayList<Empleado> listaEmpleados, ArrayList<Usuario> listaUsuarios, ArrayList<Cliente> listaClientes, ArrayList<Cama> listaCamas, ArrayList<Reserva> listaReservas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaHabitaciones = listaHabitaciones;
        this.listaEmpleados = listaEmpleados;
        this.listaUsuarios = listaUsuarios;
        this.listaClientes = listaClientes;
        this.listaCamas = listaCamas;
        this.listaReservas = listaReservas;
    }

    public Hostal() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Cama> getListaCamas() {
        return listaCamas;
    }

    public void setListaCamas(ArrayList<Cama> listaCamas) {
        this.listaCamas = listaCamas;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "Hostal{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listaHabitaciones=" + listaHabitaciones +
                ", listaEmpleados=" + listaEmpleados +
                ", listaUsuarios=" + listaUsuarios +
                ", listaClientes=" + listaClientes +
                ", listaCamas=" + listaCamas +
                ", listaReservas=" + listaReservas +
                '}';
    }
}
