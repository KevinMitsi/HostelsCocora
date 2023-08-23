package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class PlanillaCliente extends Planilla implements Serializable {

    private ArrayList<Cliente>listaClientes;

    public PlanillaCliente(String id) {
        super(id);
        listaClientes = new ArrayList<>();
    }

    public PlanillaCliente() {
    }

    public ArrayList<Cliente> getlistaClientes() {
        return listaClientes;
    }

    public void setlistaClientes(ArrayList<Cliente> listaClientes) {
        listaClientes = listaClientes;
    }

    @Override
    public String toString() {
        return "PlanillaCliente{" +
                "listaClientes=" + listaClientes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanillaCliente that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(listaClientes, that.listaClientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), listaClientes);
    }
}
