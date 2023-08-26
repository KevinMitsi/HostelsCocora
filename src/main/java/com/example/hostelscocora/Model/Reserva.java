package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reserva implements Serializable {

    private String id;
    private Date fechaInicio;
    private Date fechaSalida;
    private int diasDuracionReserva;
    private String nombreCliente;
    private String idHabitacion;

    public Reserva(String id, Date fechaInicio, Date fechaSalida, int diasDuracionReserva, String nombreCliente, String idHabitacion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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
                ", fechaInicio=" + fechaInicio +
                ", fechaSalida=" + fechaSalida +
                ", diasDuracionReserva=" + diasDuracionReserva +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", idHabitacion='" + idHabitacion + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return getId().equals(reserva.getId()) && getNombreCliente().equals(reserva.getNombreCliente()) && getIdHabitacion().equals(reserva.getIdHabitacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombreCliente(), getIdHabitacion());
    }
}
