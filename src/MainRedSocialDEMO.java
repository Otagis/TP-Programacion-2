import Conjuntos.Conjunto;
import Diccionari.DictStr;
import Grafos.GrafoMatrizAdyacencia;
import Grafos.IGrafo;
import Grafos.Usuario;

import java.util.Scanner;

public class MainRedSocialDEMO{
    static void main() {
        DictStr instant = new DictStr(3);
        IGrafo<Usuario> red = new GrafoMatrizAdyacencia(3, false);

        Conjunto a = new Conjunto(3);
        Conjunto b = new Conjunto(3);
        a.insertar("Python");
        a.insertar("C#");
        a.insertar("LOLCAT");
        b.insertar("C++");
        b.insertar("C");
        b.insertar("Holy C");

        Usuario maxi = new Usuario("Maxi", "12345", new Conjunto(3));
        Usuario bruno = new Usuario("Bruno", "kactus", a);
        Usuario ramiro = new Usuario("Ramiro", "jhonson", b);

        red.insertarVertice(maxi);
        red.insertarVertice(bruno);
        red.insertarVertice(ramiro);

        instant.insertar(maxi.getContraseña(), maxi);
        instant.insertar(bruno.getContraseña(), bruno);
        instant.insertar(ramiro.getContraseña(), ramiro);

        red.insertarArista(ramiro, bruno);
        red.insertarArista(maxi, bruno);

        Scanner sc = new Scanner(System.in);

        Usuario sesionActual = null;
        int opcion = 0;
        String contraseña;

        System.out.println("Hola bienvenido a [INSERTAR_NOMBRE_DE_RED_SOCIAL_GENERICA].");
        System.out.println();

        do {
            if (sesionActual == null){
                System.out.println("Ingrese 1 para ingresar o -1 para salir de la red totalmente.");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese su identificador a continuacion: ");
                        contraseña = sc.next();
                        sesionActual = instant.recuperarValor(contraseña);

                        System.out.println();
                        System.out.println("Se ha iniciado sesion correctamente.");
                        System.out.println();
                        System.out.println("Bienvenido" + sesionActual.getNombre());
                        break;

                    case -1:
                        System.out.println("Saliendo.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            }
            else {
            }
        }while (opcion != -1);
    }
}
