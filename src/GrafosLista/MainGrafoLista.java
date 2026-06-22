package GrafosLista;

import Conjuntos.Conjunto;
import Diccionari.DictStr;

public class MainGrafoLista {
    public static void main(String[] args) {

        DictStr instant = new DictStr(3);
        Igrafo red = new GrafoLista(false);

        String nombre;
        String contrasena;
        int opc_empleador = 0;
        int codigo_empleador = 137;
        int codigo;

        Conjunto a = new Conjunto(3); //pim
        Conjunto b = new Conjunto(3);
        a.insertar("Python");
        a.insertar("C#");
        a.insertar("LOLCAT");
        b.insertar("C++");
        b.insertar("C");
        b.insertar("Holy C");
        Conjunto c = new Conjunto(3);
        c.insertar("ingInf");

        Usuario maxi = new Usuario("Maxi", "12345", new Conjunto(3),true,c);
        Usuario bruno = new Usuario("Bruno", "kactus", a, false,c);
        Usuario ramiro = new Usuario("Ramiro", "jhonson", b,false,c);

        red.insertarVertice(maxi);
        red.insertarVertice(bruno);
        red.insertarVertice(ramiro);

        instant.insertar(maxi.getContraseña(), maxi);
        instant.insertar(bruno.getContraseña(), bruno);
        instant.insertar(ramiro.getContraseña(), ramiro);

        red.insertarArista(ramiro, bruno);
        red.insertarArista(maxi, bruno);

        red.mostrarGrafo();
        System.out.println();
        red.recorridoDFS(maxi);
        System.out.println();
        red.recorridoBFS(maxi);

        Usuario a1 = new Usuario("a", "1", new Conjunto(3), false, c);
        Usuario b1 = new Usuario("b", "1", new Conjunto(3), false, c);
        Usuario c1 = new Usuario("c", "1", new Conjunto(3), false, c);
        Usuario d1 = new Usuario("d", "1", new Conjunto(3), false, c);
        Usuario e1 = new Usuario("e", "1", new Conjunto(3), false, c);
        Usuario f1 = new Usuario("f", "1", new Conjunto(3), false, c);
        red.insertarVertice(a1);
        red.insertarVertice(b1);
        red.insertarVertice(c1);
        red.insertarVertice(d1);
        red.insertarVertice(e1);
        red.insertarVertice(f1);

        red.insertarArista(a1, f1);
        red.insertarArista(a1, c1);
        red.insertarArista(e1, b1);
        red.insertarArista(a1, b1);
        red.insertarArista(d1, a1);
        red.insertarArista(maxi, a1);

        red.insertarArista(e1, ramiro);

        red.mostrarGrafo();
        red.recorridoBFS(a1);
        red.recorridoDFS(a1);

        red.existeVertice(a1);
    }
}
