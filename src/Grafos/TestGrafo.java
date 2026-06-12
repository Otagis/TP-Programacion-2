package Grafos;

public class TestGrafo {
    public static void main(String[] args) {

        IGrafo<Usuario> grafo = new GrafoMatrizAdyacencia(6, false);

//        Usuario v1 = new Usuario("p1", "aaa");
//        Usuario v2 = new Usuario("p2", "bbb");
//        Usuario v3 = new Usuario("p3", "ccc");
//
//        grafo.insertarVertice(v1);
//        grafo.insertarVertice(v2);
//        grafo.insertarVertice(v3);
//
//        grafo.insertarArista(v1, v2);
//        grafo.insertarArista(v1, v3);
//
//        grafo.mostrarVertices();
//        grafo.mostrarMatriz();
//
//        System.out.println();
//
//        System.out.println("Existe vértice A: " + grafo.existeVertice(v1));
//        System.out.println("Existe arista A-C: " + grafo.existeArista(v1, v3));
//
//        System.out.println();
//
//
//        System.out.println("Después de eliminar la arista A-C:");
//        grafo.mostrarMatriz();
//
//        System.out.println();
//
//
//        System.out.println("Después de eliminar el vértice B:");
//        grafo.mostrarVertices();
//        grafo.mostrarMatriz();
//
//        System.out.println();
//
//        grafo.dfs(v3);
//
//        System.out.println(grafo.existeVertice(v1));
    }
}