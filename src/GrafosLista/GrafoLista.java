package GrafosLista;

public class GrafoLista implements Igrafo {

    private NodoVertice primero;
    private boolean dirigido;

    public GrafoLista(boolean dirigido) {
        this.primero = null;
        this.dirigido = dirigido;
    }

    @Override
    public void insertarVertice(Usuario dato) {
        if (existeVertice(dato)) {
            return;
        }

        NodoVertice nuevo = new NodoVertice(dato);

        if (primero == null) {
            primero = nuevo;
        } else {
            NodoVertice aux = primero;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }
    }

    @Override
    public boolean existeVertice(Usuario dato) {
        return buscarVertice(dato) != null;
    }

    private NodoVertice buscarVertice(Usuario dato) {
        NodoVertice aux = primero;

        while (aux != null) {
            if (aux.dato.equals(dato)) {
                return aux;
            }

            aux = aux.siguiente;
        }

        return null;
    }

    @Override
    public void insertarArista(Usuario origen, Usuario destino) {
        insertarVertice(origen);
        insertarVertice(destino);

        agregarAdyacente(origen, destino);

        if (!dirigido) {
            agregarAdyacente(destino, origen);
        }
    }

    private void agregarAdyacente(Usuario origen, Usuario destino) {
        NodoVertice verticeOrigen = buscarVertice(origen);

        if (verticeOrigen == null) {
            return;
        }

        if (existeArista(origen, destino)) {
            return;
        }

        NodoAdyacente nuevo = new NodoAdyacente(destino);

        if (verticeOrigen.adyacentes == null) {
            verticeOrigen.adyacentes = nuevo;
        } else {
            NodoAdyacente aux = verticeOrigen.adyacentes;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }
    }

    @Override
    public boolean existeArista(Usuario origen, Usuario destino) {
        NodoVertice verticeOrigen = buscarVertice(origen);

        if (verticeOrigen == null) {
            return false;
        }

        NodoAdyacente aux = verticeOrigen.adyacentes;

        while (aux != null) {
            if (aux.dato.equals(destino)) {
                return true;
            }

            aux = aux.siguiente;
        }

        return false;
    }

    @Override
    public void eliminarArista(Usuario origen, Usuario destino) {
        quitarAdyacente(origen, destino);

        if (!dirigido) {
            quitarAdyacente(destino, origen);
        }
    }

