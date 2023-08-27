package com.example.hostelscocora.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {
    private String id;
    private EstadoProducto estado = EstadoProducto.DISPONIBLE;
    private TipoProducto tipo;

    private String identificador;

    public Producto(String id, TipoProducto tipo, String identificador) {
        this.id = id;
        this.tipo = tipo;
        this.identificador=identificador;
    }

    public Producto() {
    }

    public String getIdentificador() {
        return this.identificador;
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
                ", identificador=" + identificador +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(getId(), producto.getId()) && getEstado() == producto.getEstado() && getTipo() == producto.getTipo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEstado(), getTipo());
    }


}
