package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.Objects;

public class Habitacion extends Producto implements Serializable {
    private boolean isCamaExtra;
    private boolean isReservada=false;

    public Habitacion(String id, EstadoProducto estado, TipoProducto tipo, boolean isCamaExtra, boolean isReservada) {
        super(id, estado, tipo);
        this.isCamaExtra = isCamaExtra;
        this.isReservada = isReservada;
    }

    public Habitacion(boolean isCamaExtra, boolean isReservada) {
        this.isCamaExtra = isCamaExtra;
        this.isReservada = isReservada;
    }

    public Habitacion() {
    }

    public boolean isCamaExtra() {
        return isCamaExtra;
    }

    public void setCamaExtra(boolean camaExtra) {
        isCamaExtra = camaExtra;
    }

    public boolean isReservada() {
        return isReservada;
    }

    public void setReservada(boolean reservada) {
        isReservada = reservada;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "isCamaExtra=" + isCamaExtra +
                ", isReservada=" + isReservada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion that)) return false;
        return isCamaExtra() == that.isCamaExtra() && isReservada() == that.isReservada();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCamaExtra(), isReservada());
    }
}
