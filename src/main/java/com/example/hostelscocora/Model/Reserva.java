package com.example.hostelscocora.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reserva implements Serializable {

    private String id;
    private LocalDate fechaInicio;
    private LocalDate fechaSalida;
    private int diasDuracionReserva;
    private String nombreCliente;
    private String idHabitacion;

    public Reserva(String id, LocalDate fechaInicio, LocalDate fechaSalida, String nombreCliente, String idHabitacion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
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
