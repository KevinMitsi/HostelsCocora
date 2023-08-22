package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanillaCliente extends Planilla implements Serializable {

    private ArrayList<Cliente>listaClientes=new ArrayList<>();

    public PlanillaCliente(String id, ArrayList<Cliente> listaClientes) {
        super(id);
        listaClientes = listaClientes;
    }

    public PlanillaCliente() {
    }

    public PlanillaCliente(ArrayList<Cliente> listaClientes) {
        listaClientes = listaClientes;
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
}
