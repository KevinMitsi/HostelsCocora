package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanillaReserva extends Planilla implements Serializable {

    private ArrayList<Reserva>listaReservas=new ArrayList<>();

    public PlanillaReserva(String id, ArrayList<Reserva> listaReservas) {
        super(id);
        listaReservas = listaReservas;
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
}
