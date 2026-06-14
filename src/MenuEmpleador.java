import ColaCircular.GestionEmpleo;
import Grafos.Usuario;

import java.util.Scanner;
public class MenuEmpleador {
    public static void main() {
        int decision = 0;
        int maximo = 0;
        Object trabajador = "";
        String lectura = "S";
        Scanner sc = new Scanner(System.in);

        while (decision != -1){
            System.out.println("===================EMPLEADOR===================");

            System.out.println("Que desea hacer?");
            System.out.println("1. Agregar propuesta");
            System.out.println("2. Ver propuestas");
            decision = sc.nextInt();


            switch (decision) {
                case 1:

                    System.out.println("Por favor, ingrese la cantidad maxima de solicitudes de empleo que desea habilitar:");
                    maximo = sc.nextInt();


                    GestionEmpleo.inicializarCola(maximo);

                    System.out.println("Propuesta iniciada con límite de " + maximo + " postulantes.");
                    break;

                case 2:

                    if (!GestionEmpleo.existeOferta()) {
                        System.out.println("Error: Primero debe crear una propuesta en la opción 1.");
                        break;
                    }

                    trabajador = GestionEmpleo.desencolarPostulante();

                    if (trabajador != null) {
                        while (lectura.equals("N")) {
                            Usuario usr = (Usuario) trabajador;

                            System.out.println("Caracteristicas del usuario: ");
                            System.out.println("Nombre: " + usr.getNombre());
                            System.out.println("Formaciones/Aptitudes: " + usr.getFormaciones());
                            System.out.println("------------------------------------------------");
                            System.out.println("Desea seguir viendo a los demas trabajadores? (S/N):");
                            lectura = sc.nextLine();

                            if (lectura.equals("N")) {
                                System.out.println("Saliendo...");
                                break;
                            }

                        }

                    } else {
                        System.out.println("No hay más postulantes en la cola.");
                    }
                    break;
            }
        }
    }

}
