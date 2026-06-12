package Diccionari;

import Grafos.Usuario;

import java.util.Objects;

public class DictStr implements IDictStr{
    private DatoStr[] datosDiccionario;
    private int cantidad;
    private int dimension;

    public DictStr(int dimension){
        this.dimension = dimension;
        datosDiccionario = new DatoStr[dimension];
        cantidad = 0;
    }

    @Override
    public boolean estaLleno(){
        if (cantidad == dimension){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean estaVacio() {
        if(cantidad == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean insertar(String clave, Usuario valor) {
        if (estaLleno()){
            System.out.println("Esta lleno.");
            return false;
        }
        if (existe(clave) == -1){
            datosDiccionario[cantidad] = new DatoStr(clave, valor);
            cantidad++;
            System.out.println("Clave agregada.");
            return true;
        }
        System.out.println("Clave existente");
        return false;
    }

    @Override
    public boolean eliminar(String clave) {
        int posicion = existe(clave);
        if (posicion == -1){
            System.out.println("Clave no existe.");
            return false;
        }
        for (int i = posicion; i < cantidad-1; i++){
            datosDiccionario[i] = datosDiccionario[i+1];
        }
        System.out.println("Clave eliminada.");
        cantidad--;
        return true;
    }

    @Override
    public boolean modificar(String clave, Usuario valor) {
        int posicion = existe(clave);
        if (posicion != -1){
            datosDiccionario[posicion].valor = valor;
            return true;
        }
        return false;
    }

    @Override
    public Usuario recuperarValor(String clave) {
        int posicion = existe(clave);
        if (posicion != -1){
            return datosDiccionario[posicion].valor;
        }
        else {
            System.out.println("El nombre de usuario no existe.");
            return null;
        }
    }

    @Override
    public int existe(String clave) {
        if (estaVacio()){
            return -1;
        }
        else {
            for (int i = 0; i < cantidad; i++){
                if (Objects.equals(datosDiccionario[i].clave, clave)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int tamanio() {
        return cantidad;
    }

    @Override
    public void listarClaves() {
        System.out.println("Claves: ");
        for(int i = 0; i < cantidad; i++){
            System.out.println(datosDiccionario[i].clave + " - ");
        }
        System.out.println();
    }

    @Override
    public void listarValores() {
        System.out.println("Valores: ");
        for(int i = 0; i < cantidad; i++){
            System.out.println(datosDiccionario[i].valor + " - ");
        }
        System.out.println();
    }

    @Override
    public void mostrar() {
        if (!estaVacio()){
            System.out.println("Diccionario: ");
            for (int i = 0; i < cantidad; i++){
                System.out.println(datosDiccionario[i].clave + ": " + datosDiccionario[i].valor);
            }
        }
        else {
            System.out.println("No existen elementos en el diccionario");
        }
    }
}
