package Grafos;

public interface IGrafo <T> {

        void insertarVertice(Usuario vertice);

        void eliminarVertice(Usuario vertice);

        void insertarArista(Usuario origen, Usuario destino);

        void eliminarArista(Usuario origen, Usuario destino);

        boolean existeVertice(Usuario vertice);

        boolean existeArista(Usuario origen, Usuario destino);

        void mostrarMatriz();

        void mostrarVertices();

        void dfs(Usuario primero);

        void bfs(Usuario primero);

        Usuario devolverVertice(int actual);
}
