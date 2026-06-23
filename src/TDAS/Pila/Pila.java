package TDAS.Pila;

public class Pila implements IPila {
    private String[] datos;
    private int tope;
    private int tamano;

    public Pila(int tamano) {
        this.tamano = tamano;
        this.datos = new String[tamano];
        this.tope = -1; // Comienza en -1 porque sumas 1 antes de insertar
    }



    @Override
    public void apilar(String elemento) {
        if (pilaLllena()){
            System.out.println("No hay espacio");
        }
        else{
            tope = tope + 1;
            datos[tope] = elemento;
            System.out.println("Elemento" + elemento + "apilado");
        }
    }

    @Override
    public String desapilar() {
        if (pilaVacia()) {
            System.out.println("No hay elementos en la pila ");
            return null;
        }
        else {
            String elementoDesapilado = datos[tope];
            tope = tope - 1;
            return elementoDesapilado;
        }
        //return 0;
    }

    @Override
    public int tope() {
        return 0;
    }

    @Override
    public int tamano() {
        return 0;
    }

    @Override
    public boolean pilaVacia() {
        return false;
    }

    @Override
    public boolean pilaVacia2() {
        return false;
    }

    @Override
    public boolean pilaLllena() {
        return false;
    }
}

