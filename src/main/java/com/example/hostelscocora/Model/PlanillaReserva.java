package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class PlanillaReserva extends Planilla implements Serializable {

    private ArrayList<Reserva>listaReservas;

    public PlanillaReserva(String id) {
        super(id);
        listaReservas = new ArrayList<>();
    }

    public PlanillaReserva() {
    }

    public PlanillaReserva(ArrayList<Reserva> listaReservas) {
        listaReservas = listaReservas;
    }

    public ArrayList<Reserva> getlistaReservas() {
        return listaReservas;
    }

    public void setlistaReservas(ArrayList<Reserva> listaReservas) {
        listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "PlanillaReserva{" +
                "listaReservas=" + listaReservas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanillaReserva that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(listaReservas, that.listaReservas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), listaReservas);
    }
}
