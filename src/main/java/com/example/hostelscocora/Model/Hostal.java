package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Hostal implements Serializable {
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion>listaHabitaciones;
    private ArrayList<Empleado>listaEmpleados;
    private ArrayList<Usuario>listaUsuarios;
    private ArrayList<Cliente>listaClientes;
    private ArrayList<Cama>listaCamas;
    private ArrayList<Reserva>listaReservas;

    /*---------------constructors---------------------*/

    public Hostal(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaHabitaciones = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaCamas = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
    }

    public Hostal() {
    }

    /*--------Getters && Setters---------*/

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

   /*----------------Equals and HashCode------------------------*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hostal hostal)) return false;
        return Objects.equals(getNombre(), hostal.getNombre()) && Objects.equals(getDireccion(), hostal.getDireccion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDireccion());
    }
   /*--------------Own Class Methods*----------------------------*/


/*------------Create Methods-------------------------*/

    public Usuario crearUsuario(String username, String password, TipoUsuario tipoUsuario) throws Exception {
        Usuario user = new Usuario(username, password, tipoUsuario);
        if(listaUsuarios.contains(user)){
            throw new Exception("Usuario ya creado");
        }
        else{
            listaUsuarios.add(user);
            return user;
        }
    }

    public Empleado crearEmpleado(String nombre, String cedula, Usuario usuario) throws Exception {
        Empleado empleado = new Empleado(nombre, cedula, usuario);
        if(listaEmpleados.contains(empleado)){
            throw new Exception("Este empleado ya está creado");
        }
        else{
            listaEmpleados.add(empleado);
            return empleado;
        }
    }

  /*  -----------Delete Mehtods--------------*/

    public void eliminarUsuario(Usuario usuario) throws Exception {
        if(listaUsuarios.contains(usuario)){
            listaUsuarios.remove(usuario);
        }
        else {
            throw new Exception("El usuario no existe");
        }
    }

    public void eliminarEmpleado(Empleado empleado) throws Exception {
        if(listaEmpleados.contains(empleado)){
            listaEmpleados.remove(empleado);
        }
        else {
            throw new Exception("El empleado no existe");
        }
    }
}


