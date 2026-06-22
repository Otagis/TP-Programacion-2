package GrafosLista;

public class ColaPropia {

    private NodoCola frente;
    private NodoCola fin;

    public ColaPropia() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(NodoVertice dato) {
        NodoCola nuevo = new NodoCola(dato);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public NodoVertice desencolar() {
        if (estaVacia()) {
            return null;
        }

        NodoVertice dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}