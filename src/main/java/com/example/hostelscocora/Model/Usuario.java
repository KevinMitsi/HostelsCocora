package com.example.hostelscocora.Model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {

    private String username;
    private String contrasena;
    private TipoUsuario tipo;

    public Usuario(String username, String contrasena, TipoUsuario tipo) {
        this.username = username;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getUsername(), usuario.getUsername()) && Objects.equals(getContrasena(), usuario.getContrasena()) && getTipo() == usuario.getTipo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getContrasena(), getTipo());
    }
}
