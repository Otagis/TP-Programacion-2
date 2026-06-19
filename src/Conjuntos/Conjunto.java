package Conjuntos;

public class Conjunto implements ICOnjunto {

    private String[] datos;
    private int cantidad;
    private int dimension;


    public Conjunto(int dimension){
        this.dimension = dimension;
        datos = new String[dimension];
        cantidad = 0;
    }

    @Override
    public boolean estaVacio() {
        if (cantidad == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean estaLleno() {
        if (cantidad == dimension) {
            return true;
        }
        else
            return false;
    }

    @Override
    public void insertar(String elemento) {
        if(estaLleno()){
            System.out.println("Canjunto lleno --> No es posible agregar el elemento --> " + elemento);
            System.out.println("------------------------");
            return;
        }
        if (pertenece(elemento) == -1) {
            datos[cantidad] = elemento;
            cantidad++;
        }
        else{
            System.out.println("Ya existe el " + elemento);
            System.out.println("-------------------------");

    }
}
    @Override
    public void eliminar(String elemento) {
        int posicion = pertenece(elemento);
        if(posicion != -1){
            for (int i = posicion; i <= cantidad; i++){
                datos[i] = datos[i+1];
            }
            cantidad--;
        }
        else {
            System.out.println("El elemento no existe");
            System.out.println("------------------------");
        }

}

    @Override
    public int pertenece(String elemento) {
        for (int i = 0; i<cantidad;i++) {
            if (datos[i] == elemento) {
                return i;
            }
        }
        return -1;
    }



    @Override
    public int tamanio() {
        return cantidad;

    }

    @Override
    public void mostrar() {
        for (int i = 0; i< cantidad; i++){
            System.out.print(datos[i] + " - ");
        }
        System.out.println();

    }

    @Override
    public ICOnjunto union(Conjunto conjuntoB) {
        int max = this.cantidad + conjuntoB.cantidad;
        Conjunto conjuntounion = new Conjunto(max);
        for(int i = 0; i< cantidad; i++){
            conjuntounion.insertar(datos[i]);
        }
        for (int j = 0; j < conjuntoB.cantidad; j++){
            conjuntounion.insertar(conjuntoB.datos[j]);
        }
        System.out.println("Union de temas....");
        conjuntounion.mostrar();
        return conjuntounion;
}

    @Override
    public Conjunto interseccion(Conjunto conjuntoB) {
        int nuevaDimension = Math.min(cantidad, conjuntoB.cantidad) ;
        Conjunto conjuntointerseccion = new Conjunto(nuevaDimension);
        int j = 0;
        for(int i=0; i < cantidad ; i++){
            if (conjuntoB.pertenece(datos[i]) != -1){
                conjuntointerseccion.insertar(datos[i]);
            }
        }
        System.out.println("Temas en comun...");
        conjuntointerseccion.mostrar();
        return conjuntointerseccion;
}

    @Override
    public Conjunto diferencia(Conjunto conjuntoB) {
        int nuevaDimension = Math.max(cantidad, conjuntoB.cantidad);
        Conjunto conjuntoDiferencia = new Conjunto(nuevaDimension);

        for (int i = 0; i < cantidad; i++) {
            if (conjuntoB.pertenece(datos[i]) == -1) {
                conjuntoDiferencia.insertar(datos[i]);
            }
        }
        System.out.println("Temas que A tiene y B no ...");
        conjuntoDiferencia.mostrar();
        return conjuntoDiferencia;
    }
}
