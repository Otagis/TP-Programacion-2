import Conjuntos.Conjunto;
import Diccionari.DictStr;
import Grafos.GrafoMatrizAdyacencia;
import Grafos.IGrafo;
import Grafos.Usuario;
import ColaCircular.GestionEmpleo;
import java.util.Scanner;

public class MainRedSocialDEMO{
    public static void main(String[] args) {
        DictStr instant = new DictStr(3);
        IGrafo<Usuario> red = new GrafoMatrizAdyacencia(3, false);

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


        System.out.println("Hola bienvenido a [INSERTAR_NOMBRE_DE_RED_SOCIAL_GENERICA].");
        System.out.println();

        do {
            if (!iniciarsesion){
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("---------------------------------LOG IN--------------------------------------");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(" ");
                System.out.println(" 1. Ingresar");
                System.out.println(" 2. Registrarse");
                System.out.println("-1. Cerrar sesion");


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
                            System.out.println("Bienvenido" + sesionActual.getNombre());
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
                        System.out.println(" ");
                        System.out.print("Ingrese su nombre: ");
                        nombre = sc.nextLine();
                        System.out.println(" ");
                        System.out.print("Ingrese su contrasena");
                        contrasena = sc.nextLine();
                        System.out.println(" ");
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
                System.out.println(" ");
                System.out.println("1  Para cerrar sesion correctamente");
                System.out.println("2. Agregar propuesta");
                System.out.println("3. Ver puestos para la propuesta");
                System.out.println("4. Buscar usuarios");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Cerrando sesion correctamente.");
                        iniciarsesion = false;
                        break;

                    case 2:
                        System.out.println("Por favor, ingrese la cantidad maxima de solicitudes de empleo que desea habilitar:");
                        maximo = sc.nextInt();


                        GestionEmpleo.inicializarCola(maximo);


                        System.out.println("Propuesta iniciada con límite de " + maximo + " postulantes.");
                        break;

                    case 3:
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

                    case 4:
                        System.out.println("¿Qué tipo de búsqueda desea realizar?");
                        System.out.println("1. Buscar por Formación/Aptitud");
                        System.out.println("2. Buscar por Título");
                        int tipoBusqueda = sc.nextInt();

                        System.out.print("Ingrese la palabra clave exacta a buscar (Ej: Python, ingInf): ");
                        String palabraClave = sc.next();

                        GrafoMatrizAdyacencia miGrafo = (GrafoMatrizAdyacencia) red;

                        if (tipoBusqueda == 1) {
                            miGrafo.buscarUsuariosPorFiltro(palabraClave, true);
                        } else if (tipoBusqueda == 2) {
                            miGrafo.buscarUsuariosPorFiltro(palabraClave, false);
                        } else {
                            System.out.println("Opción de búsqueda no válida.");
                        }
                        break;


                    default:
                        System.out.println("opcion no valida.");
                        break;
                }
            }
            else {
                System.out.println("Gestion de cuenta de empleado: ");
                System.out.println("1  Para cerrar sesion correctamente");
                System.out.println("2. Para ingresar sus formaciones");
                System.out.println("3. Para buscar usuarios");
                System.out.println("4. Ver propuestas y anotarse");
                System.out.println("5. Modificar perfil");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("cerrando sesion correctamente.");
                        iniciarsesion = false;
                        break;
                    case 2:
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
                    case 3:
                        System.out.println("¿Qué tipo de búsqueda desea realizar?");
                        System.out.println("1. Buscar por Formación/Aptitud");
                        System.out.println("2. Buscar por Título");
                        int tipoBusqueda = sc.nextInt();

                        System.out.print("Ingrese la palabra clave exacta a buscar (Ej: Python, ingInf): ");
                        String palabraClave = sc.next();

                        GrafoMatrizAdyacencia miGrafo = (GrafoMatrizAdyacencia) red;

                        if (tipoBusqueda == 1) {
                            miGrafo.buscarUsuariosPorFiltro(palabraClave, true);
                        } else if (tipoBusqueda == 2) {
                            miGrafo.buscarUsuariosPorFiltro(palabraClave, false);
                        } else {
                            System.out.println("Opción de búsqueda no válida.");
                        }
                        break;

                }

            }

        }while (opcion != -1);
    }
}