    private void quitarAdyacente(Usuario origen, Usuario destino) {
        NodoVertice verticeOrigen = buscarVertice(origen);

        if (verticeOrigen == null || verticeOrigen.adyacentes == null) {
            return;
        }

        NodoAdyacente actual = verticeOrigen.adyacentes;
        NodoAdyacente anterior = null;

        while (actual != null) {
            if (actual.dato.equals(destino)) {
                if (anterior == null) {
                    verticeOrigen.adyacentes = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }

            anterior = actual;
            actual = actual.siguiente;
        }
    }

    @Override
    public void eliminarVertice(Usuario dato) {
        if (primero == null) {
            return;
        }

        NodoVertice actual = primero;
        NodoVertice anterior = null;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                if (anterior == null) {
                    primero = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }

                eliminarReferencias(dato);
                return;
            }

            anterior = actual;
            actual = actual.siguiente;
        }
    }

    private void eliminarReferencias(Usuario dato) {
        NodoVertice aux = primero;

        while (aux != null) {
            quitarAdyacente(aux.dato, dato);
            aux = aux.siguiente;
        }
    }

    @Override
    public void mostrarGrafo() {
        NodoVertice aux = primero;

        while (aux != null) {
            System.out.print(aux.dato.nombre + " -> ");

            NodoAdyacente ady = aux.adyacentes;

            while (ady != null) {
                System.out.print(ady.dato.nombre + " ");
                ady = ady.siguiente;
            }

            System.out.println();
            aux = aux.siguiente;
        }
    }

    public void mostrarAristadeUsuario(Usuario usuario) {
        NodoVertice vertice = buscarVertice(usuario);

        if (vertice == null) {
            System.out.println("El usuario " + usuario.getNombre() + " no existe en el grafo.");
        }
        System.out.println("--------------------------------------");

        System.out.println("Amigos de: " + usuario.getNombre());
        NodoAdyacente nodoAdyacente = vertice.adyacentes;

        if (nodoAdyacente == null){
            System.out.println("El usuario " + usuario.getNombre() + " no tiene amigos.");
            return;
        }
        while (nodoAdyacente != null) {
            System.out.print(nodoAdyacente.dato.nombre + ",");
            nodoAdyacente = nodoAdyacente.siguiente;
        }
        System.out.println(" ");
        System.out.println("--------------------------------------");

    }

    private void limpiarVisitados() {
        NodoVertice aux = primero;

        while (aux != null) {
            aux.visitado = false;
            aux = aux.siguiente;
        }
    }

    @Override
    public void recorridoDFS(Usuario inicio) {
        limpiarVisitados();

        NodoVertice verticeInicio = buscarVertice(inicio);

        if (verticeInicio == null) {
            System.out.println("El vértice inicial no existe.");
            return;
        }

        System.out.println("Recorrido DFS:");
        dfsRecursivo(verticeInicio);
        System.out.println();
    }

    private void dfsRecursivo(NodoVertice vertice) {
        vertice.visitado = true;
        System.out.print(vertice.dato.nombre + " ");

        NodoAdyacente ady = vertice.adyacentes;

        while (ady != null) {
            NodoVertice vecino = buscarVertice(ady.dato);

            if (vecino != null && !vecino.visitado) {
                dfsRecursivo(vecino);
            }

            ady = ady.siguiente;
        }
    }

    @Override
    public void recorridoBFS(Usuario inicio) {
        limpiarVisitados();

        NodoVertice verticeInicio = buscarVertice(inicio);

        if (verticeInicio == null) {
            System.out.println("El vértice inicial no existe.");
            return;
        }

        ColaPropia cola = new ColaPropia();

        verticeInicio.visitado = true;
        cola.encolar(verticeInicio);

        System.out.println("Recorrido BFS:");

        while (!cola.estaVacia()) {
            NodoVertice actual = cola.desencolar();
            System.out.print(actual.dato.nombre + " ");

            NodoAdyacente ady = actual.adyacentes;

            while (ady != null) {
                NodoVertice vecino = buscarVertice(ady.dato);

                if (vecino != null && !vecino.visitado) {
                    vecino.visitado = true;
                    cola.encolar(vecino);
                }

                ady = ady.siguiente;
            }
        }

        System.out.println();
    }

    @Override
    public void buscarUsuariosPorFiltro(String criterio, boolean esPorFormacion){
        System.out.println("--- RESULTADOS DE BÚSQUEDA ---");
        boolean encontrado = false;

        NodoVertice aux = primero;

        while (aux != null){
            Usuario usr = aux.dato;

            if (!usr.getEmpleador()){
                boolean cumpleCondicion = false;

                if (esPorFormacion) {
                    if (usr.getFormaciones() != null) {
                        if (usr.formaciones.pertenece(criterio) != -1){
                            cumpleCondicion = true;
                        }
                    }
                } else {
                    if (usr.getTitulo() != null) {
                        if (usr.titulo.pertenece(criterio) != -1){
                            cumpleCondicion = true;
                        }
                    }
                }
                if (cumpleCondicion){
                    System.out.println("Nombre: " + usr.getNombre());
                    System.out.println("Tipo: " + (esPorFormacion ? "Formación/Aptitud" : "Título"));
                    System.out.println("---------------------------------");
                    encontrado = true;
                }
            }

            aux = aux.siguiente;
        }

        if (!encontrado){
            System.out.println("No se encontraron usuarios con el criterio: " + criterio);
        }

    }

    public Usuario buscarPorNombre(String nomb){
        NodoVertice aux = primero;

        while (aux != null) {
            if (aux.dato.getNombre().equalsIgnoreCase(nomb)) {
                return aux.dato;
            }

            aux = aux.siguiente;
        }
        return null;
    }

    public void sugerencias(Usuario inicio){
        limpiarVisitados();
        NodoVertice verticeInicio = buscarVertice(inicio);

        if (verticeInicio == null) {
            System.out.println("El vértice inicial no existe.");
            return;
        }

        verticeInicio.visitado = true;

        NodoAdyacente ady = verticeInicio.adyacentes;

        while (ady != null){
            NodoVertice vecino = buscarVertice(ady.dato);

            if (vecino != null){
                vecino.visitado = true;
            }

            ady = ady.siguiente;
        }

        ady = verticeInicio.adyacentes;

        while (ady != null){
            NodoVertice vecino = buscarVertice(ady.dato);

            if (vecino != null){
                NodoAdyacente amiDeAmi = vecino.adyacentes;

                while (amiDeAmi != null){
                    NodoVertice cand = buscarVertice(amiDeAmi.dato);

                    if (cand != null && !cand.visitado){
                        System.out.println(cand.dato.nombre);
                        cand.visitado = true;
                    }

                    amiDeAmi = amiDeAmi.siguiente;
                }
            }

            ady = ady.siguiente;
        }
    }

}