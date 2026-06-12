package Diccionari;

import Grafos.Usuario;

public interface IDictStr {
    public boolean estaLleno();
    public boolean estaVacio();
    public boolean insertar(String clave, Usuario valor);
    public boolean eliminar(String clave);
    public boolean modificar(String clave, Usuario valor);
    public Usuario recuperarValor(String clave);
    public int existe(String clave);
    public int tamanio();
    public void listarClaves();
    public void listarValores();
    public void mostrar();
}
