package com.example.hostelscocora.Model;

import java.io.Serializable;

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
}
