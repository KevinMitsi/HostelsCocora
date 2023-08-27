package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.Objects;

public class HabitacionDoble extends Habitacion implements Serializable {

    private int numCamasDobles;
    private int numCamasSencillas;
    private double precioNoche;

    public HabitacionDoble(int numCamasDobles, int numCamasSencillas, double precioNoche) {
        this.numCamasDobles = numCamasDobles;
        this.numCamasSencillas = numCamasSencillas;
        this.precioNoche = precioNoche;
    }

    public HabitacionDoble() {
    }
// Herencia de Producto:
    public HabitacionDoble(String id, TipoProducto tipo, boolean isCamaExtra, boolean isReservada, int numCamasDobles, int numCamasSencillas, double precioNoche, String identificador) {
        super(id, tipo, isCamaExtra, isReservada, identificador);
        this.numCamasDobles = numCamasDobles;
        this.numCamasSencillas = numCamasSencillas;
        this.precioNoche = precioNoche;
    }

//Herencia de Habitación:
    public HabitacionDoble(boolean isCamaExtra, boolean isReservada, int numCamasDobles, int numCamasSencillas, double precioNoche) {
        super(isCamaExtra, isReservada);
        this.numCamasDobles = numCamasDobles;
        this.numCamasSencillas = numCamasSencillas;
        this.precioNoche = precioNoche;
    }

    public int getNumCamasDobles() {
        return numCamasDobles;
    }

    public void setNumCamasDobles(int numCamasDobles) {
        this.numCamasDobles = numCamasDobles;
    }

    public int getNumCamasSencillas() {
        return numCamasSencillas;
    }

    public void setNumCamasSencillas(int numCamasSencillas) {
        this.numCamasSencillas = numCamasSencillas;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    @Override
    public String toString() {
        return "HabitacionDoble{" +
                "numCamasDobles=" + numCamasDobles +
                ", numCamasSencillas=" + numCamasSencillas +
                ", precioNoche=" + precioNoche +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HabitacionDoble that)) return false;
        if (!super.equals(o)) return false;
        return getNumCamasDobles() == that.getNumCamasDobles() && getNumCamasSencillas() == that.getNumCamasSencillas() && Double.compare(that.getPrecioNoche(), getPrecioNoche()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumCamasDobles(), getNumCamasSencillas(), getPrecioNoche());
    }
}
