package TDAS.GrafosLista;

import TDAS.Conjuntos.Conjunto;
import TDAS.Pila.Pila;

public class Usuario {
    String nombre;
    String contraseña;
    Boolean empleador;
    Conjunto formaciones;
    Conjunto titulo;
    Pila historialNombre;
    Pila historialContraseña;

    public Usuario(String nombre, String contraseña, Conjunto formaciones,  Boolean empleador,  Conjunto tintulo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.formaciones = formaciones;
        this.empleador = empleador;
        this.titulo =  tintulo;
        this.historialNombre =  new Pila(10);
        this.historialContraseña =  new Pila(10);
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

    public Conjunto getTitulo() {return titulo;}

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Conjunto getFormaciones() {return formaciones;}

    public void setFormaciones(Conjunto formaciones) {this.formaciones = formaciones;}

    public Pila getHistorialNombre() {return historialNombre;}

    public Pila getHistorialContraseña() {return historialContraseña;}
}
