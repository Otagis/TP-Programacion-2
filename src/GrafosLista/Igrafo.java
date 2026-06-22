package GrafosLista;

import java.util.List;

public interface Igrafo {
        void insertarVertice(Usuario dato);

        void eliminarVertice(Usuario dato);

        void insertarArista(Usuario origen, Usuario destino);

        void eliminarArista(Usuario origen, Usuario destino);

        boolean existeVertice(Usuario dato);

        boolean existeArista(Usuario origen, Usuario destino);

        void mostrarGrafo();

        void recorridoDFS(Usuario inicio);

        void recorridoBFS(Usuario inicio);
}
