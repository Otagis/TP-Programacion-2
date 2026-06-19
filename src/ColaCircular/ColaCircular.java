package ColaCircular;

public class ColaCircular implements IColaCircular {
    private String[] datos;
    private int frente;
    private int fin;
    private int cantidad;
    private int max;
    private String aux;
    private String eliminado;

    // constructor
    public ColaCircular(int max) {
        this.fin = -1;
        this.datos = new String[max];
        this.frente = 0;
        this.max = max;
        this.cantidad = 0;
    }

    public void inicializarCola() {
        frente = -1;
        fin = -1 ;

    }

    @Override
    public boolean encolar(String elemento) {
        if(estaLlena()){
            System.out.println("Error, la Cola esta llena");
        }
        else {
            fin = (fin + 1) % max;
            datos[fin] = elemento;
            cantidad = cantidad + 1;
            System.out.println("Elemento " + elemento + "agregado");
        }

        return false;
    }

    @Override
    public Object desencolar() {
        if (estaVacia()){
            System.out.println("Error, la cola esta vacia");
            return null;
        }
        eliminado = datos[frente];
        if (frente == fin){
            frente = -1;
            fin = -1;
            cantidad = 0;
        }
        else{
            frente = (frente + 1) % max;
            cantidad = cantidad -1;
        }

        System.out.println("Usuario actual ---->" + eliminado);

        return eliminado;
    }

    @Override
    public boolean estaLlena() {
        if (cantidad == max) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean estaVacia() {
        if (cantidad == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int mostrar() {
        System.out.println("Datos de la cola --> " + datos);
        return 0;
    }

    @Override
    public String recuperarFrente() {
        if (estaVacia()){
            System.out.println("Error, la cola esta vacia");
        }
        else{
            return aux = datos[frente];
        }
        System.out.println("El dato al frente es ----->" + aux);
        return aux;
    }
    @Override
    public String frente() {
        if (estaVacia()){
            System.out.println("Error, la cola esta vacia");
            return "";
        }
        else{
            return datos[frente];
        }
    }

}
