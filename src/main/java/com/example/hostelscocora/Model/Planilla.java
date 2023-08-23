package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.Objects;

public class Planilla implements Serializable {

    private String id;

    public Planilla(String id) {
        this.id = id;
    }

    public Planilla() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Planilla{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planilla planilla)) return false;
        return Objects.equals(getId(), planilla.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
