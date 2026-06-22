package GrafosLista;

public class NodoVertice {

    Usuario dato;
    NodoVertice siguiente;
    NodoAdyacente adyacentes;
    boolean visitado;

    public NodoVertice(Usuario dato) {
        this.dato = dato;
        this.siguiente = null;
        this.adyacentes = null;
        this.visitado = false;
    }
}