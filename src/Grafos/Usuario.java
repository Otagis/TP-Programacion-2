package Grafos;

import Conjuntos.Conjunto;

public class Usuario {
    String nombre;
    String contraseña;
    Boolean empleador;
    Conjunto formaciones;

    public Usuario(String nombre, String contraseña, Conjunto formaciones,  Boolean empleador) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.formaciones = formaciones;
        this.empleador = empleador;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEmpleador() {return empleador;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Conjunto getFormaciones() {return formaciones;}

    public void setFormaciones(Conjunto formaciones) {this.formaciones = formaciones;}



}
