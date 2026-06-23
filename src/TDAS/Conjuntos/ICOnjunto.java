package TDAS.Conjuntos;

public interface ICOnjunto {
    public boolean estaVacio();
    public boolean estaLleno();
    public void insertar(String elemento);
    public void eliminar(String elemento);
    public int pertenece(String elemento);
    public int tamanio();
    public void mostrar();
    public ICOnjunto union(Conjunto conjuntoB);
    public Conjunto interseccion(Conjunto conjuntoB);
    public Conjunto diferencia(Conjunto conjuntoB);


}