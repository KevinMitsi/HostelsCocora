package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.Objects;

public class HabitacionSencilla extends Habitacion implements Serializable {

    private double precioNoche;

//Herencia producto:
    public HabitacionSencilla(String id, EstadoProducto estado, TipoProducto tipo, boolean isCamaExtra, boolean isReservada, double precioNoche) {
        super(id, estado, tipo, isCamaExtra, isReservada);
        this.precioNoche = precioNoche;
    }

//HerenciaHabitación:
    public HabitacionSencilla(boolean isCamaExtra, boolean isReservada, double precioNoche) {
        super(isCamaExtra, isReservada);
        this.precioNoche = precioNoche;
    }

    public HabitacionSencilla(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public HabitacionSencilla() {
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    @Override
    public String toString() {
        return "HabitacionSencilla{" +
                "precioNoche=" + precioNoche +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HabitacionSencilla that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.getPrecioNoche(), getPrecioNoche()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPrecioNoche());
    }
}
