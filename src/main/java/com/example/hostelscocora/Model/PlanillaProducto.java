package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class PlanillaProducto extends Planilla implements Serializable {

    private ArrayList<Producto>ListaProductos;

    public PlanillaProducto(String id) {
        super(id);
        ListaProductos = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanillaProducto that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getListaProductos(), that.getListaProductos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getListaProductos());
    }
}
