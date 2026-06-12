package Grafos;

public class Cola implements ICola {
    private int principio;
    private int fin;
    private  int[] datos;
    private  int max;

    public Cola(int max){
        this.max = max;
        this.datos = new int[max];
        this.principio = -1;
        this.fin = -1;
    }

    @Override
    public void encolar(int elemento) {
        if(estaLlena()){
            System.out.println("Esta lleno");
            return;
        }
        else if (estaVacia()) {
            principio = 0;
            fin = 0;
        }
        else{
            fin++;
        }
        datos[fin] = elemento;
        System.out.println(elemento + " Encolado");
    }

    @Override
    public int desencolar() {
        if (estaVacia()){
            System.out.println("Esta Vacia.");
            return -1;
        }
        else if (principio == fin){
            principio = -1;
            fin = -1;
            return -1;
        }
        else{
            int x = datos[principio];
            principio += 1;
            return x;
        }
    }

    @Override
    public int frente() {
        if (estaVacia()){
            System.out.println("Esta Vacia.");
            return -1;
        }
        else {
            return datos[principio];
        }
    }

    @Override
    public void mostrar() {
        if (estaVacia()){
            System.out.println("Esta vacia.");
        }
        else{
            System.out.print("[frente -> ");
            for (int i = principio; i < fin; i++) {
                System.out.print(datos[i] + ",");
            }
            System.out.print(datos[fin] + " <- final]");
        }
    }

    @Override
    public Boolean estaVacia() {
        if (this.principio == -1 && this.fin == -1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean estaLlena() {
        if (this.fin == max - 1){
            return true;
        }
        else {
            return false;
        }
    }


}
