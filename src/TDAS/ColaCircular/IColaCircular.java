package TDAS.ColaCircular;

public interface IColaCircular {
    public boolean encolar(String elemento);
    public Object desencolar();
    public boolean estaLlena();
    public boolean estaVacia();
    public int mostrar();
    public String recuperarFrente();
    public String frente();
}
