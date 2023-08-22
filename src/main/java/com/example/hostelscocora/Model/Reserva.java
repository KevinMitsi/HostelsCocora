package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {
    private String id;
    private LocalDate fecha;
    private int diasDuracionReserva;
    private String nombreCliente;
    private String idHabitacion;

    public Reserva(String id, LocalDate fecha, int diasDuracionReserva, String nombreCliente, String idHabitacion) {
        this.id = id;
        this.fecha = fecha;
        this.diasDuracionReserva = diasDuracionReserva;
        this.nombreCliente = nombreCliente;
        this.idHabitacion = idHabitacion;
    }

    public Reserva() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDiasDuracionReserva() {
        return diasDuracionReserva;
    }

    public void setDiasDuracionReserva(int diasDuracionReserva) {
        this.diasDuracionReserva = diasDuracionReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", diasDuracionReserva=" + diasDuracionReserva +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", idHabitacion='" + idHabitacion + '\'' +
                '}';
    }
}
