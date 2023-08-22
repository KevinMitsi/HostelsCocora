package com.example.hostelscocora.Model;

import java.io.Serializable;

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
}
