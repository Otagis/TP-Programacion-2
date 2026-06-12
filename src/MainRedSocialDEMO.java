import Conjuntos.Conjunto;
import Diccionari.DictStr;
import Grafos.GrafoMatrizAdyacencia;
import Grafos.IGrafo;
import Grafos.Usuario;

import java.util.Scanner;

public class MainRedSocialDEMO{
    public static void main(String[] args) {
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

        Usuario maxi = new Usuario("Maxi", "12345", new Conjunto(3),true );
        Usuario bruno = new Usuario("Bruno", "kactus", a, false);
        Usuario ramiro = new Usuario("Ramiro", "jhonson", b,false);

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
        boolean iniciarsesion = false;
        String Tformaciones;
        String continuar = "S";


        System.out.println("Hola bienvenido a [INSERTAR_NOMBRE_DE_RED_SOCIAL_GENERICA].");
        System.out.println();

        do {
            if (!iniciarsesion){
                System.out.println("Ingrese 1 para ingresar la cuenta o -1 " + "para salir de la red totalmente.");
                opcion = sc.nextInt();
                switch (opcion) {

                    case 1:
                        System.out.print("Ingrese su contraseña a continuacion: ");
                        contraseña = sc.next();
                        sesionActual = instant.recuperarValor(contraseña);

                        System.out.println();
                        System.out.println("Se ha iniciado sesion correctamente.");
                        System.out.println();
                        System.out.println("Bienvenido" + sesionActual.getNombre());
                        iniciarsesion = true;


                        break;



                    case -1:
                        System.out.println("Saliendo.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            }
            else if (sesionActual.getEmpleador()){
                System.out.print("Gestion de cuenta de empleador: ");
                System.out.println("1 para cerrar sesion correctamente.");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("cerrando sesion correctamente.");
                        iniciarsesion = false;
                        break;



                }
            }
            else {
                System.out.println("Gestion de cuenta de empleado: ");
                System.out.println("1 para cerrar sesion correctamente.");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("cerrando sesion correctamente.");
                        iniciarsesion = false;
                        break;
                    case 2:
                        System.out.println("Ingrese sus Formaciones limite 10.");
                        Conjunto Formaciones = new Conjunto(10);


                        while ( !continuar.equals("N")){
                            Tformaciones = sc.next();
                            System.out.println("Tformacion ->"+Tformaciones);
                            Formaciones.insertar(Tformaciones);
                            System.out.println("Formacion ingresada correctamente. ");
                            System.out.println("Desea continuar agregando Formaciones? (S/N)");
                            continuar = sc.nextLine();

                                ;
                            if (Formaciones.estaLleno()){
                                break;
                            }
                        }break;




                        /*}while (!Formaciones.estaLleno());
                        break;*/





                }

            }

        }while (opcion != -1);
    }
}
