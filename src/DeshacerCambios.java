import TDAS.GrafosLista.Usuario;

public class DeshacerCambios {
    private Usuario[] datos;
    private int tope;

    public void PilaUsuario() {
        this.datos = new Usuario[100]; // Tamaño inicial para el historial
        this.tope = -1;
    }

    public void apilar(Usuario elemento) {
        this.tope = this.tope + 1;
        this.datos[this.tope] = elemento;
    }

    public Usuario desapilar() {
        if (pilaVacia()) {
            return null;
        }
        Usuario elementoDesapilado = datos[tope];
        datos[tope] = null; // Limpieza de memoria
        this.tope = this.tope - 1;
        return elementoDesapilado;
    }

    public boolean pilaVacia() {
        return (this.tope == -1);
    }
}
