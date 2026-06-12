package Grafos;

import Conjuntos.Conjunto;

public class Usuario {
    String nombre;
    String contraseña;
    Conjunto formaciones;

    public Usuario(String nombre, String contraseña, Conjunto formaciones){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.formaciones = formaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Conjunto getFormaciones() {
        return formaciones;
    }

    public void setFormaciones(Conjunto formaciones) {
        this.formaciones = formaciones;
    }
}
