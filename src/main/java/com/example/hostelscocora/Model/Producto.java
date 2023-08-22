package com.example.hostelscocora.Model;

import java.io.Serializable;

public class Producto implements Serializable {
    private String id;
    private EstadoProducto estado;
    private TipoProducto tipo;

    public Producto(String id, EstadoProducto estado, TipoProducto tipo) {
        this.id = id;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Producto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", estado=" + estado +
                ", tipo=" + tipo +
                '}';
    }
}
