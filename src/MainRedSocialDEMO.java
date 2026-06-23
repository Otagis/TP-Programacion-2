import Conjuntos.Conjunto;
import Diccionari.DictStr;
import GrafosLista.GrafoLista;
import GrafosLista.Igrafo;
import GrafosLista.Usuario;
import ColaCircular.GestionEmpleo;
import java.util.Scanner;

public class MainRedSocialDEMO{
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

        Scanner sc = new Scanner(System.in);

        Usuario sesionActual = null;
        int opcion = 0;
        String contraseña;
        boolean iniciarsesion = false;
        String Tformaciones;
        String continuar = "S";

        int decision = 0;
        int maximo = 0;
        Object trabajador = "";
        String lectura = "S";


        do {

            System.out.println("  _____                             \n" +
                    " |  __ \\                            \n" +
                    " | |__) |___  ___ _ __ _____      __\n" +
                    " |  _  // _ \\/ __| '__/ _ \\ \\ /\\ / /\n" +
                    " | | \\ \\  __/ (__| | |  __/\\ V  V / \n" +
                    " |_|  \\_\\___|\\___|_|  \\___| \\_/\\_(_)");
            System.out.println();
            System.out.println("Red social de reclutamiento de profesionales.");

            if (!iniciarsesion){
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("-------------------------------PAGINA PRINCIPAL------------------------------");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println();
                System.out.println(" 1. Iniciar sesion");
                System.out.println(" 2. Registrarse");
                System.out.println(" 3. Informacion");
                System.out.println();
                System.out.println(" -1. Salir");


                opcion = sc.nextInt();
                switch (opcion) {

                    case 1:
                        System.out.print("Ingrese su ID a continuacion: ");
                        contraseña = sc.next();
                        sesionActual = instant.recuperarValor(contraseña);

                        if (sesionActual != null) {
                            System.out.println();
                            System.out.println("Se ha iniciado sesion correctamente.");
                            System.out.println();
                            System.out.println("Bienvenido " + sesionActual.getNombre());
                            iniciarsesion = true;
                        }else {
                            System.out.println("No se ha iniciado sesion correctamente.");
                        }

                        break;

                    case 2:
                        System.out.println("Ingrese sus datos");
                        System.out.println("Si usted es un usuario corriente, ingrese solo sus datos");
                        System.out.println("Si pertenece a una empresa y desea registrarse para usar las funciones de empleador, ingrese el codigo de empleador.");
                        System.out.println("La opcion aparecera despues de ingresar nombre y contrasena");
                        System.out.println();
                        System.out.print("Ingrese su nombre: ");
                        nombre = sc.next();
                        System.out.println();
                        System.out.print("Ingrese su ID: ");
                        contrasena = sc.next();
                        System.out.println();
                        System.out.println("Usted es un empleador?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        opc_empleador = sc.nextInt();

                        if (opc_empleador == 1){
                            System.out.println("Ingrese su codigo de empleador");
                            codigo = sc.nextInt();
                            while ((codigo != codigo_empleador)){

                                System.out.println("Codigo equivocado, vuelva a intentarlo");

                            }
                            Conjunto nuevo = new Conjunto(3);
                            Usuario nuevo_usuario = new Usuario(nombre, contrasena, new Conjunto(3), true, nuevo);

                            red.insertarVertice(nuevo_usuario);

                            instant.insertar(nuevo_usuario.getContraseña(), nuevo_usuario);

                            break;

                        }
                        else{
                            System.out.println("Usuario creado");
                            Conjunto nuevo = new Conjunto(3);
                            Usuario nuevo_usuario = new Usuario(nombre, contrasena, new Conjunto(3), false, nuevo);

                            red.insertarVertice(nuevo_usuario);
                            instant.insertar(nuevo_usuario.getContraseña(), nuevo_usuario);

                            break;
                        }



                    case -1:
                        System.out.println("Saliendo.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            }
            else if (sesionActual.getEmpleador()){

                System.out.println("====================================================================================");
                System.out.println("========================Gestion de cuenta de empleador==============================");
                System.out.println("====================================================================================");
                System.out.println();
                System.out.println("1. Agregar propuesta");
                System.out.println("2. Ver puestos para la propuesta");
                System.out.println("3. Buscar usuarios");
                System.out.println("4. Agregar amigo");
                System.out.println("5. Eliminar amigo");
                System.out.println("6. Ver amigos");
                System.out.println();
                System.out.println("-1  Para cerrar sesion");

                opcion = sc.nextInt();
                switch (opcion) {
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
                            while (!lectura.equals("N")) {
                                Usuario usr = (Usuario) trabajador;

                                System.out.println("Caracteristicas del usuario: ");
                                System.out.println("Nombre: " + usr.getNombre());
                                System.out.println("Formaciones/Aptitudes: " + usr.getFormaciones());
                                System.out.println("------------------------------------------------");
                                System.out.println("Desea seguir viendo a los demas trabajadores? (S/N):");
                                lectura = sc.nextLine();
                            }

                        } else {
                            System.out.println("No hay más postulantes en la cola.");
                        }
                        break;

                    case 3:
                        System.out.println("¿Qué tipo de búsqueda desea realizar?");
                        System.out.println("1. Buscar por Formación/Aptitud");
                        System.out.println("2. Buscar por Título");
                        int tipoBusqueda = sc.nextInt();

                        System.out.print("Ingrese la palabra clave exacta a buscar (Ej: Python, ingInf): ");
                        String palabraClave = sc.next();

                        if (tipoBusqueda == 1) {
                            red.buscarUsuariosPorFiltro(palabraClave, true);
                        } else if (tipoBusqueda == 2) {
                            red.buscarUsuariosPorFiltro(palabraClave, false);
                        } else {
                            System.out.println("Opción de búsqueda no válida.");
                        }
                        break;

                    case 4:
                        System.out.println("Ingrese el nombre del usuario al que quiere agregar como amigo: ");
                        System.out.println();
                        String nomb = sc.next();
                        Usuario agregar = red.buscarPorNombre(nomb);
                        if (agregar != null && !red.existeArista(sesionActual, agregar)) {
                            red.insertarArista(sesionActual, agregar);
                            System.out.println("Se ha agregado al usuario: " + agregar.getNombre());
                        }
                        else if (red.existeArista(sesionActual, agregar)){
                            System.out.println("Ya son amigos");
                        }
                        else {
                            System.out.println("No se ha encontrado al usuario");
                        }
                        break;

                    case 5:
                        System.out.println("Ingrese el nombre del usuario al que quiere eliminar como amigo: ");
                        System.out.println();
                        String nomb2 = sc.next();
                        Usuario eliminar = red.buscarPorNombre(nomb2);
                        if (eliminar != null && red.existeArista(sesionActual, eliminar)) {
                            red.eliminarArista(sesionActual, eliminar);
                            System.out.println("Se ha eliminado al usuario: " + eliminar.getNombre());
                        }
                        else if (!red.existeArista(sesionActual, eliminar)){
                            System.out.println("No es amigo de " +eliminar.getNombre());
                        }
                        else {
                            System.out.println("No se ha encontrado al usuario");
                        }

                        break;


                    case 6:
                        red.mostrarAristadeUsuario(sesionActual);
                        break;


                    case -1:
                        System.out.println("Cerrando sesion correctamente.");
                        iniciarsesion = false;
                        opcion = 0;
                        break;

                    default:
                        System.out.println("opcion no valida.");
                        break;
                }
            }
            else {
                System.out.println("====================================================================================");
                System.out.println("=========================Gestion de cuenta de empleado==============================");
                System.out.println("====================================================================================");
                System.out.println();
                System.out.println("1. Para ingresar sus formaciones");
                System.out.println("2. Para buscar usuarios");
                System.out.println("3. Ver propuestas y anotarse");
                System.out.println("4. Modificar perfil");
                System.out.println("5. Agregar amigo");
                System.out.println("6. Eliminar amigo");
                System.out.println("7. Ver amigos");
                System.out.println();
                System.out.println("-1  Para cerrar sesion");
                opcion = sc.nextInt();
                switch (opcion) {
                    case -1:
                        System.out.println("cerrando sesion correctamente.");
                        iniciarsesion = false;
                        opcion = 0;
                        break;
                    case 1:
                        System.out.println("Ingrese sus Formaciones limite 10.");
                        Conjunto Formaciones = new Conjunto(10);


                        while (!continuar.equals("N")){
                            Tformaciones = sc.next();
                            System.out.println("Tformacion ->"+Tformaciones);
                            Formaciones.insertar(Tformaciones);
                            System.out.println("Formacion ingresada correctamente. ");
                            System.out.println("Desea continuar agregando Formaciones? (S/N)");
                            continuar = sc.next();

                            if (Formaciones.estaLleno()){
                                System.out.println("Limite de formaciones.");
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("¿Qué tipo de búsqueda desea realizar?");
                        System.out.println();
                        System.out.println("1. Buscar por Formación/Aptitud");
                        System.out.println("2. Buscar por Título");
                        System.out.println("3. Mostrar recomendaciones");
                        System.out.println("4. Buscar por nombre");
                        System.out.println();
                        int tipoBusqueda = sc.nextInt();
                        String palabraClave;

                        if (tipoBusqueda == 1) {
                            System.out.print("Ingrese la palabra clave exacta a buscar (Ej: Python, ingInf): ");
                            palabraClave = sc.next();
                            red.buscarUsuariosPorFiltro(palabraClave, true);
                        } else if (tipoBusqueda == 2) {
                            System.out.print("Ingrese la palabra clave exacta a buscar (Ej: Python, ingInf): ");
                            palabraClave = sc.next();
                            red.buscarUsuariosPorFiltro(palabraClave, false);
                        } else if (tipoBusqueda == 3) {
                            red.sugerencias(sesionActual);
                        } else {
                            System.out.println("Opción de búsqueda no válida.");
                        }
                        break;
                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        System.out.println("Ingrese el nombre del usuario al que quiere agregar como amigo: ");
                        System.out.println();
                        String nomb = sc.next();
                        Usuario agregar = red.buscarPorNombre(nomb);
                        if (agregar != null && !red.existeArista(sesionActual, agregar)) {
                            red.insertarArista(sesionActual, agregar);
                            System.out.println("Se ha agregado al usuario: " + agregar.getNombre());
                        }
                        else if (red.existeArista(sesionActual, agregar)){
                            System.out.println("Ya son amigos");
                        }
                        else {
                            System.out.println("No se ha encontrado al usuario");
                        }
                        break;

                    case 6:
                        System.out.println("Ingrese el nombre del usuario al que quiere eliminar de amigos: ");
                        System.out.println();
                        String nomb2 = sc.next();
                        Usuario eliminar = red.buscarPorNombre(nomb2);
                        if (eliminar != null && red.existeArista(sesionActual, eliminar)) {
                            red.eliminarArista(sesionActual, eliminar);
                            System.out.println("Se ha eliminado al usuario: " + eliminar.getNombre());
                        }
                        else if (!red.existeArista(sesionActual, eliminar)){
                            System.out.println("No es amigo de " +eliminar.getNombre());
                        }
                        else {
                            System.out.println("No se ha encontrado al usuario");
                        }

                        break;

                    case 7:
                        red.mostrarAristadeUsuario(sesionActual);
                        break;
                }

            }

        }while (opcion != -1);
    }
}
