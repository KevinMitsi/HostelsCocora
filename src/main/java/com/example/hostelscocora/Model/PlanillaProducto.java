package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanillaProducto extends Planilla implements Serializable {

    private ArrayList<Producto>ListaProductos=new ArrayList<Producto>();

    public PlanillaProducto(String id, ArrayList<Producto> listaProductos) {
        super(id);
        ListaProductos = listaProductos;
    }

    public PlanillaProducto() {
    }

    public PlanillaProducto(ArrayList<Producto> listaProductos) {
        ListaProductos = listaProductos;
    }

    public ArrayList<Producto> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        ListaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "PlanillaProducto{" +
                "ListaProductos=" + ListaProductos +
                '}';
    }
}
