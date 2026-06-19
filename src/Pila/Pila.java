package Pila;

public class Pila implements IPila {
    private String[] datos;
    private int tope;
    private int tamano;

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
            return " ";
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

