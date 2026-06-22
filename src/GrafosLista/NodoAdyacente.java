package GrafosLista;

public class NodoAdyacente<T> {

    Usuario dato;
    NodoAdyacente siguiente;

    public NodoAdyacente(Usuario dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}