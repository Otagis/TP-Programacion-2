package Grafos;

public interface ICola {
    public void encolar(int elemento);
    public int desencolar();
    public int frente();
    public void mostrar();
    public Boolean estaVacia();
    public Boolean estaLlena();
}
