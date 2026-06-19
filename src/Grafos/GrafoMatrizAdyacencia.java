package Grafos;

public class GrafoMatrizAdyacencia implements IGrafo {

    private Usuario[] vertices;
    private int[][] matriz;
    private int cantidad;
    private int capacidad;
    private boolean dirigido;


    public GrafoMatrizAdyacencia(int capacidad, boolean dirigido) {
        this.capacidad = capacidad;
        this.dirigido = dirigido;
        this.cantidad = 0;

        this.vertices = new Usuario[capacidad];
        this.matriz = new int[capacidad][capacidad];
    }

    @Override
    public void insertarVertice(Usuario vertice) {
        if (cantidad == capacidad) {
            System.out.println("No se pueden insertar más vértices.");
            return;
        }

        if (existeVertice(vertice)) {
            System.out.println("El vértice ya existe.");
            return;
        }

        vertices[cantidad] = vertice;
        cantidad++;
    }

    @Override
    public boolean existeVertice(Usuario vertice) {
        return obtenerIndice(vertice) != -1;
    }

    private int obtenerIndice(Usuario vertice) {
        for (int i = 0; i < cantidad; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertarArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);
        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los vértices no existe.");
            return;
        }

        matriz[posOrigen][posDestino] = 1;

        if (!dirigido) {
            matriz[posDestino][posOrigen] = 1;
        }
    }

    @Override
    public void eliminarArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los vértices no existe.");
            return;
        }

        matriz[posOrigen][posDestino] = 0;

        if (!dirigido) {
            matriz[posDestino][posOrigen] = 0;
        }
    }

    @Override
    public boolean existeArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }

        return matriz[posOrigen][posDestino] == 1;
    }

    @Override
    public void eliminarVertice(Usuario vertice) {
        int pos = obtenerIndice(vertice);

        if (pos == -1) {
            System.out.println("El vértice no existe.");
            return;
        }

        for (int i = pos; i < cantidad - 1; i++) {
            vertices[i] = vertices[i + 1];
        }

        for (int i = pos; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad; j++) {
                matriz[i][j] = matriz[i + 1][j];
            }
        }

        for (int j = pos; j < cantidad - 1; j++) {
            for (int i = 0; i < cantidad; i++) {
                matriz[i][j] = matriz[i][j + 1];
            }
        }

        cantidad--;

        vertices[cantidad] = null;

        for (int i = 0; i < capacidad; i++) {
            matriz[cantidad][i] = 0;
            matriz[i][cantidad] = 0;
        }
    }

    @Override
    public void mostrarVertices() {
        System.out.println("Vértices:");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i].nombre + " ");
        }

        System.out.println();
    }

    @Override
    public void dfs(Usuario primero) {
        int posicionInicial = obtenerIndice(primero);
        if (posicionInicial == -1) {
            System.out.println("El usuario no existe");
            return;
        }

        boolean[] passed = new boolean[cantidad];

        dfsRec(posicionInicial, passed);
    }

    public void dfsRec(int pos, boolean[] passed) {
        passed[pos] = true;
        System.out.println(vertices[pos].nombre);

        for (int i = 0; i < cantidad; i++) {
            if (matriz[pos][i] == 1 && !passed[i]) {
                dfsRec(i, passed);
            }
        }
    }

    @Override
    public void bfs(Usuario primero) {
        /*
        boolean[] passed = new boolean[cantidad];
        int posInicial = obtenerIndice(primero);

        Cola laCola = new Cola(cantidad);
        passed[posInicial] = true;
        laCola.encolar(posInicial);
        */
    }


    @Override
    public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia:");

        System.out.print("   ");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i].nombre + " ");
        }

        System.out.println();

        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i].nombre + "  ");

            for (int j = 0; j < cantidad; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }

    @Override
    public Usuario devolverVertice(int actual) {
        if (actual < 0 || actual >= cantidad) {
            return null;
        }
        return vertices[actual];
    }
    public void buscarUsuariosPorFiltro(String criterio, boolean esPorFormacion) {
        System.out.println("\n--- RESULTADOS DE BÚSQUEDA ---");
        boolean encontrado = false;

        for (int i = 0; i < cantidad; i++) {
            Usuario usr = vertices[i];

            if (usr.getEmpleador()) {
                continue;
            }

            boolean cumpleCondicion = false;

            if (esPorFormacion) {
                if (usr.getFormaciones() != null) {
                    String formacionesTexto = usr.getFormaciones().toString().toLowerCase();
                    if (formacionesTexto.contains(criterio.toLowerCase())) {
                        cumpleCondicion = true;
                    }
                }
            } else {
                if (usr.getTitulo() != null) {
                    String tituloTexto = usr.getTitulo().toString().toLowerCase();
                    if (tituloTexto.contains(criterio.toLowerCase())) {
                        cumpleCondicion = true;
                    }
                }
            }

            if (cumpleCondicion) {
                System.out.println("Nombre: " + usr.getNombre());
                System.out.println("Tipo: " + (esPorFormacion ? "Formación/Aptitud" : "Título"));
                System.out.println("---------------------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron usuarios con el criterio: " + criterio);
        }

    }
}



