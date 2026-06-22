package Pila;

import Conjuntos.Conjunto;

public class PilaConjunto {

    private Conjunto[] datos = new Conjunto[6];
    private int tope = -1;

    public void apilar(Conjunto elemento) {
        tope = tope + 1;
        datos[tope] = elemento;
    }

    public Conjunto desapilar() {
        Conjunto elementoDesapilado = datos[tope];
        datos[tope] = null;
        tope = tope - 1;
        return elementoDesapilado;
    }

    public boolean pilaVacia() {
        return tope == -1;
    }
}
